package Entidades.Empresa;


import Entidades.Articulos.Articulo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SucursalArticulo {
    private Long id;
    private Articulo articulo;
    private Double precioVentaArticulo;
    private Integer stockArticulo;
}