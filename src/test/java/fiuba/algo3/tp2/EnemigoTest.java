package fiuba.algo3.tp2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import fiuba.algo3.tp2.Excepciones.ColocarEntidadException;

public class EnemigoTest {

	@Test
	public void test00ConstructorEnemigoNoDevuelveNull() {
		Enemigo enemigo = new Enemigo(new Soldado(new Jugador()));
		assertNotNull(enemigo);
	}

	@Test
	public void test01ColocamosEnemigoEnCasilleroEnemigoYEnemigoQuedaAlmacenado() {
		Enemigo enemigo = new Enemigo(new Soldado(new Jugador()));
		Casillero casillero = new CasilleroEnemigo(10, 1);
		enemigo.colocarEn(casillero);
		assertEquals(enemigo, casillero.getEntidad());
	}

	@Test
	public void test02ColocamosEnemigoEnCasilleroAliadoYObtenemosUnaExcepcion() {
		Enemigo enemigo = new Enemigo(new Soldado(new Jugador()));
		Casillero casillero = new CasilleroAliado(1, 1);
		assertThrows(ColocarEntidadException.class, () -> {
			enemigo.colocarEn(casillero);
		});
	}
}
