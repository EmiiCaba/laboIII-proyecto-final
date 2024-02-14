package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.exception.*;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.AsignaturaDao;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public  class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    private AlumnoDao alumnoDao;
    @Autowired
    private MateriaDao materiaDao;
    @Autowired
    private AsignaturaDao asignaturaDao;





    @Override
    public void chequearCorrelatividad(Materia materia, Alumno alumno) throws CorrelatividadException {
        List<Integer> correlativasRequeridas = materia.getCorrelativas();

        for (Integer correlativaId : correlativasRequeridas) {
            try {
                Materia correlativa = materiaDao.findByIdMateria(correlativaId);
                Asignatura asignaturaCorrelativa = getAsignaturaPorMateriaId(materia.getIdMateria());

                if (asignaturaCorrelativa == null || asignaturaCorrelativa.getEstado() != EstadoAsignatura.APROBADA) {
                    throw new CorrelatividadException("La correlativa con ID " + correlativaId + " no está aprobada para este alumno");
                }
            } catch (CorrelatividadException e) {
                // excepción de correlatividad
                throw e;
            } catch (Exception e) {
                throw new CorrelatividadException("Error al verificar correlatividad para la asignatura con ID " + correlativaId + ": " + e.getMessage());
            } catch (AsignaturaInexistenteException e) {
                throw new RuntimeException(e);
            }
        }
    }




    @Override
    public void aprobarAsignatura(Integer idAlumno, Integer idAsignatura, Integer nota, Integer materiaId) throws AlumnoNoEncontradoException, MateriaNotFoundException, EstadoIncorrectoException, CorrelatividadException, AsignaturaInexistenteException {
        Alumno alumno = alumnoDao.findAlumnoByID(idAlumno);
        if (alumno == null) {
            throw new AlumnoNoEncontradoException("No se encontró el alumno con ID: " + idAlumno);
        }

        Asignatura asignatura = asignaturaDao.obtenerAsignaturaPorId(idAsignatura);
        if (asignatura == null) {
            throw new MateriaNotFoundException("No se encontró la asignatura con ID: " + idAsignatura);
        }
        boolean tieneAsignatura = AlumnoService.alumnoTieneAsignatura( alumnoDao,idAlumno, idAsignatura);
        // Verificar si el alumno tiene la asignatura
        if (!tieneAsignatura) {
            throw new AsignaturaInexistenteException("El alumno no está inscrito en la asignatura con ID: " + idAsignatura);
        }

        // Verificar correlatividades
        try {
            chequearCorrelatividad(asignatura.getMateria(), alumno);
        } catch (CorrelatividadException e) {
            throw new CorrelatividadException("No se pueden aprobar todas las correlativas para esta asignatura: " + e.getMessage());
        }

        // Aprobar asignatura
        if (nota >= 6) {
            asignatura.setEstado(EstadoAsignatura.APROBADA);
        } else if (nota >= 4) {
            asignatura.setEstado(EstadoAsignatura.CURSADA);
        } else {
            throw new EstadoIncorrectoException("La nota proporcionada no es suficiente para aprobar la asignatura");
        }

        asignatura.setNota(nota);
        // Guardar asignatura actualizada
        asignaturaDao.guardarAsignatura(asignatura, asignatura.getMateria());
    }





    public void crearAsignatura(Alumno alumno2, Integer materiaId, Integer nota) throws AlumnoNoEncontradoException, MateriaNotFoundException {
        if (alumno2 == null) {
            throw new AlumnoNoEncontradoException("El alumno proporcionado es nulo");
        }

        Alumno alumno = alumnoDao.loadAlumnoPorId(alumno2);
        if (alumno == null) {
            throw new AlumnoNoEncontradoException("No se encontró el alumno con el ID proporcionado");
        }

        Materia materia = materiaDao.findByIdMateria(materiaId);
        if (materia == null) {
            throw new MateriaNotFoundException("No se encontró la materia con ID: " + materiaId);
        }

        // Crear la nueva asignatura con la materia y nota
        Asignatura nuevaAsignatura = new Asignatura("Nombre de la Asignatura", nota, materia);

        // Agregar la nueva asignatura a la lista de asignaturas del alumno
        List<Asignatura> asignaturas = alumno.getAsignaturas();
        asignaturas.add(nuevaAsignatura);
        alumno.setAsignaturas(asignaturas);

        // Guardar los cambios en la base de datos
        alumnoDao.saveAlumno(alumno);
    }


    @Override
    public List<Asignatura> getAllAsignaturas() {
        List<Asignatura> allAsignaturas = new ArrayList<>();

        // Obtener la lista de todos los alumnos
        List<Alumno> allAlumnos = alumnoDao.getAllAlumnos();

        // Iterar sobre cada alumno y agregar sus asignaturas a la lista total
        for (Alumno alumno : allAlumnos) {
            List<Asignatura> asignaturasAlumno = alumno.getAsignaturas();
            allAsignaturas.addAll(asignaturasAlumno);
        }

        return allAsignaturas;
    }


    public List<Integer> obtenerListaCorrelativas(Integer materiaId) throws MateriaNotFoundException {
        Materia materia = materiaDao.findByIdMateria(materiaId);
        if (materia == null) {
            throw new MateriaNotFoundException("No se encontró la materia con ID: " + materiaId);
        }

        // Obtener la lista de correlatividades
        List<Integer> correlatividades = materia.getCorrelativas();

        // Devolver la lista de correlatividades
        return correlatividades;
    }

    public Asignatura getAsignaturaPorMateriaId( Integer materiaId ) throws AsignaturaInexistenteException {
        for (Asignatura asignatura : getAllAsignaturas()) {
            if (asignatura.getMateriaId()== (materiaId)){
                return asignatura;
            }
        }
        throw new AsignaturaInexistenteException("No se encontró la asignatura");
    }

    @Override
    public Asignatura obtenerAsignaturaPorId( int idAsignatura) throws AsignaturaNotFoundException {
        Asignatura asignatura = asignaturaDao.obtenerAsignaturaPorId(idAsignatura);
        if (asignatura == null) {
            throw new AsignaturaNotFoundException();
        }
        return asignatura;
    }

}






