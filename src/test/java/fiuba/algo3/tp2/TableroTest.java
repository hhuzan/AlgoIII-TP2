package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TableroTest {

	@Test
	public void test00ConstructorTableroNoDevuelveNull() {
		Tablero tablero = new Tablero();
		assertNotNull(tablero);
	}

	@Test
	public void test01AgregoUnaEntidadAlTableroYLeRestoVidaAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		Jinete jinete = new Jinete(jugador);

		tablero.agregar(1, 1, jinete);
		assertEquals(17, jugador.obtenerPuntos());
	}

	@Test
	public void test02AgregoDosEntidadesAlTableroYLeRestoVidaAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();

		tablero.agregar(1, 1, new Jinete(jugador));
		tablero.agregar(1, 2, new Jinete(jugador));
		assertEquals(14, jugador.obtenerPuntos());
	}

	@Test
	public void test03AgregoEntidadPosionNoQuedaVacia() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 10;
		int columna = 10;
		tablero.agregar(fila, columna, new Soldado(jugador));
		assertFalse(tablero.estaVacio(fila, columna));
	}

	@Test
	public void test04MoverArribar() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 10;
		int columnaOrigen = 10;
		tablero.agregar(filaOrigen, columnaOrigen, new Soldado(jugador));
		tablero.moverArriba(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen - 1, columnaOrigen));
	}

	@Test
	public void test05MoverAbajo() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 10;
		int columnaOrigen = 10;
		tablero.agregar(filaOrigen, columnaOrigen, new Soldado(jugador));
		tablero.moverAbajo(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen + 1, columnaOrigen));
	}

	@Test
	public void test06MoverIzquierda() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 10;
		int columnaOrigen = 10;
		tablero.agregar(filaOrigen, columnaOrigen, new Soldado(jugador));
		tablero.moverIzquierda(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen - 1));
	}

	@Test
	public void test07MoverDerecha() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 10;
		int columnaOrigen = 10;
		tablero.agregar(filaOrigen, columnaOrigen, new Soldado(jugador));
		tablero.moverDerecha(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen + 1));
	}

}
