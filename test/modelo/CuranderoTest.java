package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuranderoTest {

	@Test
	void test00ConstructorCuranderoNoDevuelveNull() {
		Curandero curandero = new Curandero();
		assertNotNull(curandero);
	}

}
