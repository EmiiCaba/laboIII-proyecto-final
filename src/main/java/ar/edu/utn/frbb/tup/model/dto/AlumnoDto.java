package ar.edu.utn.frbb.tup.model.dto;

public class AlumnoDto {
    String nombre;
    String apellido;
    Integer dni;
    String idAlumno;




    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public String getIdAlumno() {
        return idAlumno;
    }



    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
