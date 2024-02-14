package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;

import java.util.List;


public interface AlumnoDao {

    Alumno saveAlumno(Alumno a) throws AlumnoNoEncontradoException;

    Alumno loadAlumnoPorId(Alumno alumno) throws AlumnoNoEncontradoException;


    Alumno findAlumnoByID(Integer idAlumno) throws AlumnoNoEncontradoException;

    void delete(Alumno alumno) throws AlumnoNoEncontradoException;

    List<Alumno> getAllAlumnos();
}
