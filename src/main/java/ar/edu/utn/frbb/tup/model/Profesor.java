package ar.edu.utn.frbb.tup.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@EqualsAndHashCode
public class Profesor {

   private Integer idProfesor ;
    private  String nombre;
    private  String apellido;
    private String titulo;
    private List<Carrera> carreras = new ArrayList<>(); // Inicializa la lista
    private List<Materia> materiasDictadas;

    private static Integer contador = 0;


   public Profesor() {
        // Inicializar la lista de materias dictadas en el constructor
        this.materiasDictadas = new ArrayList<>();
        setIdProfesor();
    }


    public Profesor(String nombre, String apellido, String titulo) {
        setIdProfesor();
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;


    }
    public void setIdProfesor() {
        this.idProfesor = ++contador;
    }

    public void agregarMateriaDictada(Materia nombreMateria) {

        this.materiasDictadas.add(nombreMateria);
    }
    //Método para obtener la lista de materias dictadas
    public List<Materia> getMateriasDictadas() {
        return materiasDictadas;
    }

    public void setCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    public void setMateriasDictadas(List<Materia> materiasDictadas) {
        this.materiasDictadas = materiasDictadas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, nombre, titulo,materiasDictadas, idProfesor);
    }
    @Override
    public String toString(){
        return "Profesor{"+
                ", nombre='" + nombre + '\'' +
                ", apellido =" + apellido +
                ", titulo =" + titulo +
                ", IdProfesor=" + idProfesor +
                ", materiasDictadas=" + materiasDictadas +
                '}';

        }

}

