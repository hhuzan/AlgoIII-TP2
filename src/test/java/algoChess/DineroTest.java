package algoChess;

import algoChess.engine.Dinero;
import org.junit.Test;
import static org.junit.Assert.*;

public class DineroTest {

    @Test
    public void test00ConstructorNoDevuelveNull() {
        Dinero dinero = new Dinero(0);
        assertNotNull(dinero);
    }

    @Test
    public void test01DosDinerosSonIgualesSiTienenElmismoMonto() {
        Dinero dinero1 = new Dinero(3);
        Dinero dinero2 = new Dinero(3);
        assertTrue(dinero1.sonIguales(dinero2));
    }

    @Test
    public void test02DosDinerosSonDistintosSiTienenDistintosMontos() {
        Dinero dinero1 = new Dinero(1);
        Dinero dinero2 = new Dinero(2);
        assertFalse(dinero1.sonIguales(dinero2));
    }


    @Test
    public void test03NoSePuedeRestarMasDineroDelQueTenes(){
        Dinero dinero1 = new Dinero(0);
        Dinero dinero2 = new Dinero(1);
        Dinero expected = dinero1.restarDinero(dinero2);
        Dinero test = new Dinero(0);
        assertTrue(expected.sonIguales(test));
    }
}