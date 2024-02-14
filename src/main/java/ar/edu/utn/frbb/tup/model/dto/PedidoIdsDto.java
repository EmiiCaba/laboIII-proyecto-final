package ar.edu.utn.frbb.tup.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
public class PedidoIdsDto {
    private List<IdNombreDto> idsNombresMaterias;
    private List<IdNombreDto> idsNombresAsignaturas;

    public PedidoIdsDto(List<IdNombreDto> idsNombresMaterias, List<IdNombreDto> idsNombresAsignaturas) {
        this.idsNombresMaterias = idsNombresMaterias;
        this.idsNombresAsignaturas = idsNombresAsignaturas;
    }
}


