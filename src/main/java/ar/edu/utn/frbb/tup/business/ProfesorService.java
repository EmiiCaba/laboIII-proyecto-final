package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;


public interface ProfesorService {

    Profesor crearProfesor(ProfesorDto profesorDto) throws ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
    Profesor buscarProfesorPorId(Integer idProfesor) throws ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
    Profesor  modificarProfesorPorId(Integer idProfesor, Profesor profesor) throws ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    void eliminarProfesorPorId(Integer idProfesor) throws ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    void asignarProfesorAMateria(Integer idMateria, Integer idProfesor) throws MateriaNotFoundException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException, ProfesorNoEncontradoException;

    void quitarProfesorDeMateria(int idMateria) throws MateriaNotFoundException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    List<Materia> obtenerMateriasOrdenadasAlfabeticamentePorIdProfesor(Integer idProfesor) throws ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
}
