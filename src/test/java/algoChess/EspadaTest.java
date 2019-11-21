package algoChess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import algoChess.engine.tablero.Tablero;
import algoChess.engine.entidades.armas.Espada;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.jugador.Jugador;
import algoChess.engine.entidades.Jinete;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import static algoChess.engine.Constantes.ESPADA_PODER;
import static algoChess.engine.Constantes.JINETE_VIDA;
import algoChess.excepciones.JugadorPerdioException;
import org.junit.Test;

public class EspadaTest {

	@Test
	public void test00ConstructorEspadaNoDevuelveNull() {
		Espada espada = new Espada();
		assertNotNull(espada);
	}

    @Test 
    public void test01AtacamosConEspadaConRangoCercanoYDañamosAUnaUnidad() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Espada espada = new Espada();

        for(int i = 0; i < (JINETE_VIDA / ESPADA_PODER) - 1; i++) {
            espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        }

        assertThrows(JugadorPerdioException.class, () -> {
            espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });
    }

    @Test 
    public void test02AtacamosConEspadaConRangoMedianoYNoSeProduceElAtaque() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(13, 1);

        tablero.colocarEntidad(jinete, posDestino);
         Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Espada espada = new Espada();

        espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        for(int i = 0; i < (JINETE_VIDA / ESPADA_PODER) - 1; i++) {
            jinete.disminuirVida(ESPADA_PODER, Faccion.ALIADOS, tablero);
        }

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(ESPADA_PODER, Faccion.ALIADOS, tablero);
        });

    }

    @Test 
    public void test03AtacamosConEspadaConRangoLejanoYNoSeProduceElAtaque() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Espada espada = new Espada();

        espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        for(int i = 0; i < (JINETE_VIDA / ESPADA_PODER) - 1; i++) {
            jinete.disminuirVida(ESPADA_PODER, Faccion.ALIADOS, tablero);
        }

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(ESPADA_PODER, Faccion.ALIADOS, tablero);
        });

    }

}