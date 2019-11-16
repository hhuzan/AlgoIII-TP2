package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import AlgoChess.excepciones.CasilleroOcupadoException;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
public class TableroTest {

	@Test
	public void test00ConstructorTableroNoDevuelveNull() {
		Faccion faccion_1 = new Faccion();
		Faccion faccion_2 = new Faccion();
		Tablero tablero = new Tablero(faccion_1, faccion_2);
		assertNotNull(tablero);
	}

	@Test
	public void test01AgregoUnaJineteAlTableroYLeRestoTresPuntosAlJugador() {
		Faccion faccion = new Faccion();
		Tablero tablero = new Tablero(faccion, faccion);
		Jugador jugador = new Jugador(faccion);
		Entidad jinete = new Jinete();

		Posicion posicion = new Posicion(1, 1);
		tablero.colocarEntidad(jinete, posicion);
		// TODO: Ver como hacer assert para verificar esto
		//assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());

	}

	@Test
	public void test02AgregoEntidadDeUnaFaccionEnSeccionDeEsaFaccionYSeColocaEnEsaPosicion() {
		Faccion faccionAliados = new Faccion();
		Faccion faccionEnemigos = new Faccion();
		Tablero tablero = new Tablero(faccionAliados, faccionEnemigos);
		Jugador jugador1 = new Jugador(faccionAliados);
		Entidad soldado1 = new Soldado();
		Entidad soldado2 = new Soldado();

		soldado1.setFaccion(faccionAliados);
		soldado2.setFaccion(faccionAliados);
		Posicion posicion = new Posicion(5, 6);
		tablero.colocarEntidad(soldado1, posicion);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado2, posicion);
		});		
	}


	// @Test
	// public void test03AgregarEntidadDeUnaFaccionEnCasilleroDeOtraTiraExcepcion() {
	// 	Tablero tablero = new Tablero();
	// 	Jugador jugador = new Jugador();
	// 	int fila = 5;
	// 	int columna = 10;
	// 	assertThrows(ColocarEntidadException.class, () -> {
	// 		tablero.colocar(new Enemigo(new Soldado(jugador)), fila, columna);
	// 	});
	// }

// 	@Test
// 	public void test06AgregoAliadoEnSectorEnemigoArrojaExcepcion() {
// 		Tablero tablero = new Tablero();
// 		Jugador jugador = new Jugador();
// 		int fila = 15;
// 		int columna = 10;
// 		assertThrows(ColocarEntidadException.class, () -> {
// 			tablero.colocar(new Aliado(new Soldado(jugador)), fila, columna);
// 		});
// 	}

// 	@Test
// 	public void test08MovemosHaciaArribaYLaEntidadSeColocaEnLaPosicionDestino() {
// 		Tablero tablero = new Tablero();
// 		Jugador jugador = new Jugador();
// 		Entidad entidad = new Aliado(new Soldado(jugador));
// 		int filaOrigen = 5;
// 		int columnaOrigen = 10;
// 		tablero.colocar(entidad, filaOrigen, columnaOrigen);
// 		tablero.moverArriba(filaOrigen, columnaOrigen);
// 		assertThrows(CasilleroOcupadoException.class, () -> {
// 			tablero.colocar(entidad, filaOrigen - 1, columnaOrigen);
// 		});	
// 	}

// 	@Test 
// 	public void test09MovemosHaciaArribaYElCasilleroOrigenQuedaLibre() {
// 		Tablero tablero = new Tablero();
// 		Jugador jugador = new Jugador();
// 		Entidad entidad = new Aliado(new Soldado(jugador));
// 		int filaOrigen = 5;
// 		int columnaOrigen = 10;
// 		tablero.colocar(entidad, filaOrigen, columnaOrigen);
// 		tablero.moverArriba(filaOrigen, columnaOrigen);
// 		assertThrows(CasilleroVacioException.class, () -> {
// 			tablero.atacar(filaOrigen, columnaOrigen, filaOrigen + 1, columnaOrigen);
// 		});			
// 	}

// 	// @Test
// 	// public void test09MoverAbajo() {
// 	// 	Tablero tablero = new Tablero();
// 	// 	Jugador jugador = new Jugador();
// 	// 	int filaOrigen = 5;
// 	// 	int columnaOrigen = 10;
// 	// 	tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
// 	// 	tablero.moverAbajo(filaOrigen, columnaOrigen);
// 	// 	assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
// 	// 	assertFalse(tablero.estaVacio(filaOrigen + 1, columnaOrigen));
// 	// }

// 	// @Test
// 	// public void test10MoverIzquierda() {
// 	// 	Tablero tablero = new Tablero();
// 	// 	Jugador jugador = new Jugador();
// 	// 	int filaOrigen = 5;
// 	// 	int columnaOrigen = 10;
// 	// 	tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
// 	// 	tablero.moverIzquierda(filaOrigen, columnaOrigen);
// 	// 	assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
// 	// 	assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen - 1));
// 	// }

// 	// @Test
// 	// public void test11MoverDerecha() {
// 	// 	Tablero tablero = new Tablero();
// 	// 	Jugador jugador = new Jugador();
// 	// 	int filaOrigen = 5;
// 	// 	int columnaOrigen = 10;
// 	// 	tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
// 	// 	tablero.moverDerecha(filaOrigen, columnaOrigen);
// 	// 	assertTrue(tablero.estaVacio(filaOrigen, columnaOrigen));
// 	// 	assertFalse(tablero.estaVacio(filaOrigen, columnaOrigen + 1));
// 	// }

// 	@Test
// 	public void test12MoverEntidadACasilleroOcupadoArrojaExcepcion() {
// 		Tablero tablero = new Tablero();
// 		Jugador jugador = new Jugador();
// 		int filaOrigen = 1;
// 		int columnaOrigen = 1;
// 		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
// 		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen + 1);
// 		assertThrows(CasilleroOcupadoException.class, () -> {
// 			tablero.moverDerecha(filaOrigen, columnaOrigen);
// 		});
// 	}

// 	@Test
// 	public void test13MoverEntidadACasilleroOcupadoCasilleroOrigenQuedaOcupado() {
// 		Tablero tablero = new Tablero();
// 		Jugador jugador = new Jugador();
// 		int filaOrigen = 2;
// 		int columnaOrigen = 2;
// 		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen, columnaOrigen);
// 		tablero.colocar(new Aliado(new Soldado(jugador)), filaOrigen - 1, columnaOrigen);
// 		assertThrows(CasilleroOcupadoException.class, () -> {
// 			tablero.moverArriba(filaOrigen, columnaOrigen);
// 		});
// 	}

// 	@Test
// 	public void test14SoldadoAliadoAtacaPiezaEnemigaYRestaAlJugadorDePiezaEnemiga() {
// 		int fila = 9;
// 		int columna = 1;
// 		Tablero tablero = new Tablero();
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
// 		Entidad soldado1 = new Aliado(new Soldado(jugador1));
// 		Entidad soldado2 = new Enemigo(new Soldado(jugador2));
// 		jugador1.agregar(soldado1);
// 		jugador2.agregar(soldado2);
// 		tablero.colocar(soldado1, fila, columna);
// 		tablero.colocar(soldado2, fila + 1, columna);
// 		tablero.atacar(fila, columna, fila + 1, columna);
// 		assertTrue(soldado2.getVida() == 90);
// 	}

// 	@Test
// 	public void test15JineteAliadoAtacaPiezaEnemigaYRestaAlJugadorDePiezaEnemiga() {
// 		int fila = 9; // TODO: Ojo, falta implementar que colocar falle si agregamos a tablero
// 						// enemigo/aliado
// 		int columna = 1;
// 		Tablero tablero = new Tablero();
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
// 		Entidad jinete1 = new Aliado(new Jinete(jugador1));
// 		Entidad jinete2 = new Enemigo(new Jinete(jugador2));
// 		jugador1.agregar(jinete1);
// 		jugador2.agregar(jinete2);
// 		tablero.colocar(jinete1, fila, columna);
// 		tablero.colocar(jinete2, fila + 1, columna);
// 		tablero.atacar(fila, columna, fila + 1, columna);
// 		assertTrue(jinete2.getVida() == 95);
// 	}

// 	@Test
// 	public void test16CatapultaAliadoAtacaPiezaEnemigaYRestaAlJugadorDePiezaEnemiga() {
// 		int fila = 9; 
// 		int columna = 1;
// 		Tablero tablero = new Tablero();
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
// 		Entidad catapulta = new Aliado(new Catapulta(jugador1));
// 		Entidad jinete = new Enemigo(new Jinete(jugador2));
// 		jugador1.agregar(catapulta);
// 		jugador2.agregar(jinete);
// 		tablero.colocar(catapulta, fila, columna);
// 		tablero.colocar(jinete, fila + 7, columna);
// 		tablero.atacar(fila, columna, fila + 7, columna);
// 		assertTrue(jinete.getVida() == 80);
// 	}

// 	@Test
// 	public void test17CuranderoAliadoCuraPiezaAliadaYSumaVidaADichaPieza() {
// 		int fila = 7; // TODO: Ojo, falta implementar que colocar falle si agregamos a tablero
// 						// enemigo/aliado
// 		int columna = 1;
// 		Tablero tablero = new Tablero();
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
// 		Entidad curandero = new Aliado(new Curandero(jugador1));
// 		Entidad jinete = new Aliado(new Jinete(jugador2));
// 		jugador1.agregar(curandero);
// 		jugador2.agregar(jinete);
// 		tablero.colocar(curandero, fila, columna);
// 		tablero.colocar(jinete, fila + 1, columna);
// 		tablero.curar(fila, columna, fila + 1, columna);
// 		assertTrue(jinete.getVida() == 115);
// 	}

// 	@Test
// 	public void test18UnJugadorSeQuedaSinEntidadesYPierde() {
// 		int fila = 9; // TODO: Ojo, falta implementar que colocar falle si agregamos a tablero
// 						// enemigo/aliado
// 		int columna = 1;
// 		Tablero tablero = new Tablero();
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador();
// 		Entidad jinete1 = new Aliado(new Jinete(jugador1));
// 		Entidad jinete2 = new Enemigo(new Jinete(jugador2));
// 		jugador1.agregar(jinete1);
// 		jugador2.agregar(jinete2);
// 		tablero.colocar(jinete1, fila, columna);
// 		tablero.colocar(jinete2, fila + 1, columna);
// 		for (int i = 0; i < 19; i++) {
// 			tablero.atacar(fila, columna, fila + 1, columna);
// 		}
// 		assertThrows(JugadorPierdeException.class, () -> {
// 			tablero.atacar(fila, columna, fila + 1, columna);
// 		});
// 	}

// 	@Test 
// 	public void test193SoldadosContiguosSeMuevenEnLaMismaDireccion() {
// 		int fila = 9;
// 		int columna = 1;
// 		Tablero tablero = new Tablero();
// 		Jugador jugador1 = new Jugador();
// 		Entidad soldado1 = new Aliado(new Soldado(jugador1));
// 		Entidad soldado2 = new Aliado(new Soldado(jugador1));
// 		Entidad soldado3 = new Aliado(new Soldado(jugador1));
// 		tablero.colocar(soldado1, fila, columna);
// 		tablero.colocar(soldado1, fila, columna + 1);
// 		tablero.colocar(soldado1, fila, columna + 2);
// 		// En realidad tiene que ser mover y darse cuenta solo que tiene un batallon
// 		tablero.moverBatallonDerecha(fila, columna, fila, columna + 1, fila, columna + 2);

// 	}
}