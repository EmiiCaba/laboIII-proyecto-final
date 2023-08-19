package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.ProfesorService;

import ar.edu.utn.frbb.tup.model.Profesor;

import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public abstract class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorDao profesorDao;


    @Override
    public Profesor buscarProfesorPorApellido(String apellidoProfesor) throws ProfesorNoEncontradoException {
        // Buscar el profesro  por su apellido

        Profesor profesor = profesorDao.buscarProfesorPorApellido(apellidoProfesor);

        // Verificar si el profesor existe
        if (profesor == null) {
            throw new ProfesorNoEncontradoException("No se encontró ningún alumno con el apellido " + apellidoProfesor);
        }
        return profesor;
    }


    @Override
    public Profesor borrarProfesorPorApellido(String apellidoProfesor) throws ProfesorNoEncontradoException {
        // elimina el profesor por su apellido
        Profesor profesor = profesorDao.buscarProfesorPorApellido(apellidoProfesor);

        // Verificar si el profesor existe
        if (profesor == null) {
            throw new ProfesorNoEncontradoException("No se encontró ningún profesor  con el apellido " + apellidoProfesor);
        } else {
            // Eliminar el profesor
            profesorDao.deleteProfesor(profesor);

            return profesor;
        }
    }


    public Profesor modificarProfesorPorId(String idProfesor, Profesor profesor) throws ProfesorNoEncontradoException {
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


    @Override
     public Profesor crearProfesor(ProfesorDto profesor)throws ProfesorNoEncontradoException {
            Profesor p = new Profesor();
            p.setNombre(profesor.getNombre());
            p.setApellido(profesor.getApellido());
            p.setTitulo(profesor.getTitulo());
            profesorDao.saveProfesor(p);
            return p;
    }
}




