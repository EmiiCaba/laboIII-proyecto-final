package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Carrera;

import java.util.List;

public interface CarreraDao {

    Carrera loadCarreraById(Carrera carrera) throws CarreraNoEncontradaException;

    Carrera saveCarrera(Carrera carrera);

    Carrera findCarreraById(Integer idCarrera) throws CarreraNoEncontradaException;

    Carrera deleteCarrera(Carrera carrera) throws CarreraNoEncontradaException;

    List<Carrera> findAllCarreras();
}
