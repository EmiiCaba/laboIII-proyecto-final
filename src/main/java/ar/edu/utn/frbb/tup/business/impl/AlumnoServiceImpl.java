package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.*;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.*;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoDao alumnoDao;
    @Autowired
    private  AsignaturaService asignaturaService;

    @Override
    public void aprobarAsignatura(String materiaId, int nota, Integer dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException, AlumnoNoEncontradoException {
        Asignatura a = asignaturaService.getAsignatura(materiaId, dni);
        for (Materia m:a.getMateria().getCorrelatividades()) {
            Asignatura correlativa = asignaturaService.getAsignatura(m.getMateriaId(), dni);
            if (correlativa == null ||!EstadoAsignatura.APROBADA.equals(correlativa.getEstado())) {
                throw new CorrelatividadesNoAprobadasException("La materia " + m.getNombre() + " debe estar aprobada para aprobar " + a.getNombreAsignatura());
            }
        }
        a.aprobarAsignatura(nota);
        asignaturaService.actualizarAsignatura(a);
        Alumno alumno = alumnoDao.loadAlumnoPorDni(dni);
        alumno.actualizarAsignatura(a);
        alumnoDao.saveAlumno(alumno);
    }

    @Override
    public Alumno crearAlumno(AlumnoDto alumno) {
        Alumno a = new Alumno();
        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setDni((int)alumno.getDni());
        alumnoDao.saveAlumno(a);
        return a;
    }

    @Override
    public Alumno buscarAlumnoPorApellido(String apellidoAlumno) throws AlumnoNoEncontradoException {
        // Buscar el alumno por su apellido
        Alumno alumno =alumnoDao.findAlumnoByLastName(apellidoAlumno);

        // Verificar si el alumno existe
        if (alumno == null) {
            throw new AlumnoNoEncontradoException("No se encontró ningún alumno con el apellido " + apellidoAlumno);
       }
        return alumnoDao.findAlumnoByLastName(apellidoAlumno);
    }

    @Override
    public Alumno eliminarAlumnoPorApellido(String apellidoAlumno) throws AlumnoNoEncontradoException {
        // Buscar el alumno por su apellido
        Alumno alumno =alumnoDao.findAlumnoByLastName(apellidoAlumno);

        // Verificar si el alumno existe
        if (alumno == null) {
            throw new AlumnoNoEncontradoException("No se encontró ningún alumno con el apellido " + apellidoAlumno);
        }

        // Eliminar el alumno
        alumnoDao.delete(alumno);

        return alumno;
    }

    @Override
    public Alumno modificarAlumnoPorId(Integer idAlumno, Alumno alumno) throws AlumnoNoEncontradoException {
        // Buscar el alumno por su ID, si existe

            Alumno alumnoExistente = alumnoDao.findAlumnoByID( idAlumno) ;
            if (alumnoExistente == null) {
                throw new AlumnoNoEncontradoException("No se encontró ningún alumno con este : " + idAlumno); }

            alumnoExistente.setNombre(alumno.getNombre());
            alumnoExistente.setApellido(alumno.getApellido());
            alumnoExistente.setDni((int) alumno.getDni());
            return alumnoDao.saveAlumno(alumnoExistente); }

    public void agregarAsignatura(Asignatura a){

        this.asignaturas.add(a);
    }

    @Override
    public void aprobarAsignatura(Integer materiaId, int nota, Integer dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException, AlumnoNoEncontradoException {

    }

    public List<Asignatura> obtenerListaAsignaturas(){

        return this.asignaturas;
    }


    private void chequearCorrelatividad(Materia correlativa) throws CorrelatividadException {
        for (Asignatura a:
                asignaturas) {
            if (correlativa.getNombre().equals(a.getNombreAsignatura())) {
                if (!EstadoAsignatura.APROBADA.equals(a.getEstado())) {
                    throw new CorrelatividadException("La asignatura " + a.getNombreAsignatura() + " no está aprobada");
                }
            }
        }
    }

    @Override
    public Alumno actualizarAsignatura(Asignatura asignatura) {
        return null;
    }


    public boolean puedeAprobar(Asignatura asignatura) {
        return true;
    }

    @Override
    public Alumno aprobarAsignatura(Materia materia, int nota) {
        return null;
    }


}






}
