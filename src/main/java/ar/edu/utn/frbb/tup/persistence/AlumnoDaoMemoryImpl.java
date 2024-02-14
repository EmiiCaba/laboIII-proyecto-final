package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlumnoDaoMemoryImpl implements AlumnoDao {

    private static Map<Integer, Alumno> repositorioAlumnos = new HashMap<>();




    @Override
    public Alumno saveAlumno(Alumno alumno) throws AlumnoNoEncontradoException {
        if (repositorioAlumnos.containsKey(alumno.getIdAlumno())) {
            throw new AlumnoNoEncontradoException("Alumno duplicado");
        } else {
            repositorioAlumnos.put(alumno.getIdAlumno(), alumno);
            return alumno;
        }
    }


    @Override
    public Alumno loadAlumnoPorId(Alumno alumno) {
        return repositorioAlumnos.get(alumno.getIdAlumno());
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
    @Override
    public List<Alumno> getAllAlumnos() {
        return new ArrayList<>(repositorioAlumnos.values());
    }
}
