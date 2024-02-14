package ar.edu.utn.frbb.tup.business;
import ar.edu.utn.frbb.tup.business.impl.AsignaturaNotFoundException;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.exception.*;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;

public interface AsignaturaService {
    void chequearCorrelatividad(Materia correlativa, Alumno alumno) throws CorrelatividadException;

    void aprobarAsignatura(Integer idAlumno, Integer idAsignatura, Integer nota, Integer materiaId) throws AlumnoNoEncontradoException, MateriaNotFoundException, EstadoIncorrectoException, CorrelatividadException, AsignaturaInexistenteException;

    void crearAsignatura(Alumno alumno2, Integer materiaId, Integer nota) throws AlumnoNoEncontradoException, MateriaNotFoundException;
    List<Integer> obtenerListaCorrelativas(Integer materiaId) throws MateriaNotFoundException;

    List<Asignatura> getAllAsignaturas();

    Asignatura obtenerAsignaturaPorId(int idAsignatura) throws AsignaturaNotFoundException;
}


