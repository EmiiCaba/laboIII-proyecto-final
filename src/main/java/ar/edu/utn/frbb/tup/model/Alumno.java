/*package ar.edu.utn.frbb.tup.model;
import ar.edu.utn.frbb.tup.business.RandomIDGenerateService;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellido;
    private Integer dniAlumno;
    private List<Asignatura> asignaturas;
    RandomIDGenerateService randomIDGenerateService;

    public Alumno() {randomIDGenerateService = RandomIDGenerateService.getInstance();
        this.idAlumno = randomIDGenerateService.generateId();
        this.asignaturas = new ArrayList<>();
    }
    public Alumno(String nombre, String apellido, Integer dniAlumno) {
        randomIDGenerateService = RandomIDGenerateService.getInstance();
        this.idAlumno = randomIDGenerateService.generateId();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniAlumno = dniAlumno;
        this.asignaturas = new ArrayList<>();
        asignaturas.add(new Asignatura(RandomIDGenerateService.getInstance().generateId()));
        asignaturas.add(new Asignatura(RandomIDGenerateService.getInstance().generateId()));
        asignaturas.add(new Asignatura(RandomIDGenerateService.getInstance().generateId()));
        asignaturas.add(new Asignatura(RandomIDGenerateService.getInstance().generateId()));
        asignaturas.add(new Asignatura(RandomIDGenerateService.getInstance().generateId()));
    }
    public void agregarAsignatura(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
    }
    public List<Asignatura> obtenerListaAsignaturas() {
        return this.asignaturas;
    }

   @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dniAlumno +
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




}
import com.fasterxml.jackson.annotation.JsonInclude;
        import lombok.EqualsAndHashCode;
        import lombok.Getter;
        import lombok.Setter;

        import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@EqualsAndHashCode
public class Alumno {
    private Integer id;
    private String nombre;
    private String apellido;
    private Long dni;
    private ArrayList<Asignatura> asignaturas;
    private static Integer contador = 0;

    public Alumno(){
        setId();
        asignaturas = new ArrayList<Asignatura>();
        asignaturas.add(new Asignatura(1));
        asignaturas.add(new Asignatura(2));
        asignaturas.add(new Asignatura(3));
        asignaturas.add(new Asignatura(4));
    }

    public void setId() {
        this.id = ++contador;
    }

}*/
package ar.edu.utn.frbb.tup.model;

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
public class Alumno {
    private Integer idAlumno;
    private String nombre;
    private String apellido;
    private Integer dniAlumno;
    private List<Asignatura> asignaturas;
    private List<Materia> correlativas;
    private static Integer contador = 0;



    public Alumno( String nombre, String apellido, Integer dniAlumno) {
        setIdAlumno();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniAlumno = dniAlumno;
        this.asignaturas = new ArrayList<>();
        this.correlativas = new ArrayList<>();

    }

    public void setIdAlumno() {
        this.idAlumno = ++contador;
    }
    public List<Asignatura> obtenerListaAsignaturas() {
        return asignaturas;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
    }



}




