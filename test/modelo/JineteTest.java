package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JineteTest {

	@Test
	void test00ConstructorJineteNoDevuelveNull() {
		Jinete jinete = new Jinete();
		assertNotNull(jinete);
	}

}
