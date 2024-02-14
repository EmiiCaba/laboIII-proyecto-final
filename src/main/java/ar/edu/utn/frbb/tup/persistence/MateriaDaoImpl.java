package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MateriaDaoImpl implements MateriaDao {
    private static Map<Integer, Materia> repositorioMateria = new HashMap<>();

    @Override
    public void save(Materia materia) {
        repositorioMateria.put(materia.getIdMateria(), materia);
    }

    @Override
    public void saveAll(List<Materia> materias) {
        for (Materia materia : materias) {
            save(materia);
        }
    }
    @Override
    public Materia findByIdMateria(Integer idMateria) throws MateriaNotFoundException {
        if (repositorioMateria.containsKey(idMateria)) {
            return repositorioMateria.get(idMateria);
        } else {
            throw new MateriaNotFoundException("No se encontró una Materia con el ID: " + idMateria);
        }
    }

    @Override
    public List<Materia> getAllMaterias() {
        return new ArrayList<>(repositorioMateria.values());
    }


    @Override
    public void deleteByIdMateria(Integer idMateria) throws MateriaNotFoundException {
        if (repositorioMateria.containsKey(idMateria)) {
            repositorioMateria.remove(idMateria);
        } else {
            throw new MateriaNotFoundException("No se encontró una Materia con el ID: " + idMateria);
        }
    }

}












