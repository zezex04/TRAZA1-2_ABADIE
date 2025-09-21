package Entidades.Empresa;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder // Para crear un patrón Builder que funciona con herencia
@Data // Genera getters, setters, equals, hashCode y toString automáticamente
@ToString // Genera metodo toString


public class Localidad {
    private Long id;
    private String nombre;
    private Provincia provincia;
}
