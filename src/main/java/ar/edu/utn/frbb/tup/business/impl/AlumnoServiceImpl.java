package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.AsignaturaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoDao alumnoDao;
    @Autowired
    AsignaturaDao asignaturaDao;




    @Override
    public Alumno crearAlumno(AlumnoDto alumnoDto) throws AlumnoNoEncontradoException {
        Alumno alumno = alumnoDao.saveAlumno(dtoAalumno(alumnoDto));
        return alumno;
    }

    private Alumno dtoAalumno(AlumnoDto alumnoDto) {
        return new Alumno(alumnoDto.getNombre(), alumnoDto.getApellido(), alumnoDto.getDniAlumno());
    }

    @Override
    public Alumno modificarAlumnoPorId(Integer idAlumno, Alumno alumno) throws AlumnoNoEncontradoException {
        // Buscar el alumno por su ID, si existe
        Alumno alumnoExistente = alumnoDao.findAlumnoByID(idAlumno);

        // Verificar si el objeto alumno no es nulo y si su dniAlumno no es nulo
        if (alumnoExistente != null && alumno.getDniAlumno() != null) {
            // Modificar los campos del alumno existente con los valores del alumno proporcionado
            alumnoExistente.setNombre(alumno.getNombre());
            alumnoExistente.setApellido(alumno.getApellido());
            alumnoExistente.setDniAlumno(alumno.getDniAlumno().intValue()); // Convertir el Integer a int

            // Guardar y devolver el alumno modificado
            return alumnoDao.loadAlumnoPorId(alumnoExistente);
        } else {
            // Si el alumno proporcionado es nulo o su dniAlumno es nulo, lanzar una excepción
            throw new AlumnoNoEncontradoException("El alumno proporcionado es nulo o su DNI es nulo");
        }
    }


    @Override
    public Alumno eliminarAlumnoPorId(Integer idAlumno) throws AlumnoNoEncontradoException {
        // Buscar el alumno por su ID
        Alumno alumno = alumnoDao.findAlumnoByID(idAlumno);
        // Eliminar al alumno
        alumnoDao.delete(alumno);

        return alumno;
    }

    @Override
    public Alumno buscarAlumnoPorId(Integer idAlumno) throws AlumnoNoEncontradoException {
        // Buscar el alumno por su ID

        return alumnoDao.findAlumnoByID(idAlumno);
    }


    @Override
    public void agregarAsignaturaAAlumno(Integer idAlumno, Integer idAsignatura) throws AlumnoNoEncontradoException {
        Alumno alumno = alumnoDao.findAlumnoByID(idAlumno);
        Asignatura asignatura = asignaturaDao.obtenerAsignaturaPorId(idAsignatura);

        if (alumno != null && asignatura != null) {
            alumno.agregarAsignatura(asignatura);
            alumnoDao.saveAlumno(alumno); // Guardar cambios en la base de datos si es necesario
        }
        }


        public static boolean alumnoTieneAsignatura (AlumnoDao alumnoDao, Integer idAlumno, Integer idAsignatura){

            try {
                Alumno alumno = alumnoDao.findAlumnoByID(idAlumno);
                if (alumno != null) {
                    // Verifica si la lista de asignaturas del alumno contiene la asignatura con el ID dado
                    return alumno.getAsignaturas().stream()
                            .map(Asignatura::getIdAsignatura)
                            .anyMatch(id -> id.equals(idAsignatura));
                }
            } catch (AlumnoNoEncontradoException e) {
                // Manejar la excepción adecuadamente, por ejemplo, imprimir la traza de la excepción
                e.printStackTrace();
            }
            return false;
        }
    }







