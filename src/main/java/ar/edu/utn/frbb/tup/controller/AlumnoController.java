package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.AlumnoExistenteException;
import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
   @Autowired
    private AlumnoService alumnoService;
   @Autowired
   private AlumnoDao alumnoDao;


    @PostMapping
    public ResponseEntity <Alumno> crearAlumno(@RequestBody AlumnoDto alumnoDto) throws AlumnoExistenteException, AlumnoNoEncontradoException {

        return ResponseEntity.ok(alumnoService.crearAlumno(alumnoDto));// ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.crearAlumno(alumnoDto));

    }
    @PutMapping ("/{idAlumno}")
    public ResponseEntity<Alumno> modificarAlumnoPorId(@PathVariable Integer idAlumno, @RequestBody Alumno alumno) {
        try {
            Alumno alumnoModificado = alumnoService.modificarAlumnoPorId(idAlumno, alumno);
            return ResponseEntity.ok(alumnoModificado);
        } catch (AlumnoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{idAlumno}")
    public ResponseEntity<String> eliminarAlumnoPorId(@PathVariable Integer idAlumno) {
        try {
            Alumno alumnoEliminado = alumnoService.eliminarAlumnoPorId(idAlumno);
            return ResponseEntity.ok("Alumno con ID " + idAlumno + " ha sido eliminado correctamente");
        } catch (AlumnoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{idAlumno}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Integer idAlumno) {
        try {
            Alumno alumno = alumnoService.buscarAlumnoPorId(idAlumno);
            return ResponseEntity.ok(alumno);
        } catch (AlumnoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Alumno>> obtenerTodosLosAlumnos() {
        try {
            List<Alumno> alumnos = alumnoDao.getAllAlumnos();
            return ResponseEntity.ok(alumnos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/{idAlumno}/asignaturas/{idAsignatura}")
    public ResponseEntity<String> agregarAsignaturaAAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idAsignatura) throws AlumnoNoEncontradoException {
        alumnoService.agregarAsignaturaAAlumno(idAlumno, idAsignatura);
        return ResponseEntity.ok("Asignatura agregada al alumno correctamente");
    }

}

