package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

public interface ProfesorDao {
    public Profesor getProfesor(String idProfesor);
    public Profesor buscarProfesorPorApellido (String apellidoProfesor) throws ProfesorNoEncontradoException;
    public Profesor actualizarProfesor(String idProfesor) throws ProfesorNoEncontradoException;

    public Profesor saveProfesor(Profesor profesor) throws ProfesorNoEncontradoException;

    Profesor findProfesorById(String idProfesor) throws ProfesorNoEncontradoException;

    Profesor borrarProfesor(Profesor profesor) throws ProfesorNoEncontradoException;

    Profesor deleteProfesor(Profesor profesor) throws ProfesorNoEncontradoException;
}


