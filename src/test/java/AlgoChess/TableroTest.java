package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import AlgoChess.excepciones.CasilleroOcupadoException;
import AlgoChess.excepciones.ColocarEntidadException;
import AlgoChess.excepciones.CasilleroVacioException;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.excepciones.JugadorPerdioException;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
public class TableroTest {

	@Test
	public void test00ConstructorTableroNoDevuelveNull() {
		Faccion faccion_1 = new Faccion();
		Faccion faccion_2 = new Faccion();
		Tablero tablero = new Tablero(faccion_1, faccion_2);
		assertNotNull(tablero);
	}

	@Test
	public void test01AgregoUnaJineteAlTableroYLeRestoTresPuntosAlJugador() {
		Faccion faccion = new Faccion();
		Tablero tablero = new Tablero(faccion, faccion);
		Jugador jugador = new Jugador(faccion);
		Entidad jinete = new Jinete();

		jinete.setFaccion(faccion);
		Posicion posicion = new Posicion(1, 1);
		tablero.colocarEntidad(jinete, posicion);
		// TODO: Ver como hacer assert para verificar esto
		//assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());

	}

	@Test
	public void test02AgregoEntidadDeUnaFaccionEnSeccionDeEsaFaccionYSeColocaEnEsaPosicion() {
		Faccion faccionAliados = new Faccion();
		Faccion faccionEnemigos = new Faccion();
		Tablero tablero = new Tablero(faccionAliados, faccionEnemigos);
		Jugador jugador1 = new Jugador(faccionAliados);
		Entidad soldado1 = new Soldado();
		Entidad soldado2 = new Soldado();

		soldado1.setFaccion(faccionAliados);
		soldado2.setFaccion(faccionAliados);
		Posicion posicion = new Posicion(5, 6);
		tablero.colocarEntidad(soldado1, posicion);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado2, posicion);
		});		
	}


	@Test
	public void test03AgregarEntidadDeUnaFaccionEnCasilleroDeOtraTiraExcepcion() {
		Faccion faccionAliada = new Faccion();
		Faccion faccionEnemiga = new Faccion();
		Tablero tablero = new Tablero(faccionAliada, faccionEnemiga);
		Entidad soldado = new Soldado();
		soldado.setFaccion(faccionEnemiga);
		Posicion posicion = new Posicion(1, 1); // Posicion faccionAliada
		assertThrows(ColocarEntidadException.class, () -> {
			tablero.colocarEntidad(soldado, posicion);
		});
	}

	@Test
	public void test04MovemosHaciaUnCasilleroYElCasilleroSeOcupaConDichaEntidad() {
		Faccion faccionAliada = new Faccion();
		Faccion faccionEnemiga = new Faccion();
		Tablero tablero = new Tablero(faccionAliada, faccionEnemiga);
		Soldado soldado = new Soldado();
		soldado.setFaccion(faccionAliada);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(soldado, posOrigen);
		tablero.moverEntidad(posOrigen, posDestino, faccionAliada);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado, posDestino);
		});	
	}

	@Test 
	public void test05MovemosHaciaArribaYElCasilleroOrigenQuedaLibre() {
		Faccion faccionAliada = new Faccion();
		Faccion faccionEnemiga = new Faccion();
		Tablero tablero = new Tablero(faccionAliada, faccionEnemiga);
		Soldado soldado = new Soldado();
		soldado.setFaccion(faccionAliada);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(soldado, posOrigen);
		tablero.moverEntidad(posOrigen, posDestino, faccionAliada);
		assertThrows(CasilleroVacioException.class, () -> {
			tablero.atacarCasillero(posOrigen ,posDestino, faccionAliada);
		});			
	}


	@Test
	public void test06MoverEntidadACasilleroOcupadoArrojaExcepcion() {
		Faccion faccionAliada = new Faccion();
		Faccion faccionEnemiga = new Faccion();
		Tablero tablero = new Tablero(faccionAliada, faccionEnemiga);
		Jinete jineteOrigen = new Jinete();
		Soldado soldadoDestino = new Soldado();
		jineteOrigen.setFaccion(faccionAliada);
		soldadoDestino.setFaccion(faccionAliada);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(jineteOrigen, posOrigen);
		tablero.colocarEntidad(soldadoDestino, posDestino);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.moverEntidad(posOrigen, posDestino, faccionAliada);
		});
	}

	@Test
	public void test07EntidadAliadaAtacaEntidadEnemigaYRestaVidaALaEntidadEnemiga() {
		Faccion faccionAliada = new Faccion();
		Faccion faccionEnemiga = new Faccion();
		Tablero tablero = new Tablero(faccionAliada, faccionEnemiga);
		Soldado soldado = new Soldado();
		Jinete jinete = new Jinete();
		soldado.setFaccion(faccionAliada);
		jinete.setFaccion(faccionEnemiga);

		Posicion posSoldado = new Posicion(9, 1);
		Posicion posJinete = new Posicion(10, 1);

		tablero.colocarEntidad(soldado, posSoldado);
		tablero.colocarEntidad(jinete, posJinete);
		tablero.atacarCasillero(posSoldado, posJinete, faccionAliada);
		// TODO: Ver como hacer assert para verificar esto
		// assertEquals(jinete2.getVida(), 95);
	}
	
	@Test 
	public void test08AtacarEntidadDeMismaFaccionArrojaExcepcion() {
		Faccion faccionAliada = new Faccion();
		Faccion faccionEnemiga = new Faccion();
		Tablero tablero = new Tablero(faccionAliada, faccionEnemiga);
		Soldado soldado = new Soldado();
		Jinete jinete = new Jinete();
		soldado.setFaccion(faccionAliada);
		jinete.setFaccion(faccionAliada);

		Posicion posSoldado = new Posicion(5, 1);
		Posicion posJinete = new Posicion(6, 1);

		tablero.colocarEntidad(soldado, posSoldado);
		tablero.colocarEntidad(jinete, posJinete);
		assertThrows(EntidadDeMismaFaccionException.class, () -> {
			tablero.atacarCasillero(posSoldado, posJinete, faccionAliada);
		});
	}


	// TODO: Ver si realmente pertenece a tablerotest...
	@Test
	public void test09UnJugadorSeQuedaSinEntidadesYPierde() { 
		Faccion faccionAliada = new Faccion();
		Faccion faccionEnemiga = new Faccion();
		Tablero tablero = new Tablero(faccionAliada, faccionEnemiga);
		
		VendedorDeEntidades vendedor = new VendedorDeEntidades();
		Jugador jugador = new Jugador(faccionEnemiga);
		
		Soldado soldado = new Soldado();
		Jinete jinete = new Jinete(jugador, faccionEnemiga);
		soldado.setFaccion(faccionAliada);
		jugador.comprarEntidad(vendedor, jinete);

		Posicion posSoldado = new Posicion(9, 1);
		Posicion posJinete = new Posicion(10, 1);

		tablero.colocarEntidad(soldado, posSoldado);
		tablero.colocarEntidad(jinete, posJinete);
		for (int i = 0; i < 9; i++) {
			tablero.atacarCasillero(posSoldado, posJinete, faccionAliada);
		}

		assertThrows(JugadorPerdioException.class, () -> {
			tablero.atacarCasillero(posSoldado, posJinete, faccionAliada);
		});
	}
}
