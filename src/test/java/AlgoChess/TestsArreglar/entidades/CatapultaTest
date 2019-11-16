package AlgoChess.entidades;

import AlgoChess.engine.entidades.Catapulta;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class CatapultaTest {

    @Test
    public void Test00ConstructorDevuelveCatapulta(){
        Catapulta catapulta = new Catapulta();
        assertNotNull(catapulta);
    }

    @Test
    public void Test01CatapultaSeClona(){
        Catapulta catapulta = new Catapulta();
        Catapulta catapulta1 = catapulta.clonar();

        assertNotSame(catapulta1, catapulta);
    }
}
