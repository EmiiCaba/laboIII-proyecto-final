package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/")
    public Alumno crearAlumno(@RequestBody AlumnoDto alumnoDto) {

        return alumnoService.crearAlumno(alumnoDto);

    }
    @GetMapping
    public ResponseEntity <Alumno> buscarAlumnoPorApellido (@RequestParam String apellidoAlumno) throws AlumnoNoEncontradoException {
        if (alumnoService.buscarAlumnoPorApellido( apellidoAlumno) == null)
            return new ResponseEntity<Alumno>(alumnoService.buscarAlumnoPorApellido( apellidoAlumno), HttpStatus.NOT_FOUND);
       return new ResponseEntity<Alumno>( alumnoService.buscarAlumnoPorApellido( apellidoAlumno), HttpStatus.OK);

    }
}
