package algochess;

import static org.junit.Assert.assertNotNull;
import algochess.engine.tablero.Tablero;
import algochess.engine.entidades.armas.Daga;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.posicion.Posicion;
import static algochess.engine.ConstantesUtils.DAGA_PODER;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import algochess.excepciones.JugadorPerdioException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DagaTest {

	@Test
	public void test00ConstructorDagaNoDevuelveNull() {
		Daga daga = new Daga();
		assertNotNull(daga);
	}

    @Test 
    public void test01AtacamosConDagaConRangoCercanoYDañamosAUnaUnidad() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Daga daga = new Daga();

        for(int i = 0; i < (JINETE_VIDA / DAGA_PODER) - 1; i++) {
            daga.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        }

        Assertions.assertThrows(JugadorPerdioException.class, () -> {
            daga.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });
    }

    @Test 
    public void test02AtacamosConDagaConRangoMedianoYNoSeProduceElAtaque() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(13, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Daga daga = new Daga();

        daga.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);

        for(int i = 0; i < (JINETE_VIDA / DAGA_PODER) - 1; i++) {
            jinete.disminuirVida(DAGA_PODER, Faccion.ALIADOS, tablero);
        }

        Assertions.assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(DAGA_PODER, Faccion.ALIADOS, tablero);
        });

    }

    @Test 
    public void test03AtacamosConDagaConRangoLejanoYNoSeProduceElAtaque() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);


        Daga daga = new Daga();

        daga.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        for(int i = 0; i < (JINETE_VIDA / DAGA_PODER) - 1; i++) {
            jinete.disminuirVida(DAGA_PODER, Faccion.ALIADOS, tablero);
        }

        Assertions.assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(DAGA_PODER, Faccion.ALIADOS, tablero);
        });

    }

}
