package algochess;

import algochess.engine.entidades.Vida;
import org.junit.Test;
import static org.junit.Assert.*;

public class VidaTest {

    @Test
    public void test00ConstructorVidaNoDevuelveNull() {
        Vida vida = new Vida(50);
        assertNotNull(vida);
    }

    @Test
    public void test01PuedoIgualarVidas() {
        Vida vida = new Vida(50);
        assertTrue(vida.igualA(50));
    }

    @Test
    public void test02PuedoDisminuirVida() {
        Vida vida = new Vida(50);
        vida.disminuir(20);
        assertTrue(vida.igualA(30));
    }

    @Test
    public void test02PuedoAumentarVida() {
        Vida vida = new Vida(50);
        vida.disminuir(20);
        vida.aumentar(10);
        assertTrue(vida.igualA(40));
    }

    @Test
    public void test03SiAumentoMasQueLaVidaMaximaEstaNoSeAumentaMas() {
        Vida vida = new Vida(50);
        vida.aumentar(1000000);
        assertTrue(vida.igualA(50));
    }

    @Test
    public void test04SiLaVidaEstaEn0Muere() {
        Vida vida = new Vida(50);
        vida.disminuir(50);
        assertTrue(vida.fallecio());
    }

    @Test
    public void test05SiRestoMasVidaDeLaQueTieneMuere() {
        Vida vida = new Vida(50);
        vida.disminuir(100000000);
        assertTrue(vida.fallecio());
    }

}
