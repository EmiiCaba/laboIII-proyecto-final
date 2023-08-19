package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AlumnoDaoMemoryImpl implements AlumnoDao {

    private static Map<Integer, Alumno> repositorioAlumnos = new HashMap<>();

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        repositorioAlumnos.put(alumno.getIdAlumno(), alumno);
        return alumno;
    }

    @Override
    public Alumno findAlumnoByLastName(String apellidoAlumno) throws AlumnoNoEncontradoException {
        for (Alumno a : repositorioAlumnos.values()) {
            if (a.getApellido().equals(apellidoAlumno)) {
                return a;
            }
        }
        throw new AlumnoNoEncontradoException("No se encontró ningún alumno con el apellido " + apellidoAlumno);
    }

    @Override
    public Alumno loadAlumnoPorDni(Integer dni) throws AlumnoNoEncontradoException {
        for (Alumno a : repositorioAlumnos.values()) {
            if (a.getDni().equals(dni)) {
                return a;
            }
        }
        throw new AlumnoNoEncontradoException("No se encontró ningún alumno con el DNI " + dni);
    }

    @Override
    public Alumno findAlumnoByID(Integer idAlumno) throws AlumnoNoEncontradoException {
        if (repositorioAlumnos.containsKey(idAlumno)) {
            return repositorioAlumnos.get(idAlumno);
        } else {
            throw new AlumnoNoEncontradoException("No se encontró el alumno con ID " + idAlumno);
        }
    }

    @Override
    public void delete(Alumno alumno) throws AlumnoNoEncontradoException {
        if (repositorioAlumnos.containsKey(alumno.getIdAlumno())) {
            repositorioAlumnos.remove(alumno.getIdAlumno());
        } else {
            throw new AlumnoNoEncontradoException("No se encontró el alumno a eliminar");
        }
    }
}
