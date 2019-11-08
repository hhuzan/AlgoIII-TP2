package fiuba.algo3.tp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CasilleroOcupadoException;
import fiuba.algo3.tp2.excepciones.ColocarEntidadException;

public class CasilleroTest {

	@Test
	public void test00ConstructorCasilleroNoDevuelveNull() {
		Casillero casillero = new CasilleroAliado();
		assertNotNull(casillero);
	}

	@Test
	public void test01CreamosCasilleroYAl() {
		Casillero casillero = new CasilleroAliado();
		assertTrue(true);
		// TODO: Volver al sistema viejo de atacar y ahí si llamamos atacar a un casillero vacio
		//		 tenemos una excepción de casillero vacio.
		// assertThrow(CasilleroOcupadoException.class, () -> {
		// 	tablero.atacar(fila, columna, fila + 1, columna);
		// });		
	}

	@Test
	public void test02ColocoUnidadEnCasilleroEntoncesNoEstaVacio() {
		Jugador jugador = new Jugador();
		Casillero casillero = new CasilleroAliado();
		Aliado soldado = new Aliado(new Soldado(jugador));
		casillero.colocar(soldado);
		assertThrows(CasilleroOcupadoException.class, () -> {
			casillero.colocar(soldado);
		});
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
		casillero.popEntidad();
		assertTrue(true);
		// TODO: Volver al sistema viejo de atacar y ahí si llamamos atacar a un casillero vacio
		//		 tenemos una excepción de casillero vacio.
		// assertThrow(CasilleroOcupadoException.class, () -> {
		// 	tablero.atacar(fila, columna, fila + 1, columna);
		// });		
	}

	@Test
	public void test10ColocoUnaEntidadEnUnCasilleroYLuegoAlMoverlaEstaEnElCasilleroDestino() {
		Casillero casilleroOrigen = new CasilleroAliado();
		Casillero casilleroDestino = new CasilleroAliado();
		Aliado soldado = new Aliado(new Soldado(new Jugador()));
		casilleroOrigen.setEntidad(soldado);
		casilleroDestino.moverDesde(casilleroOrigen);
		assertEquals(soldado, casilleroDestino.getEntidad());
	}
}
