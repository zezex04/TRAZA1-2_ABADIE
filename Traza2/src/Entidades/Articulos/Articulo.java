package Entidades.Articulos;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Articulo {
    protected String denominacion;
    protected Double precioVentaRecomendado;
    protected Long id;


    @Builder.Default

    protected Set<Imagen> imagenes = new HashSet<>();
    protected Categoria categoria;
    protected UnidadMedida unidadMedida;

}
