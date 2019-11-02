package juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnidadTest {

	@Test
	void test00ConstructorUnidadNoDevuelveNull() {
		Unidad unidad = new Unidad();
		assertNotNull(unidad);
	}

}
