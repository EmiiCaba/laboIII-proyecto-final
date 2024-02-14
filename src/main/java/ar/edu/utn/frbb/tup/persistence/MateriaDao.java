package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;

public interface MateriaDao {
     void save(Materia materia); // Método para guardar una sola materia
     void saveAll(List<Materia> materias); // Método para guardar una lista de materias

     Materia findByIdMateria(Integer idMateria) throws MateriaNotFoundException;

     List<Materia> getAllMaterias();


     void deleteByIdMateria(Integer idMateria) throws MateriaNotFoundException;
}
