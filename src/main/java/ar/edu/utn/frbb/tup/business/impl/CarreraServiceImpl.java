package ar.edu.utn.frbb.tup.business.impl;
import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.CarreraDto;
import ar.edu.utn.frbb.tup.persistence.CarreraDao;
import ar.edu.utn.frbb.tup.persistence.CarreraNoEncontradaException;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    private CarreraDao carreraDao;
    @Autowired
    private ProfesorDao profesorDao;


    @Override
    public Carrera crearCarrera(CarreraDto carreraDto) {
        Carrera nuevaCarrera = new Carrera(carreraDto.getNombre(), carreraDto.getCantidadAnios(), null, null);
        carreraDao.saveCarrera(nuevaCarrera);
        return nuevaCarrera;
    }

    @Override
    public Carrera buscarCarreraPorId(Integer idCarrera) throws CarreraNoEncontradaException {
        Carrera carrera = carreraDao.findCarreraById(idCarrera);

        if (carrera == null) {
            throw new CarreraNoEncontradaException("No se encontró la carrera con el ID proporcionado");
        }

        return carrera;
    }

    @Override
    public Carrera modificarCarreraPorId(Integer idCarrera, CarreraDto carrera) throws CarreraNoEncontradaException {
        Carrera carreraExistente = carreraDao.findCarreraById(idCarrera);

        if (carreraExistente == null) {
            throw new CarreraNoEncontradaException("No se encontró la carrera con el ID proporcionado");
        }

        carreraExistente.setNombre(carrera.getNombre());
        carreraExistente.setCantidadAnios(carrera.getCantidadAnios());
        carreraDao.saveCarrera(carreraExistente);

        return carreraExistente;
    }

    @Override
    public Carrera eliminarCarrera(Integer idCarrera) throws CarreraNoEncontradaException {
        Carrera carrera = carreraDao.findCarreraById(idCarrera);

        if (carrera == null) {
            throw new CarreraNoEncontradaException("No se encontró la carrera con el ID proporcionado");
        }

        // Desasignar profesores asociados a la carrera
        if (carrera.getProfesoresList() != null) {
            carrera.getProfesoresList().forEach(idProfesor -> {
                try {
                    desasignarProfesorDeCarrera(idCarrera, idProfesor.getIdProfesor());

                } catch (CarreraNoEncontradaException e) {
                    throw new RuntimeException(e);
                } catch (ProfesorNoEncontradoException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // Eliminar la carrera
        carreraDao.deleteCarrera(carrera);

        return carrera;
    }




    @Override
    public void asignarProfesorACarrera(Integer idCarrera, Integer idProfesor) throws CarreraNoEncontradaException, ProfesorNoEncontradoException {
        Carrera carrera = carreraDao.findCarreraById(idCarrera);
        Profesor profesor = profesorDao.findProfesorById(idProfesor);

        if (carrera == null) {
            throw new CarreraNoEncontradaException("No se encontró la carrera con el ID proporcionado");
        }

        if (profesor == null) {
            throw new ProfesorNoEncontradoException("No se encontró el profesor con el ID proporcionado");
        }

        // Asignar el profesor a la carrera
        carrera.getProfesoresList().add(profesor);
        carreraDao.saveCarrera(carrera);

        // Asignar la carrera al profesor
        profesor.getCarreras().add(carrera);
        profesorDao.saveProfesor(profesor);
    }

    @Override
    public void desasignarProfesorDeCarrera(Integer idCarrera, Integer idProfesor) throws CarreraNoEncontradaException, ProfesorNoEncontradoException {
        Carrera carrera = carreraDao.findCarreraById(idCarrera);
        Profesor profesor = profesorDao.findProfesorById(idProfesor);

        if (carrera == null) {
            throw new CarreraNoEncontradaException("No se encontró la carrera con el ID proporcionado");
        }

        if (profesor == null) {
            throw new ProfesorNoEncontradoException("No se encontró el profesor con el ID proporcionado");
        }

        // Desasignar el profesor de la carrera
        carrera.getProfesoresList().remove(idProfesor);
        carreraDao.saveCarrera(carrera);

        // Desasignar la carrera del profesor
        profesor.getCarreras().remove(carrera);
        profesorDao.saveProfesor(profesor);
    }

    @Override
    public List<Materia> obtenerMateriasDeCarrera(Integer idCarrera) throws CarreraNoEncontradaException {
        Carrera carrera = carreraDao.findCarreraById(idCarrera);

        if (carrera == null) {
            throw new CarreraNoEncontradaException("No se encontró la carrera con el ID proporcionado");
        }

        return carrera.getMateriasList();
    }


    public void eliminarProfesorDeCarrera(int idCarrera, int idProfesor) throws CarreraNoEncontradaException, ProfesorNoEncontradoException {
        Carrera carrera = carreraDao.findCarreraById(idCarrera);

        if (carrera != null) {
            Profesor profesor = profesorDao.findProfesorById(idProfesor);

            if (profesor != null && carrera.getProfesoresList().contains(profesor)) {
                carrera.getProfesoresList().remove(profesor);
                carreraDao.saveCarrera(carrera);

                profesor.setCarrera(null);
                profesorDao.saveProfesor(profesor);
            } else {
                throw new ProfesorNoEncontradoException("No se encontró el profesor con el ID proporcionado o el profesor no está asignado a la carrera");
            }
        } else {
            throw new CarreraNoEncontradaException("No se encontró la carrera con el ID proporcionado");
        }
    }

    @Override
    public List<Carrera> obtenerTodasLasCarreras() {
        return carreraDao.findAllCarreras();
    }
    @Override
    public List<Integer> obtenerTodosLosIdsCarreras() {
        List<Carrera> carreras = carreraDao.findAllCarreras();
        List<Integer> idsCarreras = new ArrayList<>();
        for (Carrera carrera : carreras) {
            idsCarreras.add(carrera.getIdCarrera());
        }
        return idsCarreras;
    }


}





