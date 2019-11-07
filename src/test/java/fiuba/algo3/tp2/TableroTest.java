package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TableroTest {

	@Test
	public void test00ConstructorTableroNoDevuelveNull() {
		Tablero tablero = new Tablero();
		assertNotNull(tablero);
	}

	@Test
	public void test01AgregoUnaJineteAlTableroYLeRestoTresPuntosAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		Entidad jinete = new Aliado(new Jinete(jugador));

		tablero.colocar(jinete, 1, 1);
		assertEquals(17, jugador.getPuntos());
	}

	@Test
	public void test02AgregoDosJinetesAlTableroYLeRestoSeisPuntosAlJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();

		tablero.colocar(new Aliado(new Jinete(jugador)), 1, 1);
		tablero.colocar(new Aliado(new Jinete(jugador)), 1, 2);
		assertEquals(14, jugador.getPuntos());
	}

	@Test
	public void test10AgregoAliadoEnSectorAliadoPosionNoQuedaVacia() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 5;
		int columna = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		assertFalse(tablero.estaVacio(fila, columna));
	}

	@Test
	public void test11AgregoEnemigoEnSectorEnemigoPosionNoQuedaVacia() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 15;
		int columna = 10;
		tablero.colocar(new Enemigo(new Soldado(jugador)), fila, columna);
		assertFalse(tablero.estaVacio(fila, columna));
	}

	@Test
	public void test12AgregoEnemigoEnSectorAliadoArrojaExcepcion() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 5;
		int columna = 10;
		assertThrows(ColocarEntidadException.class, () -> {
			tablero.colocar(new Enemigo(new Soldado(jugador)), fila, columna);
		});
	}

	@Test
	public void test13AgregoAliadoEnSectorEnemigoArrojaExcepcion() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 15;
		int columna = 10;
		assertThrows(ColocarEntidadException.class, () -> {
			tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		});
	}

	@Test
	public void test20Agrego2AliadosEnMismoCasilleroAliadoArrojaExcepcion() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int fila = 5;
		int columna = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
		});

	}

	@Test
	public void test30MoverArribar() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.moverArriba(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen - 1, columnaOrigen));
	}

	@Test
	public void test31MoverAbajo() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.moverAbajo(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen + 1, columnaOrigen));
	}

	@Test
	public void test32MoverIzquierda() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.moverIzquierda(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen - 1));
	}

	@Test
	public void test33MoverDerecha() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 5;
		int columnaOrigen = 10;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.moverDerecha(filaOrigen, columnaOrigen);
		assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen + 1));
	}

	@Test
	public void test34MoverEntidadACasilleroOcupadoArrojaExcepcion() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 1;
		int columnaOrigen = 1;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen + 1);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.moverDerecha(filaOrigen, columnaOrigen);
		});
	}

	@Test
	public void test39MoverEntidadACasilleroOcupadoCasilleroOrigenQuedaOcupado() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador();
		int filaOrigen = 2;
		int columnaOrigen = 2;
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen - 1, columnaOrigen);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.moverArriba(filaOrigen, columnaOrigen);
		});
		assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen));
	}

	@Test
	public void test35SoldadoAliadoAtacaPiezaEnemigaYRestaAlJugadorDePiezaEnemiga() {
		int fila = 9;
		int columna = 1;	
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad soldado1 = new Aliado(new Soldado(jugador1));
		Entidad soldado2 = new Enemigo(new Soldado(jugador2));
		jugador1.agregar(soldado1);
		jugador2.agregar(soldado2);
		tablero.colocar(soldado1, fila, columna);
		tablero.colocar(soldado2, fila + 1, columna);
		Casillero casilleroOrigen = tablero.obtenerCasilleroPorPosicion(fila, columna);
		Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 1, columna);
		tablero.atacar(casilleroOrigen, casilleroDestino);
		assertTrue(soldado2.getVida() == 90);
	}

	@Test
	public void test36JineteAliadoAtacaPiezaEnemigaYRestaAlJugadorDePiezaEnemiga() {
		int fila = 9; // TODO: Ojo, falta implementar que colocar falle si agregamos a tablero enemigo/aliado
		int columna = 1;
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad jinete1 = new Aliado(new Jinete(jugador1));
		Entidad jinete2 = new Enemigo(new Jinete(jugador2));
		jugador1.agregar(jinete1);
		jugador2.agregar(jinete2);
		tablero.colocar(jinete1, fila, columna);
		tablero.colocar(jinete2, fila + 1, columna);
		Casillero casilleroOrigen = tablero.obtenerCasilleroPorPosicion(fila, columna);
		Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 1, columna);
		tablero.atacar(casilleroOrigen, casilleroDestino);
		assertTrue(jinete2.getVida() == 95);
	}

	@Test
	public void test37CatapultaAliadoAtacaPiezaEnemigaYRestaAlJugadorDePiezaEnemiga() {
		int fila = 9; // TODO: Ojo, falta implementar que colocar falle si agregamos a tablero enemigo/aliado
		int columna = 1;
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad catapulta = new Aliado(new Catapulta(jugador1));
		Entidad jinete = new Enemigo(new Jinete(jugador2));
		jugador1.agregar(catapulta);
		jugador2.agregar(jinete);
		tablero.colocar(catapulta, fila, columna);
		tablero.colocar(jinete, fila + 2, columna);
		Casillero casilleroOrigen = tablero.obtenerCasilleroPorPosicion(fila, columna);
		Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 2, columna);
		tablero.atacar(casilleroOrigen, casilleroDestino);
		assertTrue(jinete.getVida() == 80);
	}

	 @Test
	 public void test38UnJugadorSeQuedaSinEntidadesYPierde(){
	 	int fila = 9; // TODO: Ojo, falta implementar que colocar falle si agregamos a tablero enemigo/aliado
	 	int columna = 1;
	 	Tablero tablero = new Tablero();
	 	Jugador jugador1 = new Jugador();
	 	Jugador jugador2 = new Jugador();
	 	Entidad jinete1 = new Aliado(new Jinete(jugador1));
	 	Entidad jinete2 = new Enemigo(new Jinete(jugador2));
	 	jugador1.agregar(jinete1);
	 	jugador2.agregar(jinete2);
	 	tablero.colocar(jinete1, fila, columna);
	 	tablero.colocar(jinete2, fila + 1, columna);
	 	Casillero casilleroOrigen = tablero.obtenerCasilleroPorPosicion(fila, columna);
	 	Casillero casilleroDestino = tablero.obtenerCasilleroPorPosicion(fila + 1, columna);
	 	for(int i = 0; i < 19; i++) {
	 		tablero.atacar(casilleroOrigen, casilleroDestino);
	 	}
	 	assertThrows(JugadorPierdeException.class, () -> {
	 		tablero.atacar(casilleroOrigen, casilleroDestino);
	 	});
	 }
}
