package algochess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import algochess.engine.juego.Turno;
import org.junit.Test;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import static algochess.engine.ConstantesUtils.ESPADA_PODER;
import algochess.engine.tablero.Tablero;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.excepciones.JugadorPerdioException;
import algochess.excepciones.CasilleroOcupadoException;

public class SoldadoTest {

	@Test
	public void test00ConstructorSoldadoNoDevuelveNull() {
		Soldado soldado = new Soldado();
		assertNotNull(soldado);
	}

	@Test 
	public void test01AtacamosConUnSoldadoYLaPiezaEnemigaPierdeVida() {
        Tablero tablero = new Tablero();

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9,1);
        Posicion posDestino = new Posicion(10,1);

        soldado.setFaccion(Faccion.ALIADOS);
        jinete.setFaccion(Faccion.ENEMIGOS);

        tablero.colocarEntidad(soldado, posOrigen, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(jinete, posDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);
        soldado.atacar(casilleroDestino, tablero, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida( (JINETE_VIDA - ESPADA_PODER), Faccion.ALIADOS, casilleroDestino);
        });
	}

	@Test 
    public void test02SoldadoNoAtacaADistanciaQueNoSeaCercanaUnicamente() {
        Tablero tablero = new Tablero();

        Soldado soldado = new Soldado(new Jugador(Faccion.ALIADOS), Faccion.ALIADOS);
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(12, 1);

        tablero.colocarEntidad(soldado, posOrigen, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(jinete, posDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado.atacar(casilleroDestino, tablero, Faccion.ALIADOS);

        assertThrows(JugadorPerdioException.class, () -> {
            jinete.disminuirVida(JINETE_VIDA, Faccion.ALIADOS, casilleroDestino);
        });
    }

    @Test 
    public void test03SoldadoSeMueveACasilleroDestino() {
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Soldado soldado = new Soldado(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(soldado, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionDestino = new Posicion(1, 2);
		soldado.moverA(tablero, tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado, posicionDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		});	
    }
}
