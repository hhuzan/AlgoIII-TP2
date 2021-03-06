package algochess;

import static org.junit.Assert.assertNotNull;
import algochess.engine.tablero.Tablero;
import algochess.engine.entidades.armas.Arco;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import static algochess.engine.ConstantesUtils.ARCO_PODER;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import algochess.excepciones.JugadorPerdioException;
import algochess.excepciones.EntidadFueraDeAlcanceException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArcoTest {

	@Test
	public void test00ConstructorArcoNoDevuelveNull() {
		Arco arco = new Arco();
		assertNotNull(arco);
	}

    @Test 
    public void test01AtacamosConArcoConRangoMedianoYDañamosAUnaUnidad() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(7, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(jinete, posDestino, new Jugador(Faccion.ALIADOS, "Lucas"));
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Arco arco = new Arco();

        for(int i = 0; i < (JINETE_VIDA / ARCO_PODER); i++) {
            arco.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        }

        Assertions.assertThrows(JugadorPerdioException.class, () -> {
            arco.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });
    }

    @Test 
    public void test02AtacamosConArcoConRangoCercanoYSeLanzaUnaExcepcion() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(jinete, posDestino, new Jugador(Faccion.ALIADOS, "Lucas"));
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Arco arco = new Arco();

        
        Assertions.assertThrows(EntidadFueraDeAlcanceException.class, () -> {
            arco.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });        
    }

    @Test 
    public void test03AtacamosConArcoConRangoLejanoYNoSeProduceElAtaque() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino, new Jugador(Faccion.ALIADOS, "Lucas"));
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Arco arco = new Arco();

        Assertions.assertThrows(EntidadFueraDeAlcanceException.class, () -> {
            arco.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });    

    }
}