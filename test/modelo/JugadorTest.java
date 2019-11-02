package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;

class JugadorTest {

	@Test
	void test00ConstructorJugadorNoDevuelveNull() {
		Jugador jugador = new Jugador();
		assertNotNull(jugador);
	}

}
