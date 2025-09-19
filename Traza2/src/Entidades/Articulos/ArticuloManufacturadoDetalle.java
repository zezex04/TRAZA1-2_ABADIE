package Entidades.Articulos;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor


public class ArticuloManufacturadoDetalle {
    private Integer cantidad;
    private Long id;
    private ArticuloInsumo articuloInsumo;

}
