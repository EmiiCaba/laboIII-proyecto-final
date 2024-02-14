package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;


public interface AlumnoService {
    Alumno crearAlumno(AlumnoDto alumnoDto) throws AlumnoExistenteException, AlumnoNoEncontradoException;

    Alumno modificarAlumnoPorId(Integer idAlumno, Alumno alumno) throws AlumnoNoEncontradoException;

    Alumno eliminarAlumnoPorId(Integer idAlumno) throws AlumnoNoEncontradoException;



      Alumno buscarAlumnoPorId(Integer idAlumno) throws AlumnoNoEncontradoException;

      void agregarAsignaturaAAlumno(Integer idAlumno, Integer idAsignatura) throws AlumnoNoEncontradoException;

    static boolean alumnoTieneAsignatura(AlumnoDao alumnoDao, Integer idAlumno, Integer idAsignatura) {
        return false;
    }


}

