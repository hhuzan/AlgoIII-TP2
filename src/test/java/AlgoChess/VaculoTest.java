package AlgoChess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.entidades.armas.Vaculo;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import static AlgoChess.engine.Constantes.VACULO_PODER;
import static AlgoChess.engine.Constantes.JINETE_VIDA;

import AlgoChess.excepciones.JugadorPerdioException;
import org.junit.Test;

public class VaculoTest {

	@Test
	public void test00ConstructorVaculoNoDevuelveNull() {
		Vaculo vaculo = new Vaculo();
		assertNotNull(vaculo);
	}

    @Test 
    public void test01AtacamosConVaculoConRangoCercanoYCuramosAUnaUnidad() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();

        jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, tablero);
        vaculo.curar(posOrigen, casilleroDestino, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA, Faccion.ALIADOS, tablero);
        });
    }

    @Test 
    public void test02CuramosConVaculoConRangoMedianoYNoSeProduceLaCuracion() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(13, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();
        
        jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, tablero);
        vaculo.curar(posOrigen, casilleroDestino, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, tablero);
        });

    }

    @Test 
    public void test03CuramosConVaculoConRangoLejanoYNoSeProduceLaCuracion() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();
        
        jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, tablero);
        vaculo.curar(posOrigen, casilleroDestino, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, tablero);
        });

    }
}