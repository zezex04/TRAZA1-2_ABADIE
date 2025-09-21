package Entidades.Empresa;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Data
@ToString
public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean es_Casa_Matriz;
    private Domicilio domicilio;

    @Builder.Default
    private Set<SucursalArticulo> sucursalArticulos = new HashSet<>();

    public Set<SucursalArticulo> getSucursalArticulos() {
        return sucursalArticulos;
    }
}