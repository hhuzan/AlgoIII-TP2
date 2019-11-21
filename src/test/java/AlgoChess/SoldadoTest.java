package AlgoChess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import static AlgoChess.engine.Constantes.JINETE_VIDA;
import static AlgoChess.engine.Constantes.ESPADA_PODER;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.excepciones.JugadorPerdioException;
import AlgoChess.excepciones.CasilleroOcupadoException;

public class SoldadoTest {

	@Test
	public void test00ConstructorSoldadoNoDevuelveNull() {
		Soldado soldado = new Soldado();
		assertNotNull(soldado);
	}

	@Test 
	public void test01AtacamosConUnSoldadoYLaPiezaEnemigaPierdeVida() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9,1);
        Posicion posDestino = new Posicion(10,1);

        soldado.setFaccion(Faccion.ALIADOS);
        jinete.setFaccion(Faccion.ENEMIGOS);

        tablero.colocarEntidad(soldado, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        soldado.atacar(casilleroDestino, tablero, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida( (JINETE_VIDA - ESPADA_PODER), Faccion.ALIADOS, tablero);
        });
	}

	@Test 
    public void test02SoldadoNoAtacaADistanciaQueNoSeaCercanaUnicamente() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        Soldado soldado = new Soldado(new Jugador(Faccion.ALIADOS), Faccion.ALIADOS);
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(12, 1);

        tablero.colocarEntidad(soldado, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado.atacar(casilleroDestino, tablero, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA, Faccion.ALIADOS, tablero);
        });
    }

    @Test 
    public void test03SoldadoSeMueveACasilleroDestino() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Soldado soldado = new Soldado(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(soldado, posicion);

		Posicion posicionDestino = new Posicion(1, 2);
		soldado.moverA(tablero, tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado, posicionDestino);
		});	
    }
}
