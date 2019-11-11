package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.ColocarEntidadException;

public class AliadoTest {

	@Test
	public void test00ConstructorAliadoNoDevuelveNull() {
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		assertNotNull(aliado);
	}

	@Test
	public void test01ColocamosAliadoEnCasilleroAliadoYAliadoYQuedaAlmacenado() {
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		Casillero casillero = new CasilleroAliado();
		aliado.colocarEn(casillero);
		assertEquals(aliado, casillero.getEntidad());
	}

	@Test
	public void test02ColocamosAliadoEnCasilleroEnemigoYObtenemosUnaExcepcion() {
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		Casillero casillero = new CasilleroEnemigo();
		assertThrows(ColocarEntidadException.class, () -> {
			aliado.colocarEn(casillero);
		});
	}
}
