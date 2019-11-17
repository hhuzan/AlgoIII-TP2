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
import AlgoChess.excepciones.CasilleroOcupadoException;

public class CuranderoTest {

	@Test
	public void test00ConstructorCuranderoNoDevuelveNull() {
		Curandero curandero = new Curandero();
		assertNotNull(curandero);
	}

	@Test
	public void test01CreamosUnCuranderoYSuCostoEsElEsperado() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        Jugador jugador = new Jugador(Faccion.ALIADOS, "Pedro");
		Curandero curandero = new Curandero();
        jugador.comprarEntidad(vendedor, curandero);
        // TODO: Ver como hacer assert para verificar esto
		// assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());
	}

	@Test
	public void test03DisminuimosTodaLaVidaDelCuranderoYMuere() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		assertThrows(JugadorPerdioException.class, () -> {
			curandero.disminuirVida(CURANDERO_VIDA, Faccion.ENEMIGOS, tablero);
		});

	}

	@Test
	public void test04DisminuimosVidaAlCuranderoPasandoMismaFaccionDeAtacanteYArrojaExcepcion() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		assertThrows(EntidadDeMismaFaccionException.class, () -> {
			curandero.disminuirVida(CURANDERO_VIDA, Faccion.ALIADOS, tablero);
		});

	}

	@Test
	public void test05CuramosConUnCuranderoYElAliadoSumaVida() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(1,2);
		tablero.colocarEntidad(jinete, posicionDestino);

		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);
		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(Jinete.getVida, JINETE_VIDA + VACULO_PODER);
	}

	@Test
	public void test06CuramosAUnaEntidadDeOtraFaccionConUnCuranderoYNoLoCura() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(10,2);
		tablero.colocarEntidad(jinete, posicionDestino);
		
		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(Jinete.getVida, JINETE_VIDA); (i.e: no lo curo pq es enemigo)
	}

	@Test
	public void test07CuranderoCuraACatapultaYNoCuraVida() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Catapulta catapulta = new Catapulta(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(10,1);
		tablero.colocarEntidad(catapulta, posicionDestino);

		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(Catapulta.getVida, CATAPULTA_VIDA); (i.e: no lo curo pq es enemigo)
	}

	@Test
	public void test08CuranderoCuraAEntidadAUnaDistanciaDistintaALaCercanaNoCura() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(14,1);
		tablero.colocarEntidad(jinete, posicionDestino);

		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(Jinete.getVida, JINETE_VIDA); (i.e: no lo curo pq es la distancia no es cercana)
	}

	@Test
	public void test09MovemosUnCuranderoAUnCasilleroDestinoYSeMueve() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(1, 2);
		curandero.moverA(tablero, tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(curandero, posicionDestino);
		});	
	}
}
