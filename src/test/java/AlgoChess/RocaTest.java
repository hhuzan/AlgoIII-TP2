package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.entidades.armas.Roca;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import static AlgoChess.engine.Constantes.ROCA_PODER;
import static AlgoChess.engine.Constantes.JINETE_VIDA;

import AlgoChess.excepciones.JugadorPerdioException;
import org.junit.Test;

public class RocaTest {

	@Test
	public void test00ConstructorRocaNoDevuelveNull() {
		Roca roca = new Roca();
		assertNotNull(roca);
	}

    @Test 
    public void test01AtacamosConRocaConRangoLejanoYDañamosAUnaUnidad() {
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


        Roca roca = new Roca();

        for(int i = 0; i < (JINETE_VIDA / ROCA_PODER) - 1; i++) {
            roca.atacar(posOrigen, casilleroDestino, faccion_1, tablero);
        }

        assertThrows(JugadorPerdioException.class, () -> {
            roca.atacar(posOrigen, casilleroDestino, faccion_1, tablero);
        });
    }

    @Test 
    public void test02AtacamosConRocaConRangoCercanoYNoSeProduceElAtaque() {
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);
        Jugador jugador = new Jugador(faccion_2);

        Jinete jinete = new Jinete(jugador, faccion_2);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Roca roca = new Roca();

        roca.atacar(posOrigen, casilleroDestino, faccion_1, tablero);
        // TODO: Ver como hacer assert de :
        // assertEquals(JINETE_VIDA, jinete.getVida());

    }

    @Test 
    public void test03AtacamosConRocaConRangoMedianoYNoSeProduceElAtaque() {
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);
        Jugador jugador = new Jugador(faccion_2);

        Jinete jinete = new Jinete(jugador, faccion_2);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(12, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Roca roca = new Roca();

        roca.atacar(posOrigen, casilleroDestino, faccion_1, tablero);
        // TODO: Ver como hacer assert de :
        // assertEquals(JINETE_VIDA, jinete.getVida());

    }
}