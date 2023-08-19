package ar.edu.utn.frbb.tup.controller;


import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("profesor")
public class ProfesorController {

        @Autowired
        private ProfesorService profesorService;

        @PostMapping("/")
        public Profesor crearProfesor(@RequestBody ProfesorDto profesorDto) throws ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException {

            return profesorService.crearProfesor( profesorDto);

        }
        @GetMapping
        public ResponseEntity<Profesor> buscarProfesorPorApellido (@RequestParam String apellidoProfesor) throws ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException {
            if (profesorService.buscarProfesorPorApellido( apellidoProfesor) == null)
                return new ResponseEntity<Profesor>(profesorService.buscarProfesorPorApellido( apellidoProfesor), HttpStatus.NOT_FOUND);
            return new ResponseEntity<Profesor>( profesorService.buscarProfesorPorApellido( apellidoProfesor), HttpStatus.OK);

        }
    }


