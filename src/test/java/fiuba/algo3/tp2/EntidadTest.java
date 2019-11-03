package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class EntidadTest {

	@Test
	public void test00ConstructorUnidadNoDevuelveNull() {
		Entidad entidad = new Entidad();
		assertNotNull(entidad);
	}

}
