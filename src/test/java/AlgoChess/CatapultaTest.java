package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.entidades.Catapulta;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import org.junit.Test;
import AlgoChess.excepciones.EntidadNoPuedeMoverseException;

public class CatapultaTest {

	@Test
	public void test00ConstructorCatapultaNoDevuelveNull() {
		Catapulta catapulta = new Catapulta();
		assertNotNull(catapulta);
	}

	@Test
	public void test01CreamosUnaCatapultaYSuCostoEsElEsperado() {
        Faccion faccion = new Faccion();
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        Jugador jugador = new Jugador(faccion, "Pedro");
		Catapulta catapulta = new Catapulta();
        jugador.comprarEntidad(vendedor, catapulta);
        // TODO: Ver como hacer assert para verificar esto
	// assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());
	}

	@Test
	public void test02AtacamosConUnaCatapultaYElEnemigoRecibeDanio() { 
        Faccion faccion_1 = new Faccion();
        Faccion faccion_2 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_2);

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        Posicion posOrigen = new Posicion(6,1);
        Posicion posDestino = new Posicion(12,1);

        catapulta.setFaccion(faccion_1);
        jinete.setFaccion(faccion_2);

        tablero.colocarEntidad(catapulta, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        catapulta.atacar(casilleroDestino, tablero, faccion_1);
        // TODO: Ver como hacer assert para verificar esto
		//assertEquals(jinete.getVida(), JINETE_VIDA - ROCA_PODER);
	}

	@Test
	public void test03AtacamosConUnaCatapultaYElAliadoRecibeDanio() {
        Faccion faccion_1 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_1);

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        catapulta.setFaccion(faccion_1);
        jinete.setFaccion(faccion_1);

        Posicion posOrigen = new Posicion(1,1);
        Posicion posDestino = new Posicion(1,2);

        tablero.colocarEntidad(catapulta, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        catapulta.atacar(casilleroDestino, tablero, faccion_1);
        // TODO: Ver como hacer assert para verificar esto
		//assertEquals(jinete.getVida(), JINETE_VIDA - ROCA_PODER);
	}

	@Test
	public void test04IntentamosMoverUnaCatapultaYLevantaUnaExcepcion() {
		Faccion faccion_1 = new Faccion();
        Tablero tablero = new Tablero(faccion_1, faccion_1);

        Catapulta catapulta = new Catapulta();
        catapulta.setFaccion(faccion_1);

        Posicion posOrigen = new Posicion(1,1);
        Posicion posDestino = new Posicion(1,2);

        tablero.colocarEntidad(catapulta, posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);

        assertThrows(EntidadNoPuedeMoverseException.class, () -> {
        	casilleroOrigen.moverEntidad(tablero, casilleroDestino, faccion_1);
	   });
	}
	// Test 05: Catapulta falla al atacar a distancia cercana o media
	// Test 06: Catapulta ataca bloque de casilleros si hay otras entidades
}
