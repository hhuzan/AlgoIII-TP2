package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatapultaTest {

	@Test
	void test00ConstructorCatapultaNoDevuelveNull() {
		Catapulta catapulta = new Catapulta();
		assertNotNull(catapulta);
	}

}
