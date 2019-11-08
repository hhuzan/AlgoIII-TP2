package fiuba.algo3.tp2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import fiuba.algo3.tp2.excepciones.CasilleroOcupadoException;

public class VacioTest {

	@Test
	public void test00ConstructorVacioNoDevuelveNull() {
		Casillero casillero = new CasilleroAliado();
		Vacio vacio = new Vacio(casillero);
		assertNotNull(vacio);
	}

	@Test
	public void test02ColocamosUnaEntidadEnUnEstadoVacioYArrojaExcepcionAlColocarUnaEntidad() {
		Casillero casillero = new CasilleroAliado();
		Vacio vacio = new Vacio(casillero);
		Jugador jugador = new Jugador();
		Entidad entidad = new Aliado(new Soldado(jugador));
		Estado estado = vacio.colocar(entidad);
		assertThrows(CasilleroOcupadoException.class, () -> {
			estado.colocar(entidad);
		});	
	}

	@Test
	public void test03MovemosUnaEntidadDesdeUnCasilleroAUnCasilleroVacioYDevuelveUnEstadoOcupado() {
		Casillero casilleroOrigen = new CasilleroAliado();
		Vacio vacio = new Vacio(casilleroOrigen);
		Entidad entidad = new Aliado(new Soldado(new Jugador()));
		casilleroOrigen.setEntidad(entidad);
		Estado estado = vacio.moverDesde(casilleroOrigen);
		assertThrows(CasilleroOcupadoException.class, () -> {
			estado.colocar(entidad);
		});	
	}
}
