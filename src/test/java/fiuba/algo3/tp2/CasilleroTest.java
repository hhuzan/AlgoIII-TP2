package fiuba.algo3.tp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CasilleroTest {

	@Test
	public void test00ConstructorCasilleroNoDevuelveNull() {
		Casillero casillero = new Casillero();
		assertNotNull(casillero);
	}

	@Test
	public void test01CasilleroNuevoEstaVacio() {
		Casillero casillero = new Casillero();
		assertTrue(casillero.estaVacio());
	}

	@Test
	public void test02ColocoUnidadCasilleroNoEstaVacio() {
		Casillero casillero = new Casillero();
		Unidad soldado = new Soldado();
		casillero.colocar(soldado);
		assertTrue(casillero.estaVacio());
	}

}
