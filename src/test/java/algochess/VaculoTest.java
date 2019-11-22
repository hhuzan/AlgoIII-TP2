package algochess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import algochess.engine.tablero.Tablero;
import algochess.engine.entidades.armas.Vaculo;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import static algochess.engine.ConstantesUtils.VACULO_PODER;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;

import algochess.excepciones.JugadorPerdioException;
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
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();

        jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
        vaculo.curar(posOrigen, casilleroDestino, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA, Faccion.ALIADOS, casilleroDestino);
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
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();
        
        jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
        vaculo.curar(posOrigen, casilleroDestino, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
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
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Vaculo vaculo = new Vaculo();
        
        jinete.disminuirVida(VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
        vaculo.curar(posOrigen, casilleroDestino, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA - VACULO_PODER, Faccion.ALIADOS, casilleroDestino);
        });

    }
}