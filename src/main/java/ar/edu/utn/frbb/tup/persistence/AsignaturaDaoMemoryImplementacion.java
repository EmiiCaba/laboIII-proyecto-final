package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class AsignaturaDaoMemoryImplementacion implements AsignaturaDao {
    private Map<Integer, Asignatura> repositorioAsignatura = new HashMap<>();

    @Override
    public List<Asignatura> obtenerTodasLasAsignaturas() {
        return new ArrayList<>(repositorioAsignatura.values());
    }

    @Override
    public Asignatura obtenerAsignaturaPorId(int id) {
        return repositorioAsignatura.get(id);
    }

      @Override
    public void guardarAsignatura(Asignatura asignatura, Materia materia) {
        // Verifica que asignatura no sea nula
        if (asignatura == null || materia.getIdMateria() == 0) {
            throw new IllegalArgumentException("La asignatura o su ID de materia no pueden ser nulos");
        } else {
            // Guarda la asignatura en el repositorio
            repositorioAsignatura.put(materia.getIdMateria(), asignatura);
        }
    }

    @Override
    public void actualizarAsignatura(Materia materia, Asignatura asignatura) {
        // Verifica que materia no sea nulo
        if (materia == null || materia.getIdMateria() == 0) {
            throw new IllegalArgumentException("La asignatura, su materia o el ID de la materia no pueden ser nulos");
        } else {
            // Verifica si asignatura no es nulo
            if (asignatura != null) {
                // Actualiza la asignatura en el repositorio
                repositorioAsignatura.put(materia.getIdMateria(), asignatura);
            } else {
                // Lanza una excepción si asignatura es nulo
                throw new IllegalArgumentException("La asignatura no puede ser nula");
            }
        }
    }




    @Override
    public void eliminarAsignatura(int idAsignatura) {
        repositorioAsignatura.remove(idAsignatura);
    }
}



