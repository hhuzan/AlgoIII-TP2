// package AlgoChess;

// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import org.junit.Test;

// import AlgoChess.excepciones.CasilleroOcupadoException;

// public class OcupadoTest {

// 	@Test
// 	public void test00ConstructorVacioNoDevuelveNull() {
// 		Vacio vacio = new Vacio(casillero);
// 		assertNotNull(vacio);
// 	}

// 	@Test
// 	public void test01ColocamosUnaEntidadEnUnEstadoOcupadoYArrojaUnaExcepcion() {
// 		Ocupado ocupado = new Ocupado(casillero);
// 		Jugador jugador = new Jugador();
// 		Entidad entidad = new Soldado(jugador);
// 		assertThrows(CasilleroOcupadoException.class, () -> {
// 			ocupado.colocar(entidad);
// 		});
// 	}

// 	@Test
// 	public void test02MovemosUnaEntidadDesdeUnCasilleroAUnCasilleroOcupadoYArrojaExcepcion() {
// 		Casillero casilleroOrigen = new CasilleroAliado();
// 		Casillero casilleroDestino = new CasilleroAliado();
// 		Ocupado ocupado = new Ocupado(casilleroDestino);
// 		Entidad entidad = new Aliado(new Soldado(new Jugador()));
// 		casilleroOrigen.setEntidad(entidad);
// 		assertThrows(CasilleroOcupadoException.class, () -> {
// 			ocupado.moverDesde(casilleroOrigen);
// 		});
// 	}
// }
