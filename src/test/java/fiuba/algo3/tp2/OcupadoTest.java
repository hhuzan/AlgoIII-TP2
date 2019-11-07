package fiuba.algo3.tp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CasilleroOcupadoException;

public class OcupadoTest {

	@Test
	public void test00ConstructorVacioNoDevuelveNull() {
		Casillero casillero = new CasilleroAliado();
		Vacio vacio = new Vacio(casillero);
		assertNotNull(vacio);
	}

	@Test
	public void test01EstadoOcupadoNuncaDevuelveVacio() {
		Casillero casillero = new CasilleroAliado();
		Ocupado ocupado = new Ocupado(casillero);
		assertFalse(ocupado.estaVacio());
	}

	@Test
	public void test02ColocamosUnaEntidadEnUnEstadoOcupadoYArrojaUnaExcepcion() {
		Casillero casillero = new CasilleroAliado();
		Ocupado ocupado = new Ocupado(casillero);
		Jugador jugador = new Jugador();
		Entidad entidad = new Aliado(new Soldado(jugador));
		assertThrows(CasilleroOcupadoException.class, () -> {
			ocupado.colocar(entidad);
		});
	}

	@Test
	public void test04MovemosUnaEntidadDesdeUnCasilleroAUnCasilleroOcupadoYArrojaExcepcion() {
		Casillero casilleroOrigen = new CasilleroAliado();
		Casillero casilleroDestino = new CasilleroAliado();
		Ocupado ocupado = new Ocupado(casilleroDestino);
		Entidad entidad = new Aliado(new Soldado(new Jugador()));
		casilleroOrigen.setEntidad(entidad);
		assertThrows(CasilleroOcupadoException.class, () -> {
			ocupado.moverDesde(casilleroOrigen);
		});
	}
}
