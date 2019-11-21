package algoChess;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import algoChess.engine.matematica.Calculadora;
import org.junit.Test;
import static algoChess.engine.Constantes.RANGO_CERCANO_MINIMO;
import static algoChess.engine.Constantes.RANGO_CERCANO_MAXIMO;
import static algoChess.engine.Constantes.RANGO_MEDIO_MINIMO;
import static algoChess.engine.Constantes.RANGO_MEDIO_MAXIMO;
import static algoChess.engine.Constantes.RANGO_LEJANO_MINIMO;
import static algoChess.engine.Constantes.RANGO_LEJANO_MAXIMO;

public class CalculadoraTest {

	@Test
	public void test00ConstructorCalculadoraNoDevuelveNull() {
		Calculadora calculadora = new Calculadora();
		assertNotNull(calculadora);
	}

	@Test
	public void test01CalculadoraNosDaDistanciaValidaParaUnaDistanciaCercana() {
        Calculadora calculadora = new Calculadora();
        int origen_col = 1;
        int origen_fila = 3;
        int destino_col = 3;
        int destino_fila = 1;
        int distanciaMin = RANGO_CERCANO_MINIMO;
        int distanciaMax = RANGO_CERCANO_MAXIMO;

        assertTrue(calculadora.distanciaValidaEntreDosPosiciones(origen_col, origen_fila, destino_col, destino_fila, distanciaMin, distanciaMax));

	}

    @Test
    public void test02CalculadoraNosDaDistanciaValidaParaUnaDistanciaMedia() {
        Calculadora calculadora = new Calculadora();
        int origen_col = 1;
        int origen_fila = 1;
        int destino_col = 4;
        int destino_fila = 4;
        int distanciaMin = RANGO_MEDIO_MINIMO;
        int distanciaMax = RANGO_MEDIO_MAXIMO;

        assertTrue(calculadora.distanciaValidaEntreDosPosiciones(origen_col, origen_fila, destino_col, destino_fila, distanciaMin, distanciaMax));

    }

    @Test 
    public void test03CalculadoraNosDaDistanciaValidaParaUnaDistanciaLejana() {
        Calculadora calculadora = new Calculadora();
        int origen_col = 1;
        int origen_fila = 1;
        int destino_col = 7;
        int destino_fila = 7;
        int distanciaMin = RANGO_LEJANO_MINIMO;
        int distanciaMax = RANGO_LEJANO_MAXIMO;

        assertTrue(calculadora.distanciaValidaEntreDosPosiciones(origen_col, origen_fila, destino_col, destino_fila, distanciaMin, distanciaMax));
    }

    @Test 
    public void test04CalculadoraNosDaDistanciaInvalidaParaCasoQueNoCumple() {
        Calculadora calculadora = new Calculadora();
        int origen_col = 1;
        int origen_fila = 1;
        int destino_col = 2;
        int destino_fila = 2;
        int distanciaMin = RANGO_LEJANO_MINIMO;
        int distanciaMax = RANGO_LEJANO_MAXIMO;

        assertFalse(calculadora.distanciaValidaEntreDosPosiciones(origen_col, origen_fila, destino_col, destino_fila, distanciaMin, distanciaMax));

    }
}
