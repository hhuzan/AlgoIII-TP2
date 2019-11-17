package AlgoChess.dinero;
import AlgoChess.engine.Dinero;
import AlgoChess.excepciones.DineroInsuficienteException;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DineroTest {

    @Test
    public void Test00ConstructorNoDevuelveNull() {
        Dinero dinero = new Dinero(0);
        assertNotNull(dinero);
    }

    @Test
    public void Test01DosDinerosSonIgualesSiTienenElmismoMonto() {
        Dinero dinero1 = new Dinero(3);
        Dinero dinero2 = new Dinero(3);
        assertTrue(dinero1.sonIguales(dinero2));
    }

    @Test
    public void Test02DosDinerosSonDistintosSiTienenDistintosMontos() {
        Dinero dinero1 = new Dinero(1);
        Dinero dinero2 = new Dinero(2);
        assertFalse(dinero1.sonIguales(dinero2));
    }

}

  /*  @Test
    public void Test03NoSePuedeRestarMasDineroDelQueTenes(){
        Dinero dinero1 = new Dinero(0);
        Dinero dinero2 = new Dinero(1);
        assertThrows(DineroInsuficienteException.class, () -> dinero1.restarDinero(dinero2));
    }
}

   */