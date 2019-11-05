package fiuba.algo3.tp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class CasilleroTest {

	@Test
	public void test00ConstructorCasilleroNoDevuelveNull() {
		Casillero casillero = new CasilleroAliado();
		assertNotNull(casillero);
	}

	@Test
	public void test01CasilleroNuevoEstaVacio() {
		Casillero casillero = new CasilleroAliado();
		assertTrue(casillero.estaVacio());
	}

	@Test
	public void test02ColocoUnidadEnCasilleroEntoncesNoEstaVacio() {
		Jugador jugador = new Jugador();
		Casillero casillero = new CasilleroAliado();
		Aliado soldado = new Aliado(new Soldado(jugador));
		casillero.colocar(soldado);
		assertFalse(casillero.estaVacio());
	}

	@Test
	public void test03Coloco2UnidadesEnCasilleroArrojaExcepcion() {
		Jugador jugador = new Jugador();
		Casillero casillero = new CasilleroAliado();
		Aliado unSoldado = new Aliado(new Soldado(jugador));
		Aliado otroSoldado = new Aliado(new Soldado(jugador));
		casillero.colocar(unSoldado);
		assertThrows(CasilleroOcupadoException.class, () -> {
			casillero.colocar(otroSoldado);
		});
	}
}
