package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException;




public interface ProfesorService {


    Profesor buscarProfesorPorApellido(String apellidoProfesor) throws ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    Profesor borrarProfesorPorApellido(String apellidoProfesor) throws ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    Profesor modificarProfesorPorId(Integer idProfesor) throws ProfesorNoEncontradoException;


    Profesor crearProfesor(ProfesorDto profesorDto) throws ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
    Profesor ObtenerMateriasPorId(Integer idProfesor) throws ProfesorNoEncontradoException;

}Profesor modificarProfesorPorId(Integer idProfesor) throws ProfesorNoEncontradoException;
