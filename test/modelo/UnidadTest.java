package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Unidad;

class UnidadTest {

	@Test
	void test00ConstructorUnidadNoDevuelveNull() {
		Unidad unidad = new Unidad();
		assertNotNull(unidad);
	}

}
