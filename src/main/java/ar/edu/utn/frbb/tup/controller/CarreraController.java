package ar.edu.utn.frbb.tup.controller;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.dto.CarreraDto;
import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/carreras")
    public class CarreraController {

        @Autowired
        private CarreraService carreraService;

        @PostMapping("/crear")
        public ResponseEntity<Carrera> crearCarrera(@RequestBody CarreraDto carreraDto) {
            Carrera nuevaCarrera = carreraService.crearCarrera(carreraDto);
            return new ResponseEntity<>(nuevaCarrera, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Carrera> buscarCarreraPorId(@PathVariable("id") Integer idCarrera) {
            try {
                Carrera carrera = carreraService.buscarCarreraPorId(idCarrera);
                return new ResponseEntity<>(carrera, HttpStatus.OK);
            } catch (ar.edu.utn.frbb.tup.persistence.CarreraNoEncontradaException e) {
                throw new RuntimeException(e);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Carrera> modificarCarreraPorId(@PathVariable("id") Integer idCarrera, @RequestBody CarreraDto carreraDto) {
            try {
                // Aquí podrías convertir los IDs de profesores a objetos de Profesor si es necesario
                // Por simplicidad, asumiré que ya tienes una forma de hacerlo
                Carrera carreraModificada = carreraService.modificarCarreraPorId(idCarrera, carreraDto);
                return new ResponseEntity<>(carreraModificada, HttpStatus.OK);
            } catch (ar.edu.utn.frbb.tup.persistence.CarreraNoEncontradaException e) {
                throw new RuntimeException(e);
            }
        }

        @DeleteMapping("/{idCarrera}/profesores/{idProfesor}")
        public ResponseEntity<Void> eliminarProfesorDeCarreraPorId(@PathVariable("idCarrera") Integer idCarrera, @PathVariable("idProfesor") Integer idProfesor) {
            try {
                carreraService.desasignarProfesorDeCarrera(idCarrera, idProfesor);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (ProfesorNoEncontradoException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (ar.edu.utn.frbb.tup.persistence.CarreraNoEncontradaException e) {
                throw new RuntimeException(e);
            }
        }

        @GetMapping
        public ResponseEntity<List<Carrera>> obtenerTodasLasCarreras() {
            List<Carrera> carreras = carreraService.obtenerTodasLasCarreras();
            return new ResponseEntity<>(carreras, HttpStatus.OK);
        }
    }



