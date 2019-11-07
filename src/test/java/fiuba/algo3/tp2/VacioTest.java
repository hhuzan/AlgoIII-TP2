package fiuba.algo3.tp2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class VacioTest {

	@Test
	public void test00ConstructorVacioNoDevuelveNull() {
		Casillero casillero = new CasilleroAliado(1, 1);
		Vacio vacio = new Vacio(casillero);
		assertNotNull(vacio);
	}

	@Test
	public void test01EstadoVacioSiempreDevuelveVacio() {
		Casillero casillero = new CasilleroAliado(1, 1);
		Vacio vacio = new Vacio(casillero);
		assertTrue(vacio.estaVacio());
	}

	@Test
	public void test02ColocamosUnaEntidadEnUnEstadoVacioYDevuelveUnEstadoOcupado() {
		Casillero casillero = new CasilleroAliado(1, 1);
		Vacio vacio = new Vacio(casillero);
		Jugador jugador = new Jugador();
		Entidad entidad = new Aliado(new Soldado(jugador));
		Estado estado = vacio.colocar(entidad);
		assertFalse(estado.estaVacio());
	}

	@Test
	public void test04MovemosUnaEntidadDesdeUnCasilleroAUnCasilleroVacioYDevuelveUnEstadoOcupado() {
		Casillero casilleroOrigen = new CasilleroAliado(1, 1);
		Vacio vacio = new Vacio(casilleroOrigen);
		Entidad entidad = new Aliado(new Soldado(new Jugador()));
		casilleroOrigen.setEntidad(entidad);
		Estado estado = vacio.moverDesde(casilleroOrigen);
		assertFalse(estado.estaVacio());
	}
}
