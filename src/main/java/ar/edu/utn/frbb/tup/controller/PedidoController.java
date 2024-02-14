package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.model.dto.PedidoIdsDto;
import ar.edu.utn.frbb.tup.model.dto.IdNombreDto; // Importación de IdNombreDto
import ar.edu.utn.frbb.tup.model.Materia; // Importación de la clase Materia
import ar.edu.utn.frbb.tup.model.Asignatura; // Importación de la clase Asignatura
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/ids")
public class PedidoController {

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping()
    public PedidoIdsDto obtenerIds() {
        // Obtener listas de materias y asignaturas desde los servicios correspondientes
        List<Materia> materias = materiaService.obtenerTodasLasMateriasConDetalles();
        List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();

        // Construir listas de IDs y nombres para materias
        List<IdNombreDto> idsNombresMaterias = new ArrayList<>();
        for (Materia materia : materias) {
            idsNombresMaterias.add(new IdNombreDto(materia.getIdMateria(), materia.getNombre()));
        }

        // Construir listas de IDs y nombres para asignaturas
        List<IdNombreDto> idsNombresAsignaturas = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            idsNombresAsignaturas.add(new IdNombreDto(asignatura.getIdAsignatura(), asignatura.getNombre()));
        }

        // Crear un objeto PedidoIdsDto con las listas de IDs y nombres obtenidas
        return new PedidoIdsDto(idsNombresMaterias, idsNombresAsignaturas);
    }
}
