package juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest {

	@Test
	void testNotNullConstructo() {
		Tablero tablero = new Tablero();
		assertNotNull(tablero);
	}

}
