package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.CarreraDto;
import ar.edu.utn.frbb.tup.persistence.CarreraNoEncontradaException;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;

import java.util.List;


public interface CarreraService {
    public Carrera crearCarrera(CarreraDto carreraDto);
    void eliminarProfesorDeCarrera(int idCarrera, int idProfesor) throws CarreraNoEncontradaException, ProfesorNoEncontradoException;
    Carrera buscarCarreraPorId(Integer idCarrera) throws CarreraNoEncontradaException;
    Carrera modificarCarreraPorId(Integer idCarrera, CarreraDto carrera) throws CarreraNoEncontradaException;
    Carrera eliminarCarrera(Integer idCarrera) throws CarreraNoEncontradaException;
    void asignarProfesorACarrera(Integer idCarrera, Integer idProfesor) throws CarreraNoEncontradaException, ProfesorNoEncontradoException;
    void desasignarProfesorDeCarrera(Integer idCarrera, Integer idProfesor) throws CarreraNoEncontradaException, ProfesorNoEncontradoException;
    List<Materia> obtenerMateriasDeCarrera(Integer idCarrera) throws CarreraNoEncontradaException;

    List<Carrera> obtenerTodasLasCarreras();

    List<Integer> obtenerTodosLosIdsCarreras();
}
