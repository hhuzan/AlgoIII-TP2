package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.entidades.armas.Vaculo;
import AlgoChess.engine.entidades.armas.Arco;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Soldado;
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
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);
        Jugador jugador = new Jugador(faccion_2);

        Jinete jinete = new Jinete(jugador, faccion_2);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();
        Arco arco = new Arco();

        // ARCO_PODER == VACULO_PODER
        arco.atacar(posOrigen, casilleroDestino, faccion_1, tablero);
        vaculo.curar(posOrigen, casilleroDestino, faccion_1);

        //TODOs: Assert que la vida volvio a ser la total del jinete
    }

    @Test 
    public void test02CuramosConVaculoConRangoMedianoYNoSeProduceLaCuracion() {
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);
        Jugador jugador = new Jugador(faccion_2);

        Jinete jinete = new Jinete(jugador, faccion_2);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(13, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();

        vaculo.curar(posOrigen, casilleroDestino, faccion_1);
        // TODO: Ver como hacer assert de :
        // assertEquals(JINETE_VIDA, jinete.getVida());

    }

    @Test 
    public void test03CuramosConVaculoConRangoLejanoYNoSeProduceLaCuracion() {
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);
        Jugador jugador = new Jugador(faccion_2);

        Jinete jinete = new Jinete(jugador, faccion_2);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();

        vaculo.curar(posOrigen, casilleroDestino, faccion_1);
        // TODO: Ver como hacer assert de :
        // assertEquals(JINETE_VIDA, jinete.getVida());

    }
}