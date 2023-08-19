package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public abstract class ProfesorDaoMemoryImpl implements ProfesorDao {
    private static Map<String, Profesor> repositorioProfesores = new HashMap<>();

    @Override
    public Profesor saveProfesor(Profesor profesor) {

        return repositorioProfesores.put(profesor.getIdProfesor(), profesor);
    }


    @Override
    public Profesor findProfesorById(String idProfesor) throws ProfesorNoEncontradoException {
        if (!repositorioProfesores.containsKey(idProfesor)) {
            throw new ProfesorNoEncontradoException("No se encontro el profesor");
        } else {
            return repositorioProfesores.get(idProfesor);
        }
    }

    @Override
    public Profesor borrarProfesor(Profesor profesor) throws ProfesorNoEncontradoException {
        if (!repositorioProfesores.containsKey(profesor.getIdProfesor())) {
            throw new ProfesorNoEncontradoException("No se encontro el profesor");
        } else {
            for (Profesor p : repositorioProfesores.values()) {
                if (p.equals(profesor)) {
                    repositorioProfesores.remove(profesor);
                }
            }

        }

      return profesor;
    }
    @Override
    public Profesor deleteProfesor(Profesor profesor) throws ProfesorNoEncontradoException {
        if (! repositorioProfesores.containsKey(profesor.getIdProfesor())) {
            throw new ProfesorNoEncontradoException("No se encontro el Alumno");}
        else{
            for (Profesor p : repositorioProfesores.values()) {
                if ( p.equals(profesor)){
                    repositorioProfesores.remove(profesor);
                }
            }}

        return profesor;
    }

    public Profesor getProfesor(String idProfesor) {
        return null;
    }

    Profesor buscarProfesorPorApellido () {


        return buscarProfesorPorApellido();
    }

    public Profesor actualizarProfesor() {
        return actualizarProfesor(null);
    }



}