package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public  class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorDao profesorDao;
    @Autowired
    private MateriaDao materiaDao;
    @Autowired
    private MateriaService materiaService;
    @Override
    public Profesor crearProfesor(ProfesorDto profesor)throws ProfesorNoEncontradoException {
        Profesor p = new Profesor();
        p.setNombre(profesor.getNombre());
        p.setApellido(profesor.getApellido());
        p.setTitulo(profesor.getTitulo());
        profesorDao.saveProfesor(p);
        return p;
    }

    @Override
    public Profesor buscarProfesorPorId(Integer idProfesor) throws ProfesorNoEncontradoException {
        // Buscar el profesor por id
        Profesor profesor = profesorDao.findProfesorById(idProfesor);

        // Verificar si el profesor existe
        if (profesor == null) {
            throw new ProfesorNoEncontradoException("No se encontró ningún profesor con este ID " + idProfesor);
        }
        return profesor;
    }
    public Profesor modificarProfesorPorId(Integer idProfesor, Profesor profesor) throws ProfesorNoEncontradoException {
        // Buscar el profesor por su ID, si existe
        Profesor profesorAModificar = profesorDao.findProfesorById(idProfesor);
        if (profesorAModificar == null) {
            throw new ProfesorNoEncontradoException("No se encontró ningun profesor con este ID: " + idProfesor);
        } else {
            profesorAModificar.setNombre(profesor.getNombre());
            profesorAModificar.setApellido(profesor.getApellido());
            profesorAModificar.setTitulo(profesor.getTitulo());

            return profesorDao.saveProfesor(profesorAModificar);
        }
    }

    public void eliminarProfesorPorId(Integer idProfesor) throws ProfesorNoEncontradoException {
        Profesor profesor = profesorDao.findProfesorById(idProfesor);

        if (profesor == null) {
            throw new ProfesorNoEncontradoException("No se encontró el profesor con el ID proporcionado");
        }

        // Realizar las operaciones necesarias para desasignar al profesor de las carreras, eliminar sus asignaciones, etc.
        // ...

        profesorDao.deleteProfesor(profesor.getIdProfesor()); // Eliminar al profesor
    }

    @Override
    public void asignarProfesorAMateria(Integer idMateria, Integer idProfesor) throws MateriaNotFoundException, ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException {
        // Obtener la materia por su ID

        Materia materia = materiaDao.findByIdMateria(idMateria);
        if (materia == null) {
            throw new MateriaNotFoundException("No se encontró una materia con el ID: " + idMateria);
        }

        // Buscar al profesor por su ID
        Profesor profesor = buscarProfesorPorId(idProfesor);

        // Asignar el profesor a la materia
        materia.setIdProfesor(profesor.getIdProfesor());

        // Guardar la materia actualizada en la base de datos
        materiaDao.save(materia);
    }

    @Override
    public void quitarProfesorDeMateria(int idMateria) throws MateriaNotFoundException {
        Materia materia = materiaDao.findByIdMateria(idMateria);
        materia.setIdProfesor(0);  // Asignar profesor como 0 (sin profesor)
        materiaDao.save(materia);
    }
    @Override
    public List<Materia> obtenerMateriasOrdenadasAlfabeticamentePorIdProfesor(Integer idProfesor) throws ProfesorNoEncontradoException {
        if (idProfesor == null) {
            throw new IllegalArgumentException("El ID del profesor no puede ser nulo");
        }

        if (idProfesor == -1) {
            // Si el ID del profesor es 0, devolver todas las materias sin profesor asignado
            return materiaService.obtenerMateriasSinProfesor();
        }

        Profesor profesor = profesorDao.findProfesorById(idProfesor);
        if (profesor == null) {
            throw new ProfesorNoEncontradoException("No se encontró ningún profesor con este ID " + idProfesor);
        }

        List<Materia> materias = profesor.getMateriasDictadas();

        // Ordenar las materias alfabéticamente por su nombre
        Collections.sort(materias, Comparator.comparing(Materia::getNombre));;


        return materias;
    }




}




