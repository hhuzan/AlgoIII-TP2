package AlgoChess;

import AlgoChess.engine.Dinero;
import AlgoChess.engine.entidades.*;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
// import AlgoChess.excepciones.NoMePagasteSuficienteException;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendedorDeEntidadesTest {

    @Test
    public void Test00SeCreaVendedorDeEntidades(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        assertNotNull(vendedor);
    }

    @Test
    public void Test01NoSeLePagaLoSuficienteSoldado(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Soldado entidad = new Soldado();
        Dinero dinero = new Dinero(0);

        assertEquals(null, vendedor.venderEntidad(entidad,dinero));

    }

    @Test
    public void Test02NoSeLePagaLoSuficienteJinete(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Jinete entidad = new Jinete();
        Dinero dinero = new Dinero(0);

        assertEquals(null, vendedor.venderEntidad(entidad,dinero));
    }

    @Test
    public void Test03NoSeLePagaLoSuficienteCurandero(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Curandero entidad = new Curandero();
        Dinero dinero = new Dinero(0);

        assertEquals(null, vendedor.venderEntidad(entidad,dinero));
    }

    @Test
    public void Test04NoSeLePagaLoSuficienteCatapulta(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Catapulta catapulta = new Catapulta();
        Dinero dinero = new Dinero(0);

        assertEquals(null, vendedor.venderEntidad(catapulta,dinero));
    }



    @Test
    public void Test05SeCompraSoldado() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Soldado entidad = new Soldado();
        Dinero dinero = new Dinero(1);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);

    }



    @Test
    public void Test06SeCompraJinete() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Jinete entidad = new Jinete();
        Dinero dinero = new Dinero(3);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);
    }

    @Test
    public void Test07SeCompraCurandero() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Curandero entidad = new Curandero();
        Dinero dinero = new Dinero(3);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);
    }

    @Test
    public void Test08SeCompraCatapulta() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Catapulta entidad = new Catapulta();
        Dinero dinero = new Dinero(5);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertEquals(entidad, entidadComprada);
    }

}
