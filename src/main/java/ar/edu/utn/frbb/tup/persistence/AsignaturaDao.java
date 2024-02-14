package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;


import java.util.List;

public interface AsignaturaDao {
    List<Asignatura> obtenerTodasLasAsignaturas();
   Asignatura obtenerAsignaturaPorId(int id);
   void guardarAsignatura(Asignatura asignatura, Materia materia);

   void actualizarAsignatura(Materia materia, Asignatura asignatura);

   void eliminarAsignatura(int id);
}



