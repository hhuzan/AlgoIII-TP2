package juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CasilleroTest {

	@Test
	void test00ConstructorCasilleroNoDevuelveNull() {
		Casillero casillero = new Casillero();
		assertNotNull(casillero);
	}

}
