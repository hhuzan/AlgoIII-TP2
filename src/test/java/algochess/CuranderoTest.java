package algochess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import algochess.engine.juego.Turno;
import org.junit.Test;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Catapulta;
import static algochess.engine.ConstantesUtils.CURANDERO_VIDA;
import static algochess.engine.ConstantesUtils.VACULO_PODER;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import static algochess.engine.ConstantesUtils.CATAPULTA_VIDA;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.excepciones.JugadorPerdioException;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.excepciones.CasilleroOcupadoException;

public class CuranderoTest {

	@Test
	public void test00ConstructorCuranderoNoDevuelveNull() {
		Curandero curandero = new Curandero();
		assertNotNull(curandero);
	}

	@Test
	public void test01DisminuimosTodaLaVidaDelCuranderoYMuere() {
        Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

		Casillero casilleroDestino = tablero.obtenerCasillero(posicion);
		assertThrows(JugadorPerdioException.class, () -> {
			curandero.disminuirVida(CURANDERO_VIDA, Faccion.ENEMIGOS, casilleroDestino);
		});

	}

	@Test
	public void test02DisminuimosVidaAlCuranderoPasandoMismaFaccionDeAtacanteYArrojaExcepcion() {
        Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicion);

		assertThrows(EntidadDeMismaFaccionException.class, () -> {
			curandero.disminuirVida(CURANDERO_VIDA, Faccion.ALIADOS, casilleroDestino);
		});

	}

	@Test
	public void test03CuramosConUnCuranderoYElAliadoSumaVida() {
        Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionDestino = new Posicion(1,2);
		tablero.colocarEntidad(jinete, posicionDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicionDestino);
		
		jinete.disminuirVida(VACULO_PODER, Faccion.ENEMIGOS, casilleroDestino);
		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);
           

        jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ENEMIGOS, casilleroDestino);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(VACULO_PODER, Faccion.ENEMIGOS, casilleroDestino);
        });

	}

	@Test
	public void test04CuramosAUnaEntidadDeOtraFaccionConUnCuranderoYNoLoCura() {
        Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionDestino = new Posicion(10,2);
		tablero.colocarEntidad(jinete, posicionDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicionDestino);

		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);
		jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, casilleroDestino);

		assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
        });
	}

	@Test
	public void test05CuranderoCuraACatapultaYNoCuraVida() {
        Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Catapulta catapulta = new Catapulta(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionDestino = new Posicion(10,1);
		tablero.colocarEntidad(catapulta, posicionDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicionDestino);
		
		catapulta.disminuirVida(VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(JugadorPerdioException.class, () -> {
            catapulta.disminuirVida(CATAPULTA_VIDA - VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
        });
	}

	@Test
	public void test06CuranderoCuraAEntidadAUnaDistanciaDistintaALaCercanaNoCura() {
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9,1);
		tablero.colocarEntidad(curandero, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionDestino = new Posicion(14,1);
		tablero.colocarEntidad(jinete, posicionDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicionDestino);

		jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
		curandero.curar(tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
        });
	}

	@Test
	public void test07MovemosUnCuranderoAUnCasilleroDestinoYSeMueve() {
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Curandero curandero = new Curandero(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(curandero, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionDestino = new Posicion(1, 2);
		curandero.moverA(tablero, tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(curandero, posicionDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		});	
	}
}
