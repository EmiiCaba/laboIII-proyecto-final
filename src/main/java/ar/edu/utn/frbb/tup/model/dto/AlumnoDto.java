package ar.edu.utn.frbb.tup.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter

public class AlumnoDto {
    private String nombre;
    private String apellido;
    private Integer dniAlumno;
    private List<AsignaturaDto> asignaturas;
    private List<AsignaturaDto> correlativas;


    public AlumnoDto(String nombre, String apellido, Integer dniAlumno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniAlumno = dniAlumno;

    }

    public AlumnoDto(String nombre, String apellido, Integer dniAlumno, List<AsignaturaDto> asignaturas, List<AsignaturaDto> correlativas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniAlumno = dniAlumno;
        this.asignaturas = asignaturas;
        this.correlativas = correlativas;
    }

    public AlumnoDto() {
    }
}







