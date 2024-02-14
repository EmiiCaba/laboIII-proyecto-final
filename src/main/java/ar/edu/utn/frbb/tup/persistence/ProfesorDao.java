package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

import java.util.List;

public interface ProfesorDao {


     Profesor loadProfesorbyId(Profesor profesor) throws ProfesorNoEncontradoException;
     Profesor saveProfesor(Profesor profesor) throws ProfesorNoEncontradoException;

    Profesor findProfesorById(Integer idProfesor) throws ProfesorNoEncontradoException;


     Profesor deleteProfesor(Integer idProfesor) throws ProfesorNoEncontradoException;


    List<Profesor> getAllProfesores();

    // Método para guardar una lista de profesores
    List<Profesor> saveAll(List<Profesor> profesores);
}


