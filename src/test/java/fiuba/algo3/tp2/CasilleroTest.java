package fiuba.algo3.tp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;

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

	@Test 
	public void test04CreoCasilleroConFilaYColumnaYEsasSonSusCoordenadas() {
		Casillero casillero = new CasilleroAliado(1,2);
		assertEquals(1, casillero.getFila());
		assertEquals(2, casillero.getColumna());
	}

	@Test 
	public void test05ColocoUnidadAliadaEnCasilleroAliadoYSeAlmacena() {
		Casillero casillero = new CasilleroAliado();
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		casillero.colocar(aliado);
		assertEquals(aliado, casillero.getEntidad());
	}

	@Test 
	public void test06ColocoUnidadAliadaEnCasilleroEnemigoYArrojaExcepcion() {
		Casillero casillero = new CasilleroEnemigo();
		Aliado aliado = new Aliado(new Soldado(new Jugador()));
		assertThrows(ColocarEntidadException.class, () -> {
			casillero.colocar(aliado);
		});
	}

	@Test 
	public void test07ColocoUnaEntidadEnElCasilleroYSeAlmacena() {
		Casillero casillero = new CasilleroAliado();
		Aliado soldado = new Aliado(new Soldado(new Jugador()));
		casillero.setEntidad(soldado);
		assertEquals(soldado, casillero.getEntidad());
	}

	@Test 
	public void test08ColocoUnaEntidadEnElCasilleroYAlRemoverlaLaObtengo() {
		Casillero casillero = new CasilleroAliado();
		Aliado soldado = new Aliado(new Soldado(new Jugador()));
		casillero.setEntidad(soldado);
		Entidad entidad = casillero.popEntidad();
		assertEquals(entidad, soldado);		
	}

	@Test 
	public void test09ColocoUnaEntidadEnElCasilleroYAlRemoverlaElCasilleroEstaVacio() {
		Casillero casillero = new CasilleroAliado();
		Aliado soldado = new Aliado(new Soldado(new Jugador()));
		casillero.setEntidad(soldado);
		Entidad entidad = casillero.popEntidad();
		assertTrue(casillero.estaVacio());
	}

	@Test 
	public void test10ColocoUnaEntidadEnUnCasilleroYLuegoAlMoverlaEstaEnElCasilleroDestino() {
		Casillero casilleroOrigen= new CasilleroAliado();
		Casillero casilleroDestino = new CasilleroAliado();
		Aliado soldado = new Aliado(new Soldado(new Jugador()));
		casilleroOrigen.setEntidad(soldado);
		casilleroDestino.moverDesde(casilleroOrigen);
		assertEquals(soldado, casilleroDestino.getEntidad());
	}
}
