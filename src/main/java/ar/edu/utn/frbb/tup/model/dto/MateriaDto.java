package ar.edu.utn.frbb.tup.model.dto;

public class MateriaDto {
    private String nombre;
    private int anio;
    private int cuatrimestre;
    private String idProfesor;

    public String getidProfesor() {
        return idProfesor;
    }

    public void setiDProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

}
