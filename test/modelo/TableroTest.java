package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Tablero;

class TableroTest {

	@Test
	void test00ConstructorTableroNoDevuelveNull() {
		Tablero tablero = new Tablero();
		assertNotNull(tablero);
	}

}
