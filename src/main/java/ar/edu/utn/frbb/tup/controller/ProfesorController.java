package ar.edu.utn.frbb.tup.controller;


import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorDao profesorDao;
    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private MateriaService materiaService;
    Profesor profesor;
    Materia materia;
    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) throws ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException {
        Profesor profesorCreado = profesorDao.saveProfesor(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorCreado);
    }

    @PutMapping("/{idProfesor}") // Cambia a /{idProfesor}
    public ResponseEntity<Profesor> modificarProfesor(@PathVariable Integer idProfesor, @RequestBody Profesor profesor) {
        try {
            profesor.setIdProfesor(idProfesor);
            Profesor profesorActualizado = profesorDao.loadProfesorbyId(profesor);
            return ResponseEntity.ok(profesorActualizado);
        } catch (ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/{idProfesor}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable("idProfesor") Integer id) {
        try {
            Profesor profesor = profesorDao.findProfesorById(id);
            return ResponseEntity.ok(profesor);
        } catch (ProfesorNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }




    @DeleteMapping("/{idProfesor}")
    public ResponseEntity<String>deleteProfesor (@PathVariable Profesor idProfesor) {
        try {
            Profesor profesorEliminado =profesorDao.deleteProfesor(idProfesor.getIdProfesor()) ;
            return ResponseEntity.ok("Profesor con ID " + idProfesor + " ha sido eliminado correctamente");

        } catch (ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Profesor>> obtenerTodosLosProfesores() {
        try {
            List<Profesor> profesores = profesorDao.getAllProfesores();
            return ResponseEntity.ok(profesores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/profesor/{idProfesor}/asignar-materia/{idMateria}")
    public ResponseEntity<Void> asignarMateriaAProfesor(@PathVariable Integer idProfesor, @PathVariable Integer idMateria) {
        try {
            // Llamar al servicio para asignar el profesor a la materia
            profesorService.asignarProfesorAMateria(idMateria, idProfesor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProfesorNoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }



    @PutMapping("/{idProfesor}/quitar-materia/{idMateria}")
    public ResponseEntity<Void> quitarMateriaDeProfesor(@PathVariable Integer idProfesor, @PathVariable Integer idMateria) {
        try {
            profesorService.quitarProfesorDeMateria(idMateria);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ProfesorNoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{idProfesor}/materias")
    public ResponseEntity<List<Materia>> obtenerMateriasPorIdProfesorOrdenadasAlfabeticamente(@PathVariable Integer idProfesor) {
        try {
            List<Materia> materias = profesorService.obtenerMateriasOrdenadasAlfabeticamentePorIdProfesor(idProfesor);
            return new ResponseEntity<>(materias, HttpStatus.OK);
        } catch (ProfesorNoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}







