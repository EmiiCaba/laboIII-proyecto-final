package ar.edu.utn.frbb.tup.model.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class ProfesorDto {


    private String nombre;
    private String apellido;
    private String titulo;
    private List<MateriaDto> materiasDictadas;
    private int idProfesor;

    public ProfesorDto( String nombre, String apellido, String titulo, List<MateriaDto> materiasDictadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.materiasDictadas = materiasDictadas;

    }


}
