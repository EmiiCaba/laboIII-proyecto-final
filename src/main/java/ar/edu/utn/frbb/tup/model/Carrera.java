package ar.edu.utn.frbb.tup.model;

import ar.edu.utn.frbb.tup.persistence.CarreraDao;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@EqualsAndHashCode
public class Carrera {
    private CarreraDao carreraDao;
    private int idCarrera;
    private  String nombre;
    private int cantidadAnios;
    private List<Materia> materiasList;
    private List<Profesor> profesoresList = new ArrayList<>(); //  idProfesor es una lista para manejar varios profesores
    private static Integer contador = 0;

    public Carrera(String nombre, int cantidadAnios, List<Materia> materiasList, List<Profesor> profesoresList) {
        setIdCarrera();
        this.nombre = nombre;
        this.cantidadAnios = cantidadAnios;
        this.materiasList = materiasList;
        this.profesoresList = profesoresList;
    }

    public void setIdCarrera() {
        this.idCarrera = ++contador;
    }


}