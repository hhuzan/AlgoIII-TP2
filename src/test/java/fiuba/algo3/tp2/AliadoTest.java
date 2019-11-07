package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import fiuba.algo3.tp2.Excepciones.ColocarEntidadException;

public class AliadoTest {

	@Test
	public void test00ConstructorAliadoNoDevuelveNull() {
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		assertNotNull(aliado);
	}

	@Test
	public void test01ColocamosAliadoEnCasilleroAliadoYAliadoYQuedaAlmacenado() {
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		Casillero casillero = new CasilleroAliado(1, 1);
		aliado.colocarEn(casillero);
		assertEquals(aliado, casillero.getEntidad());
	}

	@Test
	public void test02ColocamosAliadoEnCasilleroEnemigoYObtenemosUnaExcepcion() {
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		Casillero casillero = new CasilleroEnemigo(10, 1);
		assertThrows(ColocarEntidadException.class, () -> {
			aliado.colocarEn(casillero);
		});
	}
}
