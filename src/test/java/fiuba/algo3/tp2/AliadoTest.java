package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

class AliadoTest {

	@Test
	public void test00ConstructorAliadoNoDevuelveNull() {
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		assertNotNull(aliado);
	}

}
