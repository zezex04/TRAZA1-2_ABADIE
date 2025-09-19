package Entidades.Articulos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private String denominacion;
    private Long id;
}
