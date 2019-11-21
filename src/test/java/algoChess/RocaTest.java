package algoChess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import algoChess.engine.tablero.Tablero;
import algoChess.engine.entidades.armas.Roca;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.jugador.Jugador;
import algoChess.engine.entidades.Jinete;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import static algoChess.engine.Constantes.ROCA_PODER;
import static algoChess.engine.Constantes.JINETE_VIDA;
import algoChess.excepciones.JugadorPerdioException;
import org.junit.Test;

public class RocaTest {

	@Test
	public void test00ConstructorRocaNoDevuelveNull() {
		Roca roca = new Roca();
		assertNotNull(roca);
	}

	@Test
	public void test01AtacamosConRocaConRangoLejanoYDañamosAUnaUnidad() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ENEMIGOS);

		Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

		Posicion posOrigen = new Posicion(9, 1);
		Posicion posDestino = new Posicion(15, 1);

		tablero.colocarEntidad(jinete, posDestino);
		Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

		Roca roca = new Roca();

		for (int i = 0; i < (JINETE_VIDA / ROCA_PODER) - 1; i++) {
			roca.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
		}

		assertThrows(JugadorPerdioException.class, () -> {
			roca.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
		});
	}

	@Test
	public void test02AtacamosConRocaConRangoCercanoYNoSeProduceElAtaque() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ENEMIGOS);

		Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

		Posicion posOrigen = new Posicion(9, 1);
		Posicion posDestino = new Posicion(10, 1);

		tablero.colocarEntidad(jinete, posDestino);
		Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

		Roca roca = new Roca();

		roca.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
		for (int i = 0; i < (JINETE_VIDA / ROCA_PODER) - 1; i++) {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, tablero);
		}

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, tablero);
		});

	}

	@Test
	public void test03AtacamosConRocaConRangoMedianoYNoSeProduceElAtaque() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ENEMIGOS);

		Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

		Posicion posOrigen = new Posicion(9, 1);
		Posicion posDestino = new Posicion(12, 1);

		tablero.colocarEntidad(jinete, posDestino);
		Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

		Roca roca = new Roca();

		roca.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
		for (int i = 0; i < (JINETE_VIDA / ROCA_PODER) - 1; i++) {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, tablero);
		}

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, tablero);
		});

	}
}