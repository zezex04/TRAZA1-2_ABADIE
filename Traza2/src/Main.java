import Entidades.Articulos.*;
import Entidades.Empresa.*;
import Repositorios.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //	Crear un país ( Argentina).
        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();

        //	Crear una provincia relacionarla con el país (Buenos Aires).
        Provincia buenosAires = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();
        argentina.getProvincias().add(buenosAires);

        //Crear 1 localidad de Buenos Aires, estableciendo su relación ( Caba ).
        Localidad caba = Localidad.builder()
                .nombre("caba")
                .id(1L)
                .build();
        //-	Crear un domicilio para Caba
        Domicilio domicilio1 = Domicilio.builder()
                .id(1L)
                .calle("Calle 1")
                .numero(440)
                .codigoPostal(6608)
                .localidad(caba)
                .build();

        //	Crear otra localidad de Buenos Aires, estableciendo su relación ( La Plata ).
        Localidad laPlata = Localidad.builder()
                .nombre("La Plata")
                .id(1L)
                .build();
        //-	Crear un domicilio para La Plata
        Domicilio domicilio2 = Domicilio.builder()
                .id(1L)
                .calle("Calle 2")
                .numero(745)
                .codigoPostal(6608)
                .localidad(laPlata)
                .build();

        //	Crear otra provincia relacionarla con el país (Córdoba).
        Provincia cordoba = Provincia.builder()
                .nombre("Cordoba")
                .id(1L)
                .pais(argentina)
                .build();
        argentina.getProvincias().add(cordoba);
        //Crear 1 localidad de Córdoba, estableciendo su relación ( Córdoba Capital ).
        Localidad cordobaCapital = Localidad.builder()
                .id(1L)
                .nombre("Cordoba Capital")
                .provincia(cordoba)
                .build();
        Domicilio domicilio3 = Domicilio.builder()
                .calle("Calle1")
                .id(1L)
                .numero(112)
                .codigoPostal(6608)
                .localidad(cordobaCapital)
                .build();

        //Crear otra  localidad de Córdoba, estableciendo su relación ( Villa Carlos Paz ).
        Localidad villaCarlosPaz = Localidad.builder()
                .id(1L)
                .nombre("Villa Carlos Paz")
                .provincia(cordoba)
                .build();
        //Crear un domicilio para Villa Carlos Paz.
        Domicilio domicilio4 = Domicilio.builder()
                .calle("Calle2")
                .id(1L)
                .numero(112)
                .localidad(villaCarlosPaz)
                .build();

        //	Crear la Sucursal1 y relacionarla con el domicilio de Caba.
        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal 1")
                .id(1L)
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(true)
                .domicilio(domicilio1)
                .build();
        //Crear la Sucursal2 y relacionarla con el domicilio de La Plata.
        Sucursal sucursal2 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio2)
                .build();
        //	Crear la Sucursal3 y relacionarla con el domicilio de Córdoba Capital.
        Sucursal sucursal3 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 3")
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio3)
                .build();
        //	Crear  la Sucursal4 y relacionarla con el domicilio de Villa Carlos Paz.
        Sucursal sucursal4 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 4")
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio4)
                .build();

        //Crear la Empresa1 y relacionarlas con la sucursal 1 y 2.
        Empresa empresa1 = Empresa.builder()
                .nombre("empresa1")
                .cuit(123456)
                .logo("logo")
                .sucursales(new HashSet<>(Set.of(sucursal1, sucursal2)))
                .build();

        //	Crear la Empresa2 y relacionarla con la sucursal 3 y 4.
        Empresa empresa2 = Empresa.builder()
                .nombre("empresa2")
                .cuit(723952)
                .logo("logo2")
                .sucursales(new HashSet<>(Set.of(sucursal3, sucursal4)))
                .build();

        // Crear repositorio y guardar empresas
        InMemoryEmpresaRepository empresaRepo = new InMemoryEmpresaRepository();
        empresaRepo.save(empresa1);
        empresaRepo.save(empresa2);
        //CREACION DE LOS ARTICULOS

        // Categorías
        Categoria pizzas   = Categoria.builder().denominacion("Pizzas").build();
        Categoria sandwich = Categoria.builder().denominacion("Sandwich").build();
        Categoria lomos    = Categoria.builder().denominacion("Lomos").build();
        Categoria insumos  = Categoria.builder().denominacion("Insumos").build();



        // Unidades de medida
        UnidadMedida kilogramos = UnidadMedida.builder().denominacion("Kilogramos").build();
        UnidadMedida litros     = UnidadMedida.builder().denominacion("Litros").build();
        UnidadMedida gramos     = UnidadMedida.builder().denominacion("Gramos").build();


        // Artículos Insumo
        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .unidadMedida(gramos)
                .categoria(insumos)
                .precioCompra(5.0)
                .stockActual(100)
                .stockMaximo(200)
                .esParaElaborar(true)
                .build();

        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .unidadMedida(litros)
                .categoria(insumos)
                .precioCompra(30.0)
                .stockActual(50)
                .stockMaximo(100)
                .esParaElaborar(true)
                .build();

        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .unidadMedida(kilogramos)
                .categoria(insumos)
                .precioCompra(300.0)
                .stockActual(20)
                .stockMaximo(50)
                .esParaElaborar(true)
                .build();

        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .unidadMedida(kilogramos)
                .categoria(insumos)
                .precioCompra(50.0)
                .stockActual(10)
                .stockMaximo(40)
                .esParaElaborar(true)
                .build();
        ArticuloInsumo queso = ArticuloInsumo.builder()
                .denominacion("Queso")
                .unidadMedida(kilogramos)
                .categoria(insumos)
                .precioCompra(150.0)
                .stockActual(5)
                .stockMaximo(13)
                .esParaElaborar(true)
                .build();


        ArticuloManufacturadoDetalle detallePizzaMuzza1 = ArticuloManufacturadoDetalle.builder()
                .id(1L)
                .articuloInsumo(harina)
                .cantidad(1)
                .build();
        ArticuloManufacturadoDetalle detallePizzaMuzza2 = ArticuloManufacturadoDetalle.builder()
                .id(2L)
                .articuloInsumo(queso)
                .cantidad(2)
                .build();
        ArticuloManufacturado pizzaMuzza = ArticuloManufacturado.builder()
                .id(1L)
                .precioVentaRecomendado(8000.0)
                .denominacion("Pizza Muzzarella")
                .categoria(pizzas)
                .preparacion("En horno pizzero por 15 minutos")
                .tiempoEsperadoMinutos(25)
                .descripcion("Pizza Muzzarella con masa a la piedra")
                .build();
        pizzaMuzza.getDetalles().add(detallePizzaMuzza1);
        pizzaMuzza.getDetalles().add(detallePizzaMuzza2);
        // Registro el precio de la pizza por cada sucursal y el stock de sal de la sucursal 1 y 2

        SucursalArticulo pizzaMuzzaSucursal1 = SucursalArticulo.builder()
                .id(1L)
                .articulo(pizzaMuzza)
                .precioVentaArticulo(8500.0)
                .build();
        sucursal1.getSucursalArticulos().add(pizzaMuzzaSucursal1);


        SucursalArticulo pizzaMuzzaSucursal2 = SucursalArticulo.builder()
                .id(1L)
                .articulo(pizzaMuzza)
                .precioVentaArticulo(7500.0)
                .build();
        sucursal2.getSucursalArticulos().add(pizzaMuzzaSucursal2);

        SucursalArticulo salSucursal1 = SucursalArticulo.builder()
                .id(1L)
                .articulo(sal)
                .stockArticulo(21)
                .build();
        sucursal1.getSucursalArticulos().add(salSucursal1);

        SucursalArticulo salSucursal2 = SucursalArticulo.builder()
                .id(1L)
                .articulo(sal)
                .stockArticulo(11)
                .build();
        sucursal1.getSucursalArticulos().add(salSucursal2);
    }
}