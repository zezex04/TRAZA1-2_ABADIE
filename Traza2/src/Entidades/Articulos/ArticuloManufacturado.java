package Entidades.Articulos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private String preparacion;
    private Integer tiempoEsperadoMinutos;

    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();
}
