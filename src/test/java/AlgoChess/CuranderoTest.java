package AlgoChess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import AlgoChess.engine.entidades.Curandero;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Catapulta;
import static AlgoChess.engine.Constantes.CURANDERO_VIDA;
import static AlgoChess.engine.Constantes.VACULO_PODER;
import static AlgoChess.engine.Constantes.JINETE_VIDA;
import static AlgoChess.engine.Constantes.CATAPULTA_VIDA;
import AlgoChess.engine.facciones.Faccion;
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
	public void test01DisminuimosTodaLaVidaDelCuranderoYMuere() {
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
	public void test02DisminuimosVidaAlCuranderoPasandoMismaFaccionDeAtacanteYArrojaExcepcion() {
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
	public void test03CuramosConUnCuranderoYElAliadoSumaVida() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(1,2);
		tablero.colocarEntidad(jinete, posicionDestino);
		
		jinete.disminuirVida(VACULO_PODER, Faccion.ENEMIGOS, tablero);
		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);
           

        jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ENEMIGOS, tablero);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(VACULO_PODER, Faccion.ENEMIGOS, tablero);
        });

	}

	@Test
	public void test04CuramosAUnaEntidadDeOtraFaccionConUnCuranderoYNoLoCura() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(10,2);
		tablero.colocarEntidad(jinete, posicionDestino);

		jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, tablero);
		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, tablero);
        });
	}

	@Test
	public void test05CuranderoCuraACatapultaYNoCuraVida() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Catapulta catapulta = new Catapulta(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(10,1);
		tablero.colocarEntidad(catapulta, posicionDestino);
		
		catapulta.disminuirVida(VACULO_PODER, Faccion.ALIADOS, tablero);
		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(JugadorPerdioException.class, () -> {
            catapulta.disminuirVida(CATAPULTA_VIDA - VACULO_PODER, Faccion.ALIADOS, tablero);
        });
	}

	@Test
	public void test06CuranderoCuraAEntidadAUnaDistanciaDistintaALaCercanaNoCura() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion);

		Posicion posicionDestino = new Posicion(14,1);
		tablero.colocarEntidad(jinete, posicionDestino);

		jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, tablero);
		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, tablero);
        });
	}

	@Test
	public void test07MovemosUnCuranderoAUnCasilleroDestinoYSeMueve() {
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
