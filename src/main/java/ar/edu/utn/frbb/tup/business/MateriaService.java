package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;

public interface MateriaService {
    static Materia buscarMateriaPorId(int id) {
        return null;
    }

    Materia crearMateria(MateriaDto inputData) throws IllegalArgumentException, ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

    List<Materia> getAllMaterias();

     Materia buscarMateria();

    Materia getMateriaById(String idMateria) throws MateriaNotFoundException;
}
