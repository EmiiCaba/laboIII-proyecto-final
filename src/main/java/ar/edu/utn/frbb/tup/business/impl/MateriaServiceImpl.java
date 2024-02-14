package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {
    @Autowired
    private MateriaDao materiaDao;
    @Autowired
    private ProfesorDao profesorDao;

    @Override
    public Materia crearMateria(MateriaDto materiaDto, Carrera carrera, Profesor profesor) throws MateriaNotFoundException {
        Materia nuevaMateria = new Materia(
                materiaDto.getNombre(),
                materiaDto.getAnio(),
                materiaDto.getCuatrimestre(),
                obtenerCorrelatividades(materiaDto.getCorrelativas()),
                carrera.getIdCarrera(),
                (profesor != null) ? profesor.getIdProfesor() : null); // Asignar profesor si no es null

        // Guardar la nueva materia en la base de datos
        materiaDao.save(nuevaMateria);

        return nuevaMateria;
    }

    @Override
    public void asignarProfesorAMateria(Integer idMateria, Integer idProfesor) throws MateriaNotFoundException, ProfesorNotFoundException, ProfesorNoEncontradoException {
        // Buscar la materia por su ID
        Materia materia = materiaDao.findByIdMateria(idMateria);
        if (materia == null) {
            throw new MateriaNotFoundException("No se encontró una materia con el ID: " + idMateria);
        }

        // Buscar al profesor por su ID
        Profesor profesor = profesorDao.findProfesorById(idProfesor);
        if (profesor == null) {
            throw new ProfesorNotFoundException();
        }

        // Asignar el profesor a la materia
        materia.setIdProfesor(profesor.getIdProfesor());

        // Guardar la materia actualizada en la base de datos
        materiaDao.save(materia);
    }

    @Override
    public Materia buscarMateriaPorId(Integer idMateria) throws MateriaNotFoundException {
        Materia materia = materiaDao.findByIdMateria(idMateria);
        if (materia == null) {
            throw new MateriaNotFoundException("No se encontró la materia con ID: " + idMateria);
        }
        return materia;
    }

    public List<Integer> obtenerCorrelatividades(List<Integer> idsCorrelatividades) throws MateriaNotFoundException {
        List<Integer> correlatividades = new ArrayList<>();
        for (Integer id : idsCorrelatividades) {
            Materia correlativa = materiaDao.findByIdMateria(id);
            if (correlativa != null) {
                correlatividades.add(correlativa.getIdMateria());
            }
        }
        return correlatividades;
    }


    @Override
    public void borrarMateria(Integer idMateria) throws MateriaNotFoundException {
        Materia materia = materiaDao.findByIdMateria(idMateria);

        if (materia != null) {
            materiaDao.deleteByIdMateria(idMateria);
        } else {
            // Manejar el caso en el que la materia no se encuentra
            System.out.println("No se encontró una Materia con el ID: " + idMateria);

        }
    }




    @Override
    public List<Materia> obtenerMateriasSinProfesor() {
        List<Materia> todasLasMaterias = materiaDao.getAllMaterias();
        List<Materia> materiasSinProfesor = new ArrayList<>();

        for (Materia materia : todasLasMaterias) {
            if (materia.getIdProfesor() == 0) {
                materiasSinProfesor.add(materia);
            }
        }

        return materiasSinProfesor;
    }


    @Override
    public List<Materia> obtenerTodasLasMateriasConDetalles() {
        return materiaDao.getAllMaterias();
    }

    @Override
    public List<Integer> obtenerTodosLosIdsMaterias() {
        List<Materia> materias = materiaDao.getAllMaterias();
        List<Integer> idsMaterias = new ArrayList<>();
        for (Materia materia : materias) {
            idsMaterias.add(materia.getIdMateria());
        }
        return idsMaterias;
    }

}

