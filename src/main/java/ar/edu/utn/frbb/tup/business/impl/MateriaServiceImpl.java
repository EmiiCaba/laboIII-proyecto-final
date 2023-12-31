package ar.edu.utn.frbb.tup.business.impl;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {
    @Autowired
    private MateriaDao dao;

    @Autowired
    private ProfesorService profesorService;

   @Override
    public Materia crearMateria(MateriaDto materia) throws ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException {
        Materia m = new Materia();
        m.setNombre(materia.getNombre());
        m.setAnio(materia.getAnio());
        m.setCuatrimestre(materia.getCuatrimestre());
        m.setProfesor(profesorService.buscarProfesorPorApellido(materia.getidProfesor()));
        dao.save(m);
        if (m.getNombre().contains("a")) {
            throw new IllegalArgumentException();
        }
        return m;
    }

    @Override
    public List<Materia> getAllMaterias() {
        return null;
    }

    @Override
    public Materia buscarMateria() {
        return null;
    }

    @Override
    public Materia getMateriaById(String idMateria) throws MateriaNotFoundException {
        return dao.findById(idMateria);
    }
}
