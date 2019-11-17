package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import AlgoChess.engine.entidades.Curandero;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Catapulta;
import static AlgoChess.engine.Constantes.CURANDERO_VIDA;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.posicion.Posicion;

import AlgoChess.excepciones.JugadorPerdioException;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.excepciones.EntidadNoPuedeSerCuradaException;
import AlgoChess.excepciones.CasilleroOcupadoException;

public class CuranderoTest {

	@Test
	public void test00ConstructorCuranderoNoDevuelveNull() {
		Curandero curandero = new Curandero();
		assertNotNull(curandero);
	}

	@Test
	public void test01CreamosUnCuranderoYSuCostoEsElEsperado() {
		Faccion faccion = new Faccion();
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        Jugador jugador = new Jugador(faccion, "Pedro");
		Curandero curandero = new Curandero();
        jugador.comprarEntidad(vendedor, curandero);
        // TODO: Ver como hacer assert para verificar esto
		// assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());
	}

	@Test
	public void test03DisminuimosTodaLaVidaDelCuranderoYMuere() {
		Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador = new Jugador(faccionAliado);
		Curandero curandero = new Curandero(jugador, faccionAliado);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		assertThrows(JugadorPerdioException.class, () -> {
			curandero.disminuirVida(CURANDERO_VIDA, faccionEnemigo, tablero);
		});

	}

	@Test
	public void test04DisminuimosVidaAlCuranderoPasandoMismaFaccionDeAtacanteYArrojaExcepcion() {
		Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador = new Jugador(faccionAliado);
		Curandero curandero = new Curandero(jugador, faccionAliado);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		assertThrows(EntidadDeMismaFaccionException.class, () -> {
			curandero.disminuirVida(CURANDERO_VIDA, faccionAliado, tablero);
		});

	}

	@Test
	public void test05CuramosConUnCuranderoYElAliadoSumaVida() {
		Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador1 = new Jugador(faccionAliado);
		Curandero curandero = new Curandero(jugador1, faccionAliado);
		Jinete jinete = new Jinete(jugador1, faccionAliado);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(1,2);
		tablero.colocarEntidad(jinete, posicionDestino);

		curandero.curar(tablero.obtenerCasillero(posicionDestino), faccionAliado);
		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(Jinete.getVida, JINETE_VIDA + VACULO_PODER);
	}

	@Test
	public void test06CuramosAUnaEntidadDeOtraFaccionConUnCuranderoYNoLoCura() {
		Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador1 = new Jugador(faccionAliado);
		Jugador jugador2 = new Jugador(faccionEnemigo);
		Curandero curandero = new Curandero(jugador1, faccionAliado);
		Jinete jinete = new Jinete(jugador2, faccionEnemigo);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(10,2);
		tablero.colocarEntidad(jinete, posicionDestino);
		
		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(Jinete.getVida, JINETE_VIDA); (i.e: no lo curo pq es enemigo)
	}

	@Test
	public void test07CuranderoCuraACatapultaArrojaExcepcion() {
		Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador1 = new Jugador(faccionAliado);
		Jugador jugador2 = new Jugador(faccionEnemigo);
		Curandero curandero = new Curandero(jugador1, faccionAliado);
		Catapulta catapulta = new Catapulta(jugador2, faccionEnemigo);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(10,1);
		tablero.colocarEntidad(catapulta, posicionDestino);

		assertThrows(EntidadNoPuedeSerCuradaException.class, () -> {
			curandero.curar(tablero.obtenerCasillero(posicionDestino), faccionAliado);
		});
	}

	@Test
	public void test08CuranderoCuraAEntidadAUnaDistanciaDistintaALaCercanaNoCura() {
		Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador1 = new Jugador(faccionAliado);
		Jugador jugador2 = new Jugador(faccionEnemigo);
		Curandero curandero = new Curandero(jugador1, faccionAliado);
		Jinete jinete = new Jinete(jugador2, faccionEnemigo);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(14,1);
		tablero.colocarEntidad(jinete, posicionDestino);

		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(Jinete.getVida, JINETE_VIDA); (i.e: no lo curo pq es la distancia no es cercana)
	}

	@Test
	public void test09MovemosUnCuranderoAUnCasilleroDestinoYSeMueve() {
		Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador1 = new Jugador(faccionAliado);
		Curandero curandero = new Curandero(jugador1, faccionAliado);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(1, 2);
		curandero.moverA(tablero, tablero.obtenerCasillero(posicionDestino), faccionAliado);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(curandero, posicionDestino);
		});	
	}
}
