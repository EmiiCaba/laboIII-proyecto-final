package ar.edu.utn.frbb.tup.model.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class MateriaDto {
    private String nombre;
    private int anio;
    private int cuatrimestre;
    private Integer idProfesor;
    private List<Integer> correlativas;
    private Integer idCarrera; // Añadimos el campo idCarrera

    public MateriaDto(String nombre, int anio, int cuatrimestre, Integer idProfesor, List<Integer> correlativas, Integer idCarrera) {
        this.nombre = nombre;
        this.anio = anio;
        this.cuatrimestre = cuatrimestre;
        this.idProfesor = idProfesor;
        this.correlativas = correlativas;
        this.idCarrera = idCarrera; // Asignamos el valor del parámetro idCarrera al campo correspondiente
    }
    public MateriaDto() {
    }
}
