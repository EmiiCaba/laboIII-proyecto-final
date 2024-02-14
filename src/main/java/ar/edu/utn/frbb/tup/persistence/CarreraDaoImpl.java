package ar.edu.utn.frbb.tup.persistence;
import ar.edu.utn.frbb.tup.model.Carrera;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarreraDaoImpl implements CarreraDao {
    private Map<Integer, Carrera> repositorioCarreras = new HashMap<>();

    @Override
    public Carrera loadCarreraById(Carrera carrera) throws CarreraNoEncontradaException {
        repositorioCarreras.put(carrera.getIdCarrera(), carrera);
        return carrera;
    }

    @Override
    public Carrera saveCarrera(Carrera carrera) {
        return repositorioCarreras.put(carrera.getIdCarrera(), carrera);
    }

    @Override
    public Carrera findCarreraById (Integer idCarrera) throws CarreraNoEncontradaException {
        if (!repositorioCarreras.containsKey(idCarrera)) {
            throw new CarreraNoEncontradaException("No se encontró la carrera");
        } else {
            return repositorioCarreras.get(idCarrera);
        }
    }

    @Override
    public Carrera deleteCarrera(Carrera carrera) throws CarreraNoEncontradaException {
        if (repositorioCarreras.containsKey(carrera.getIdCarrera())) {
            repositorioCarreras.remove(carrera.getIdCarrera());
            return carrera; // Se elimina la carrera y se retorna
        } else {
            throw new CarreraNoEncontradaException("No se encontró la carrera a eliminar");
        }
    }
    @Override
    public List<Carrera> findAllCarreras() {
        return new ArrayList<>(repositorioCarreras.values());
    }
}


