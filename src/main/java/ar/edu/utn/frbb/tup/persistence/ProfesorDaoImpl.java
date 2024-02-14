package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.stereotype.Repository;

import java.util.*;

/*@Repository
public class ProfesorDaoImpl implements ProfesorDao {
    private Map<Integer, Profesor> repositorioProfesores = new HashMap<>();

    @Override
    public Profesor loadProfesorbyId(Profesor profesor) throws ProfesorNoEncontradoException {
        repositorioProfesores.replace(profesor.getIdProfesor(), profesor);
        return profesor;
    }

    @Override
    public Profesor saveProfesor(Profesor profesor) {

        return repositorioProfesores.put(profesor.getIdProfesor(), profesor);
    }


    @Override
    public Profesor findProfesorById(Integer idProfesor) throws ProfesorNoEncontradoException {
        if (!repositorioProfesores.containsKey(idProfesor)) {
            throw new ProfesorNoEncontradoException("No se encontro el profesor");
        } else {
            return repositorioProfesores.get(idProfesor);
        }
    }

    @Override
    public Profesor deleteProfesor(Integer idProfesor) throws ProfesorNoEncontradoException {
        Profesor profesor = repositorioProfesores.get(idProfesor);
        if (profesor != null) {
            repositorioProfesores.remove(idProfesor);
            return profesor; // Se elimina el profesor y se retorna
        } else {
            throw new ProfesorNoEncontradoException("No se encontró el profesor a eliminar");
        }
    }
*/

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProfesorDaoImpl implements ProfesorDao {

    private static Map<Integer, Profesor> repositorioProfesores = new HashMap<>();



    @Override
    public Profesor loadProfesorbyId(Profesor profesor) throws ProfesorNoEncontradoException {
        if (!repositorioProfesores.containsKey(profesor.getIdProfesor())) {
            throw new ProfesorNoEncontradoException("No se encontró el profesor");
        }
        return repositorioProfesores.get(profesor.getIdProfesor());
    }


    @Override
    public Profesor saveProfesor(Profesor profesor) {
        return repositorioProfesores.put(profesor.getIdProfesor(), profesor);
    }

    @Override
    public Profesor findProfesorById(Integer idProfesor) throws ProfesorNoEncontradoException {
        if (!repositorioProfesores.containsKey(idProfesor)) {
            throw new ProfesorNoEncontradoException("No se encontró el profesor");
        } else {
            return repositorioProfesores.get(idProfesor);
        }
    }


    @Override
    public Profesor deleteProfesor(Integer idProfesor) throws ProfesorNoEncontradoException {
        Profesor profesor = repositorioProfesores.get(idProfesor);
        if (profesor != null) {
            repositorioProfesores.remove(idProfesor);
            return profesor; // Se elimina el profesor y se retorna
        } else {
            throw new ProfesorNoEncontradoException("No se encontró el profesor a eliminar");
        }
    }

    @Override
    public List<Profesor> getAllProfesores() {
        return new ArrayList<>(repositorioProfesores.values());
    }
    // Método para guardar una lista de profesores
    @Override
    public List<Profesor> saveAll(List<Profesor> profesores) {
        List<Profesor> profesoresGuardados = new ArrayList<>();
        for (Profesor profesor : profesores) {
            saveProfesor(profesor); // Llamamos al método saveProfesor para guardar cada profesor individualmente
            profesoresGuardados.add(profesor);
        }
        return profesoresGuardados;
    }
}