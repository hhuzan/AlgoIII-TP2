package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

public class CatapultaTest {

	@Test
	public void test00ConstructorCatapultaNoDevuelveNull() {
		Catapulta catapulta = new Catapulta(new Jugador());
		assertNotNull(catapulta);
	}

	@Test 
	public void test01CreamosUnaCatapultaYSuCostoEsElEsperado() {
		int costoCatapulta = 5;
		Catapulta catapulta = new Catapulta(new Jugador());
		assertEquals(costoCatapulta, catapulta.getCosto());
	}

	@Test 
	public void test02CreamosUnaCatapultaYSuVidaEsLaEsperada() {
		int vidaCatapulta = 50;
		Catapulta catapulta = new Catapulta(new Jugador());
		assertEquals(vidaCatapulta, catapulta.getVida());
	}

	@Test 
	public void test03CreamosUnaCatapultaYRestamosPuntosDeCostoAlJugador() {
		int costoCatapulta = 5;
		int puntosJugadorNuevo = 20;
		Jugador jugador = new Jugador();
		Catapulta catapulta = new Catapulta(jugador);
		catapulta.restarAJugador();
		assertEquals(puntosJugadorNuevo - costoCatapulta, jugador.getPuntos());
	}

	@Test 
	public void test04AtacamosConUnaCatapultaYElEnemigoRecibeDanio() {
		int fila = 9; 
		int columna = 1;
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad catapulta = new Aliado(new Catapulta(jugador1));
		Entidad jinete = new Enemigo(new Jinete(jugador2));
		jugador1.agregar(catapulta);
		jugador2.agregar(jinete);
		tablero.colocar(jinete, fila + 2, columna);
		Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 2, columna);
		catapulta.atacar(casilleroDestino, 2);
		assertTrue(jinete.getVida() == 80);
	}

	@Test 
	public void test05AtacamosConUnaCatapultaYElAliadoRecibeDanio() {
		int fila = 2; 
		int columna = 1;
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad catapulta = new Aliado(new Catapulta(jugador1));
		Entidad jinete = new Aliado(new Jinete(jugador1));
		jugador1.agregar(catapulta);
		jugador2.agregar(jinete);
		tablero.colocar(jinete, fila + 2, columna);
		Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 2, columna);
		catapulta.atacar(casilleroDestino, 2);
		assertTrue(jinete.getVida() == 80);		
	}

	// Test 06: Catapulta no puede moverse
	// Test 07: Catapulta falla al atacar a distancia cercana o media
	// Test 08: Catapulta ataca bloque de casilleros si hay otras entidades
}
