package ar.edu.utn.frbb.tup.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class AlumnoAsignaturaDto {
    private Integer idAlumno;
    private List<Integer> idAsignaturas;

    public AlumnoAsignaturaDto(Integer idAlumno, List<Integer> idAsignaturas) {
        this.idAlumno = idAlumno;
        this.idAsignaturas = idAsignaturas;
    }
}