package juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JugadorTest {

	@Test
	void test00ConstructorJugadorNoDevuelveNull() {
		Jugador jugador = new Jugador();
		assertNotNull(jugador);
	}

}
