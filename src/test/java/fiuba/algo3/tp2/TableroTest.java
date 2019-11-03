package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TableroTest {

	@Test
	public void test00ConstructorTableroNoDevuelveNull() {
		Tablero tablero = new Tablero();
		assertNotNull(tablero);
	}

	@Test
	public void test01CAgregoUnaEntidadAlTableroYLeRestoVidaAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		Jinete jinete = new Jinete(jugador);

		tablero.agregarEntidadATablero(1,1,jinete);
		assertEquals(17, jugador.obtenerPuntos());
	}

	@Test
	public void test02CAgregoDosEntidadesAlTableroYLeRestoVidaAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();

		tablero.agregarEntidadATablero(1,1,new Jinete(jugador));
		tablero.agregarEntidadATablero(1,2,new Jinete(jugador));
		assertEquals(14, jugador.obtenerPuntos());
	}

}
