package ar.edu.utn.frbb.tup.business;

public class AlumnoExistenteException extends Exception {
    public AlumnoExistenteException() {
        super("El alumno ya existe");
    }
}
