package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TableroTest {

	@Test
	public void test00ConstructorTableroNoDevuelveNull() {
		Tablero tablero = new Tablero();
		assertNotNull(tablero);
	}

	@Test
	public void test01AgregoUnaJineteAlTableroYLeRestoTresPuntosAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		Entidad jinete = new Aliado(new Jinete(jugador));

		tablero.colocar(jinete, 1, 1);
		assertEquals(17, jugador.obtenerPuntos());
	}

	@Test
	public void test02AgregoDosJinetesAlTableroYLeRestoSeisPuntosAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();

		tablero.colocar(new Aliado(new Jinete(jugador)), 1, 1);
		tablero.colocar(new Aliado(new Jinete(jugador)), 1, 2);
		assertEquals(14, jugador.obtenerPuntos());
	}

	@Test
	public void test10AgregoAliadoEnSectorAliadoPosionNoQuedaVacia() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 5;
		int columna = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		assertFalse(tablero.estaVacio(fila, columna));
	}

	@Test
	public void test11AgregoEnemigoEnSectorEnemigoPosionNoQuedaVacia() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 15;
		int columna = 10;
		tablero.colocar(new Enemigo(new Soldado(jugador)), fila, columna);
		assertFalse(tablero.estaVacio(fila, columna));
	}

	@Test
	public void test12AgregoEnemigoEnSectorAliadoPosionQuedaVacia() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 5;
		int columna = 10;
		tablero.colocar(new Enemigo(new Soldado(jugador)), fila, columna);
		assertTrue(tablero.estaVacio(fila, columna));
	}

	@Test
	public void test13AgregoAliadoEnSectorEnemigoPosionQuedaVacia() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 15;
		int columna = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		assertTrue(tablero.estaVacio(fila, columna));
	}

	@Test
	public void test20Agrego2AliadosEnMismoCasilleroAliadoArrojaExcepcion() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 5;
		int columna = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		});

	}

	@Test
	public void test30MoverArribar() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)),filaOrigen, columnaOrigen);
		tablero.moverArriba(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen - 1, columnaOrigen));
	}

	@Test
	public void test31MoverAbajo() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)),filaOrigen, columnaOrigen);
		tablero.moverAbajo(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen + 1, columnaOrigen));
	}

	@Test
	public void test32MoverIzquierda() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)),filaOrigen, columnaOrigen);
		tablero.moverIzquierda(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen - 1));
	}

	@Test
	public void test33MoverDerecha() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)),filaOrigen, columnaOrigen);
		tablero.moverDerecha(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen + 1));
	}

	@Test
	public void test34MoverEntidadACasilleroOcupadoArrojaExcepcion() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 1;
		int columnaOrigen = 1;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen + 1);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.moverDerecha(filaOrigen, columnaOrigen);
		});
	}

	@Test
	public void test39MoverEntidadACasilleroOcupadoCasilleroOrigenQuedaOcupado() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 1;
		int columnaOrigen = 1;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen + 1);
		tablero.moverDerecha(filaOrigen, columnaOrigen);
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen));
	}

	@Test 
	public void test35SoldadoAliadoAtacaPiezaEnemigaYRestaAlJugadorDePiezaEnemiga() {
		
	}

}
