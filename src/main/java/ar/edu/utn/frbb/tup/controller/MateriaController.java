package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

 /*   @GetMapping
    public List<Materia> getMaterias() {
     //   Materia m = new Materia("labo 1", 2, 1, new Profesor("Lucho", "Salotto", "Lic"));
     //   Materia m1 = new Materia("labo 2", 2, 1, new Profesor("Juan", "Perez", "Lic" ));

     //   return Arrays.asList(m1, m);
        return;
    }*/

    @PostMapping
    public Materia crearMateria(@RequestBody MateriaDto materiaDto) throws ProfesorNoEncontradoException, ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException {
        return materiaService.crearMateria(materiaDto);
    }

    @GetMapping("/{idMateria}")
    public Materia getMateriaById(@PathVariable String idMateria) throws MateriaNotFoundException {
        return materiaService.getMateriaById(idMateria);
    }
}


