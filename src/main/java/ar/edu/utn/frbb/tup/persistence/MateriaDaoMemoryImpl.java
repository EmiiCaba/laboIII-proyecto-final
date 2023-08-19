package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class MateriaDaoMemoryImpl implements MateriaDao {

    private static final Map<String, Materia> repositorioMateria = new HashMap<>();
    @Override
    public Materia save(Materia materia) {

        repositorioMateria.put(materia.getMateriaId(), materia);
        return materia;
    }

    @Override
    public Materia findById(String idMateria) throws MateriaNotFoundException {
        for (Materia m:
             repositorioMateria.values()) {
            if (m.getMateriaId()== idMateria){
                return m;
            }
        }
        throw new MateriaNotFoundException("No se encontró la materia con id " + idMateria);
    }
}
