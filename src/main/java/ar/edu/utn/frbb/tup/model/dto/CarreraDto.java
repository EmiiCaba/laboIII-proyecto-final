package ar.edu.utn.frbb.tup.model.dto;

import ar.edu.utn.frbb.tup.model.Materia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarreraDto {
    private String nombre;
    private int cantidadAnios;
    private List<Materia> materiasList;
    private List<Integer> profesoresIdsList; // Cambiado a lista de IDs de profesores



    public CarreraDto(String nombre, int cantidadAnios, List<Materia> materiasList, List<Integer> profesoresIdsList) {
        this.nombre = nombre;
        this.cantidadAnios = cantidadAnios;
        this.materiasList = materiasList;
        this.profesoresIdsList = profesoresIdsList;
    }
}
