package ar.edu.utn.frbb.tup.business.impl;

public class AlumnoExistenteException extends Exception {
    public AlumnoExistenteException() {
        super("El alumno ya existe");
    }
}
