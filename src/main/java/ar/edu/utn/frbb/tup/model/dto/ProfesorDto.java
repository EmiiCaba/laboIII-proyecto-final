package ar.edu.utn.frbb.tup.model.dto;

import ar.edu.utn.frbb.tup.model.Materia;

import java.util.List;

public class ProfesorDto {

    String idProfesor;
    String nombre;
    String apellido;
    String titulo;

    List<Materia> materiasDictadas;

    public String getIdProfesor() {
        return idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        public void setApellido(String apellido) {
            this.apellido = apellido;
        }


        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public List<Materia> getMateriasDictadas() {
            return materiasDictadas;
        }

        public void setMateriasDictadas(List<Materia> materiasDictadas) {
            this.materiasDictadas = materiasDictadas;
        }


    }

