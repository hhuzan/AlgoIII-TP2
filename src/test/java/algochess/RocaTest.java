package algochess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import algochess.engine.juego.Turno;
import algochess.engine.tablero.Tablero;
import algochess.engine.entidades.armas.Roca;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import static algochess.engine.ConstantesUtils.ROCA_PODER;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import algochess.excepciones.JugadorPerdioException;
import org.junit.Test;

public class RocaTest {

	@Test
	public void test00ConstructorRocaNoDevuelveNull() {
		Roca roca = new Roca();
		assertNotNull(roca);
	}

	@Test
	public void test01AtacamosConRocaConRangoLejanoYDañamosAUnaUnidad() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ENEMIGOS);

		Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

		Posicion posOrigen = new Posicion(9, 1);
		Posicion posDestino = new Posicion(15, 1);

		tablero.colocarEntidad(jinete, posDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

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
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ENEMIGOS);

		Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

		Posicion posOrigen = new Posicion(9, 1);
		Posicion posDestino = new Posicion(10, 1);

		tablero.colocarEntidad(jinete, posDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

		Roca roca = new Roca();

		roca.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
		for (int i = 0; i < (JINETE_VIDA / ROCA_PODER) - 1; i++) {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, casilleroDestino);
		}

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, casilleroDestino);
		});

	}

	@Test
	public void test03AtacamosConRocaConRangoMedianoYNoSeProduceElAtaque() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ENEMIGOS);

		Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

		Posicion posOrigen = new Posicion(9, 1);
		Posicion posDestino = new Posicion(12, 1);

		tablero.colocarEntidad(jinete, posDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

		Roca roca = new Roca();

		roca.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
		for (int i = 0; i < (JINETE_VIDA / ROCA_PODER) - 1; i++) {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, casilleroDestino);
		}

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(ROCA_PODER, Faccion.ALIADOS, casilleroDestino);
		});

	}
}