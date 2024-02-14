package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.dto.AsignaturaDto;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;


    @PostMapping
    public ResponseEntity<Void> crearAsignatura(@RequestBody AsignaturaDto asignaturaDto) {
        try {
            asignaturaService.crearAsignatura(asignaturaDto.getAlumno(), asignaturaDto.getMateriaId(), asignaturaDto.getNota());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (AlumnoNoEncontradoException | MateriaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/asignaturas")
    public ResponseEntity<List<Asignatura>> obtenerListaAsignaturas() {
        List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
        return new ResponseEntity<>(asignaturas, HttpStatus.OK);
    }

    @GetMapping("/correlativas/{materiaId}")
    public ResponseEntity<List<Integer>> obtenerListaCorrelativas(@PathVariable("materiaId") Integer materiaId) {
        try {
            List<Integer> correlativas = asignaturaService.obtenerListaCorrelativas(materiaId);
            return new ResponseEntity<>(correlativas, HttpStatus.OK);
        } catch (MateriaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}


