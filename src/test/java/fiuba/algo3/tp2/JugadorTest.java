package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class JugadorTest {

	@Test
	public void test00ConstructorJugadorNoDevuelveNull() {
		Jugador jugador = new Jugador();
		assertNotNull(jugador);
	}

}
