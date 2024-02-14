package ar.edu.utn.frbb.tup.model.dto;
import lombok.Getter;
import lombok.Setter;

 @Getter @Setter
    public class IdNombreDto {
        private Integer id;
        private String nombre;

        public IdNombreDto(Integer id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
    }


