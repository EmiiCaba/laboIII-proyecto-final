package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.model.exception.ProfesorNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/materia")
public class MateriaController {
    @Autowired
    private MateriaDao materiaDao;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private CarreraService carreraService;

    @PostMapping
    public ResponseEntity<Materia> crearMateria(@RequestBody MateriaDto materiaDto) {
        try {
            // Obtener el ID de la carrera desde el objeto MateriaDto
            Integer idCarrera = materiaDto.getIdCarrera();
            // Buscar la carrera por su ID
            Carrera carrera = carreraService.buscarCarreraPorId(idCarrera);

            // Crear la materia con profesor null
            Materia nuevaMateria = materiaService.crearMateria(materiaDto, carrera, null);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMateria);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (ProfesorNoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{idMateria}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Integer idMateria) {
        try {
            Materia materia = materiaDao.findByIdMateria(idMateria);
            return ResponseEntity.ok(materia);
        } catch (MateriaNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ordenadas/{idProfesor}")
    public ResponseEntity<List<Materia>> obtenerMateriasOrdenadasAlfabeticamentePorIdProfesor(@PathVariable Integer idProfesor) {
        try {
            List<Materia> materias = profesorService.obtenerMateriasOrdenadasAlfabeticamentePorIdProfesor(idProfesor);
            return ResponseEntity.ok(materias);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (ar.edu.utn.frbb.tup.persistence.exception.ProfesorNoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }

}







