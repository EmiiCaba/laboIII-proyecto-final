package ar.edu.utn.frbb.tup.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Asignatura {
    public String nombre;

    public Materia materia;
    private EstadoAsignatura estado;
    private Integer nota;
    private List<Materia> correlativas;
    private int materiaId;
    private int idAsignatura;
    private static Integer contador = 0;


    public Asignatura(String nombre, Integer nota, Materia  materia) {
        this.nombre= nombre;
        this.estado = EstadoAsignatura.NO_CURSADA;
        this.nota = nota;
        this.materiaId =  materia.getIdMateria();
        setIdAsignatura();

    }



    public void agregarCorrelativa(Materia correlativa) {
        correlativas.add(correlativa);
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
    public void setIdAsignatura() {
        this.idAsignatura = ++contador;
    }

}

