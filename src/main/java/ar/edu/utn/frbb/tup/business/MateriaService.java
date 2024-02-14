package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.business.impl.ProfesorNotFoundException;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;

public interface MateriaService {


     void borrarMateria(Integer idMateria) throws MateriaNotFoundException;

    Materia crearMateria(MateriaDto materiaDto, Carrera idCarrera, Profesor profesor) throws ProfesorNoEncontradoException, MateriaNotFoundException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    void asignarProfesorAMateria(Integer idMateria, Integer idProfesor) throws MateriaNotFoundException, ProfesorNotFoundException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    Materia buscarMateriaPorId(Integer idMateria) throws MateriaNotFoundException;

    List<Integer> obtenerCorrelatividades(List<Integer> idsCorrelatividades) throws MateriaNotFoundException;

    List<Materia> obtenerMateriasSinProfesor();

    List<Materia> obtenerTodasLasMateriasConDetalles();

    List<Integer> obtenerTodosLosIdsMaterias();
}


