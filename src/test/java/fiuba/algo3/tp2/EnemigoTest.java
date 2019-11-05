package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

class EnemigoTest {

	@Test
	public void test00ConstructorEnemigoNoDevuelveNull() {
		Enemigo enemigo = new Enemigo(new Soldado(new Jugador()));
		assertNotNull(enemigo);
	}

}
