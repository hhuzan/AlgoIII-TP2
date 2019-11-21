package algochess;

import algochess.engine.Dinero;
import algochess.engine.entidades.*;
import algochess.engine.vendedorDeEntidades.VendedorDeEntidades;
import algochess.excepciones.DineroInsuficienteException;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendedorDeEntidadesTest {

    @Test
    public void test00SeCreaVendedorDeEntidades(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        assertNotNull(vendedor);
    }

    @Test
    public void test01NoSeLePagaLoSuficienteSoldado(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Soldado entidad = new Soldado();
        Dinero dinero = new Dinero(0);

        assertThrows(DineroInsuficienteException.class,()-> vendedor.venderEntidad(entidad,dinero));

    }

    @Test
    public void test02NoSeLePagaLoSuficienteJinete(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Jinete entidad = new Jinete();
        Dinero dinero = new Dinero(0);

        assertThrows(DineroInsuficienteException.class,()-> vendedor.venderEntidad(entidad,dinero));
    }

    @Test
    public void test03NoSeLePagaLoSuficienteCurandero(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Curandero entidad = new Curandero();
        Dinero dinero = new Dinero(0);

        assertThrows(DineroInsuficienteException.class,()-> vendedor.venderEntidad(entidad,dinero));
    }

    @Test
    public void test04NoSeLePagaLoSuficienteCatapulta(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Catapulta catapulta = new Catapulta();
        Dinero dinero = new Dinero(0);

        assertThrows(DineroInsuficienteException.class,()-> vendedor.venderEntidad(catapulta,dinero));
    }



    @Test
    public void test05SeCompraSoldado() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Soldado entidad = new Soldado();
        Dinero dinero = new Dinero(1);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);

    }



    @Test
    public void test06SeCompraJinete() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Jinete entidad = new Jinete();
        Dinero dinero = new Dinero(3);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);
    }

    @Test
    public void test07SeCompraCurandero() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Curandero entidad = new Curandero();
        Dinero dinero = new Dinero(3);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);
    }

    @Test
    public void test08SeCompraCatapulta() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Catapulta entidad = new Catapulta();
        Dinero dinero = new Dinero(5);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);
    }

}
