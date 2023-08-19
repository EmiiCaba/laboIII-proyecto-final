package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadesNoAprobadasException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AlumnoService {

    Alumno crearAlumno(AlumnoDto alumno);
    Alumno buscarAlumnoPorApellido(String apellidoAlumno) throws AlumnoNoEncontradoException;
    Alumno modificarAlumnoPorId(Integer idAlumno, Alumno alumno) throws AlumnoNoEncontradoException;
    Alumno eliminarAlumnoPorApellido( String apellidoAlumno) throws AlumnoNoEncontradoException;


    Alumno List<Asignatura> obtenerListaAsignaturas();

    Alumno agregarAsignatura(Asignatura a);
    void aprobarAsignatura(Integer materiaId, int nota, Integer dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException, AlumnoNoEncontradoException;
    Alumno puedeAprobar(Asignatura asignatura);
   Alumno aprobarAsignatura(Materia materia, int nota);

    Alumno chequearCorrelatividad(Materia correlativa);

    Alumno actualizarAsignatura(Asignatura asignatura);

}
