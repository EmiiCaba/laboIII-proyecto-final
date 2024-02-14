package ar.edu.utn.frbb.tup.model.dto;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class AsignaturaDto {

    private Materia materiaCorrelativa;
    private Materia materia;
    private EstadoAsignatura estado;
    private Integer nota;
    private Alumno alumno;
    private Integer idAsignatura;
    private  Integer materiaId;



    public AsignaturaDto(Materia materiaCorrelativa, Materia materia, EstadoAsignatura estado, Integer nota, Alumno alumno, Integer idAsignatura, Integer materiaId) {
        this.materiaCorrelativa = materiaCorrelativa;
        this.materia = materia;
        this.estado = estado;
        this.nota = nota;
        this.alumno = alumno;
        this.idAsignatura = idAsignatura;
        this.materiaId = materiaId;
    }

    public AsignaturaDto() {
    }
}

