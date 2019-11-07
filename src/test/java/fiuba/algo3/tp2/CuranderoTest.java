package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import fiuba.algo3.tp2.Excepciones.TipoNoPuedeSerCuradoException;

public class CuranderoTest {

	@Test
	public void test00ConstructorCuranderoNoDevuelveNull() {
		Curandero curandero = new Curandero(new Jugador());
		assertNotNull(curandero);
	}

	@Test 
	public void test01CreamosUnCuranderoYSuCostoEsElEsperado() {
		int costoCurandero = 2;
		Curandero curandero = new Curandero(new Jugador());
		assertEquals(costoCurandero, curandero.getCosto());
	}

	@Test 
	public void test02CreamosUnCuranderoYSuVidaEsLaEsperada() {
		int vidaCurandero = 75;
		Curandero curandero = new Curandero(new Jugador());
		assertEquals(vidaCurandero, curandero.getVida());
	}

	@Test 
	public void test03CreamosUnCuranderoYRestamosPuntosDeCostoAlJugador() {
		int costoCurandero = 2;
		int puntosJugadorNuevo = 20;
		Jugador jugador = new Jugador();
		Curandero curandero = new Curandero(jugador);
		curandero.restarAJugador();
		assertEquals(puntosJugadorNuevo - costoCurandero, jugador.getPuntos());
	}

	@Test 
	public void test04CuramosConUnCuranderoYElAliadoSumaVida() {
		int fila = 1; 
		int columna = 1;
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad curandero = new Aliado(new Curandero(jugador1));
		Entidad jinete = new Aliado(new Jinete(jugador2));
		jugador1.agregar(curandero);
		jugador2.agregar(jinete);
		tablero.colocar(jinete, fila + 1, columna);
		Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 1, columna);
		curandero.curar(casilleroDestino, 1);
		assertTrue(jinete.getVida() == 115);
	}

	@Test 
	public void test05CuranderCuraACatapultaArrojaExcepcion() {
		int fila = 1; 
		int columna = 1;
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad curandero = new Aliado(new Curandero(jugador1));
		Entidad catapulta = new Aliado(new Catapulta(jugador2));
		jugador1.agregar(curandero);
		jugador2.agregar(catapulta);
		tablero.colocar(catapulta, fila + 1, columna);
		Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 1, columna);
		assertThrows(TipoNoPuedeSerCuradoException.class, () -> {
			curandero.curar(casilleroDestino, 1);
		});	
	}

	// Test 06: Falla al curar de distancia media o lejana
}
