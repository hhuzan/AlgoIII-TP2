package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casillero;

class CasilleroTest {

	@Test
	void test00ConstructorCasilleroNoDevuelveNull() {
		Casillero casillero = new Casillero();
		assertNotNull(casillero);
	}

}
