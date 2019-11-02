package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Soldado;

class SoldadoTest {

	@Test
	void test00ConstructorSoldadoNoDevuelveNull() {
		Soldado soldado = new Soldado();
		assertNotNull(soldado);
	}

}
