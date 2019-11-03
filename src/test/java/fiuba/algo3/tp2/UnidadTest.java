package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class UnidadTest {

	@Test
	public void test00ConstructorUnidadNoDevuelveNull() {
		Unidad unidad = new Unidad();
		assertNotNull(unidad);
	}

}
