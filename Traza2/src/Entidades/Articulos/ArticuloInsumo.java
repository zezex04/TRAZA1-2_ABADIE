package Entidades.Articulos;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class ArticuloInsumo extends Articulo {
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;
}
