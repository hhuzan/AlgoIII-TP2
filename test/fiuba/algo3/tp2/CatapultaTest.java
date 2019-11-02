package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CatapultaTest {

	@Test
	public void test00ConstructorCatapultaNoDevuelveNull() {
		Catapulta catapulta = new Catapulta();
		assertNotNull(catapulta);
	}

}
