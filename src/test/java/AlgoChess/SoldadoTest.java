package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.entidades.Catapulta;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;

import AlgoChess.excepciones.CasilleroOcupadoException;

public class SoldadoTest {

	@Test
	public void test00ConstructorSoldadoNoDevuelveNull() {
		Soldado soldado = new Soldado();
		assertNotNull(soldado);
	}

	@Test 
	public void test01CreamosUnSoldadoYSuVidaEsLaEsperada() {
		Faccion faccion = new Faccion();
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        Jugador jugador = new Jugador(faccion, "Pedro");
		Catapulta catapulta = new Catapulta();
        jugador.comprarEntidad(vendedor, catapulta);
        // TODO: Ver como hacer assert para verificar esto
        // assertEquals(DINERO_JUGADOR - SOLDADO_COSTO, jugador.getDinero());
	}

	@Test 
	public void test04AtacamosConUnSoldadoYLaPiezaEnemigaPierdeVida() {
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        Posicion posOrigen = new Posicion(9,1);
        Posicion posDestino = new Posicion(10,1);

        soldado.setFaccion(faccion_1);
        jinete.setFaccion(faccion_2);

        tablero.colocarEntidad(soldado, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        soldado.atacar(casilleroDestino, tablero, faccion_1);
        // TODO: Ver como hacer assert para verificar esto
		//assertEquals(jinete.getVida(), JINETE_VIDA - ESPADA_PODER);
	}

	@Test 
    public void test05SoldadoNoAtacaADistanciaQueNoSeaCercanaUnicamente() {
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        soldado.setFaccion(faccion_1);
        jinete.setFaccion(faccion_2);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(12, 1);

        tablero.colocarEntidad(soldado, posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);

        soldado.atacar(casilleroDestino, tablero, faccion_1);
        // TODO: Ver como hacer assert para verificar esto
        // assertTrue(jinete.tenesEstaVida(JINETE_VIDA));
    }

    @Test 
    public void test06SoldadoSeMueveACasilleroDestino() {
    	Faccion faccionAliado = new Faccion();
		Faccion faccionEnemigo = new Faccion();
		Tablero tablero = new Tablero(faccionAliado, faccionEnemigo);
		Jugador jugador1 = new Jugador(faccionAliado);
		Soldado soldado = new Soldado(jugador1, faccionAliado);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(soldado, posicion);

		Posicion posicionDestino = new Posicion(1, 2);
		soldado.moverA(tablero, tablero.obtenerCasillero(posicionDestino), faccionAliado);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado, posicionDestino);
		});	
    }
}
