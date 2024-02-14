package ar.edu.utn.frbb.tup.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Materia {

    private int idMateria;
    private String nombre;
    private int anio;
    private int cuatrimestre;
    private List<Integer> correlatividades;
    private int idProfesor;
    private int idCarrera;
    private static Integer contador = 0;



    public Materia(String nombre, int anio, int cuatrimestre, List<Integer> correlatividades, int idCarrera,  Integer idProfesor) {
        setIdMateria();
        this.nombre = nombre;
        this.anio = anio;
        this.cuatrimestre = cuatrimestre;
        this.correlatividades = correlatividades;
        this.idCarrera = idCarrera;
        if (idProfesor == null) {
            // Si idProfesor es null, establece un valor predeterminado, por ejemplo, -1
            this.idProfesor = -1; // o cualquier otro valor predeterminado que desees
        } else {
            this.idProfesor = idProfesor;
        }
    }

    public void setIdMateria() {
        this.idMateria = ++contador;
    }
    public int getIdMateria() {
        return idMateria;
    }
    public List<Integer> getCorrelativas() {
        return correlatividades;
    }
    public void setCorrelativas(List<Integer> correlativas) {
        this.correlatividades = correlativas;
    }


    @Override
    public int hashCode() {
        return Objects.hash(idMateria, nombre, anio, cuatrimestre, idProfesor, correlatividades);
    }
    @Override
    public String toString() {
        return "Materia{" +
                "materiaId=" + idMateria +
                ", nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", cuatrimestre=" + cuatrimestre +
                ", correlativas=" + correlatividades+
                '}';
    }
}
