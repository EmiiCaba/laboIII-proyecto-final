package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import org.springframework.stereotype.Repository;


public interface AlumnoDao {

    Alumno saveAlumno(Alumno a);

    Alumno findAlumnoByLastName(String apellidoAlumno) throws AlumnoNoEncontradoException;

    Alumno loadAlumnoPorDni(Integer dni) throws AlumnoNoEncontradoException;

    Alumno findAlumnoByID(Integer idAlumno) throws AlumnoNoEncontradoException;


    void delete(Alumno alumno) throws AlumnoNoEncontradoException;
}
