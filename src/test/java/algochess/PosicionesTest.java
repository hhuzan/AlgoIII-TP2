package algochess;

import algochess.engine.posicion.Posicion;
import algochess.engine.posicion.Posiciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PosicionesTest {
	@Test
	public void test00constructorNoNulo() {
		Posiciones posiciones = new Posiciones();
		assertNotNull(posiciones);
	}

	@Test
	public void test01posicionesPoseeConjuntoVacio() {
		Posiciones posiciones = new Posiciones();
		assertEquals(0, posiciones.posiciones().size());
	}

	@Test
	public void test02seAgregaPosicion() {
		Posiciones posiciones = new Posiciones();
		posiciones.agregar(new Posicion(1, 1));
		assertEquals(1, posiciones.posiciones().size());
	}

	@Test
	public void test03seAgregaPosicionRepetida() {
		Posiciones posiciones = new Posiciones();
		posiciones.agregar(new Posicion(1, 1));
		posiciones.agregar(new Posicion(1, 1));
		assertEquals(1, posiciones.posiciones().size());
	}

	@Test
	public void test04posicionesContienePosicion() {
		Posiciones posiciones = new Posiciones();
		posiciones.agregar(new Posicion(1, 1));
		assertTrue(posiciones.contiene(new Posicion(1, 1)));
	}

	@Test
	public void test05posicionesRemuevePosicion() {
		Posiciones posiciones = new Posiciones();
		Posicion posicion = new Posicion(1, 1);
		posiciones.agregar(posicion);
		posiciones.remover(posicion);
		assertEquals(0, posiciones.posiciones().size());
	}

}
