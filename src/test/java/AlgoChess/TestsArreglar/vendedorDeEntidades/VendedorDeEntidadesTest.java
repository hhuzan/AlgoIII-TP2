package AlgoChess.vendedorDeEntidades;

import AlgoChess.engine.Dinero;
import AlgoChess.engine.entidades.*;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import AlgoChess.excepciones.NoMePagasteSuficienteException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
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

        assertThrows(NoMePagasteSuficienteException.class,()->{vendedor.venderEntidad(entidad,dinero);});
    }


    @Test
    public void Test02NoSeLePagaLoSuficienteJinete(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Jinete entidad = new Jinete();
        Dinero dinero = new Dinero(0);

        assertThrows(NoMePagasteSuficienteException.class,()->{vendedor.venderEntidad(entidad,dinero);});
    }

    @Test
    public void Test03NoSeLePagaLoSuficienteCurandero(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Curandero enttidad = new Curandero();
        Dinero dinero = new Dinero(0);

        assertThrows(NoMePagasteSuficienteException.class,()->{vendedor.venderEntidad(enttidad,dinero);});
    }

    @Test
    public void Test04NoSeLePagaLoSuficienteCatapulta(){
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Catapulta catapulta = new Catapulta();
        Dinero dinero = new Dinero(0);

        assertThrows(NoMePagasteSuficienteException.class,()->{vendedor.venderEntidad(catapulta,dinero);});
    }

    @Test
    public void Test05SeCompraSoldado() throws NoMePagasteSuficienteException {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Soldado entidad = new Soldado();
        Dinero dinero = new Dinero(1);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertSame(entidadComprada.getClass(), entidad.getClass());
    }

    @Test
    public void Test06SeCompraJinete() throws NoMePagasteSuficienteException {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Jinete entidad = new Jinete();
        Dinero dinero = new Dinero(3);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertSame(entidadComprada.getClass(), entidad.getClass());
    }

    @Test
    public void Test07SeCompraCurandero() throws NoMePagasteSuficienteException {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Curandero entidad = new Curandero();
        Dinero dinero = new Dinero(3);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertSame(entidadComprada.getClass(), entidad.getClass());
    }

    @Test
    public void Test08SeCompraCatapulta() throws NoMePagasteSuficienteException {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        Catapulta entidad = new Catapulta();
        Dinero dinero = new Dinero(5);

        Entidad entidadComprada = vendedor.venderEntidad(entidad,dinero);
        assertSame(entidadComprada.getClass(), entidad.getClass());
    }

}
