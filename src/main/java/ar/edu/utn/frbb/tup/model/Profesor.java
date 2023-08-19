package ar.edu.utn.frbb.tup.model;

import ar.edu.utn.frbb.tup.business.RandomIDGenerateService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Profesor {

   private Integer idProfesor ;
    private  String nombre;
    private  String apellido;
    private String titulo;

    private List<Materia> materiasDictadas;

    RandomIDGenerateService randomIDGenerateService;
    public Profesor() {randomIDGenerateService = RandomIDGenerateService.getInstance();
        this.idProfesor = Integer.parseInt(randomIDGenerateService.generateId(5));
    }

    public Profesor(String nombre, String apellido, String titulo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
        this.idProfesor= Integer.parseInt(RandomIDGenerateService.getInstance().generateId(5));

    }



}
