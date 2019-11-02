package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CasilleroTest {

	@Test
	public void test00ConstructorCasilleroNoDevuelveNull() {
		Casillero casillero = new Casillero();
		assertNotNull(casillero);
	}

}
