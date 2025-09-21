package Entidades.Empresa;

import Entidades.Articulos.Articulo;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SucursalArticulo {
    private Long id;
    private Articulo articulo;
    private Double precioVentaArticulo;
    private Integer stockArticulo;
}