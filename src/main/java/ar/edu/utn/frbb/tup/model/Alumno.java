package ar.edu.utn.frbb.tup.model;
import ar.edu.utn.frbb.tup.business.RandomIDGenerateService;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellido;
    private Integer dni;
    private List<Asignatura> asignaturas;
    RandomIDGenerateService randomIDGenerateService;
    public Alumno() {randomIDGenerateService = RandomIDGenerateService.getInstance();
        this.idAlumno = Integer.parseInt(randomIDGenerateService.generateId(6));
    }
    public Alumno(String nombre, String apellido, Integer dni, RandomIDGenerateService randomIDGenerateService) {
        randomIDGenerateService = RandomIDGenerateService.getInstance();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.idAlumno = Integer.parseInt(randomIDGenerateService.generateId(6));
        asignaturas = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", asignaturas=" + asignaturas +
                '}';
    }

    @Override
    public int hashCode() {
        return idAlumno;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return  idAlumno == alumno.getIdAlumno();
    }

    public void actualizarAsignatura(Asignatura a) {}
}