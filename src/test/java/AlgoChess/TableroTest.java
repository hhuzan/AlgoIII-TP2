package AlgoChess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import static AlgoChess.engine.Constantes.JINETE_VIDA;
import static AlgoChess.engine.Constantes.ESPADA_PODER;
import AlgoChess.excepciones.CasilleroOcupadoException;
import AlgoChess.excepciones.ColocarEntidadException;
import AlgoChess.excepciones.CasilleroVacioException;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.excepciones.JugadorPerdioException;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;

public class TableroTest {

	@Test
	public void test00ConstructorTableroNoDevuelveNull() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		assertNotNull(tablero);
	}

	@Test
	public void test01AgregoEntidadDeUnaFaccionEnSeccionDeEsaFaccionYSeColocaEnEsaPosicion() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Entidad soldado1 = new Soldado();
		Entidad soldado2 = new Soldado();

		soldado1.setFaccion(Faccion.ALIADOS);
		soldado2.setFaccion(Faccion.ALIADOS);
		Posicion posicion = new Posicion(5, 6);
		tablero.colocarEntidad(soldado1, posicion);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado2, posicion);
		});		
	}


	@Test
	public void test02AgregarEntidadDeUnaFaccionEnCasilleroDeOtraTiraExcepcion() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Entidad soldado = new Soldado();
		soldado.setFaccion(Faccion.ENEMIGOS);
		Posicion posicion = new Posicion(1, 1); // Posicion faccionAliada
		assertThrows(ColocarEntidadException.class, () -> {
			tablero.colocarEntidad(soldado, posicion);
		});
	}

	@Test
	public void test03MovemosHaciaUnCasilleroYElCasilleroSeOcupaConDichaEntidad() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Soldado soldado = new Soldado();
		soldado.setFaccion(Faccion.ALIADOS);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(soldado, posOrigen);
		tablero.moverEntidad(posOrigen, posDestino, Faccion.ALIADOS);
			assertThrows(CasilleroOcupadoException.class, () -> {
				tablero.colocarEntidad(soldado, posDestino);
			});	
	}

	@Test 
	public void test04MovemosHaciaArribaYElCasilleroOrigenQuedaLibre() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Soldado soldado = new Soldado();
		soldado.setFaccion(Faccion.ALIADOS);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(soldado, posOrigen);
		tablero.moverEntidad(posOrigen, posDestino, Faccion.ALIADOS);
		assertThrows(CasilleroVacioException.class, () -> {
			tablero.atacarCasillero(posOrigen ,posDestino, Faccion.ALIADOS);
		});			
	}


	@Test
	public void test05MoverEntidadACasilleroOcupadoArrojaExcepcion() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jinete jineteOrigen = new Jinete();
		Soldado soldadoDestino = new Soldado();
		jineteOrigen.setFaccion(Faccion.ALIADOS);
		soldadoDestino.setFaccion(Faccion.ALIADOS);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(jineteOrigen, posOrigen);
		tablero.colocarEntidad(soldadoDestino, posDestino);
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.moverEntidad(posOrigen, posDestino, Faccion.ALIADOS);
		});
	}

	@Test
	public void test06EntidadAliadaAtacaEntidadEnemigaYRestaVidaALaEntidadEnemiga() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Soldado soldado = new Soldado();
		Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);
		soldado.setFaccion(Faccion.ALIADOS);
		jinete.setFaccion(Faccion.ENEMIGOS);

		Posicion posSoldado = new Posicion(9, 1);
		Posicion posJinete = new Posicion(10, 1);

		tablero.colocarEntidad(soldado, posSoldado);
		tablero.colocarEntidad(jinete, posJinete);
		tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS);

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(JINETE_VIDA - ESPADA_PODER, Faccion.ALIADOS, tablero);
		});
	}
	
	@Test 
	public void test07AtacarEntidadDeMismaFaccionArrojaExcepcion() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Soldado soldado = new Soldado();
		Jinete jinete = new Jinete();
		soldado.setFaccion(Faccion.ALIADOS);
		jinete.setFaccion(Faccion.ALIADOS);

		Posicion posSoldado = new Posicion(5, 1);
		Posicion posJinete = new Posicion(6, 1);

		tablero.colocarEntidad(soldado, posSoldado);
		tablero.colocarEntidad(jinete, posJinete);
		assertThrows(EntidadDeMismaFaccionException.class, () -> {
			tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS);
		});
	}


	@Test
	public void test09UnJugadorSeQuedaSinEntidadesYPierde() { 
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		
		VendedorDeEntidades vendedor = new VendedorDeEntidades();
		Jugador jugador = new Jugador(Faccion.ENEMIGOS);
		
		Soldado soldado = new Soldado();
		Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);
		soldado.setFaccion(Faccion.ALIADOS);
		jugador.comprarEntidad(vendedor, jinete);

		Posicion posSoldado = new Posicion(9, 1);
		Posicion posJinete = new Posicion(10, 1);

		tablero.colocarEntidad(soldado, posSoldado);
		tablero.colocarEntidad(jinete, posJinete);
		for (int i = 0; i < 9; i++) {
			tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS);
		}

		assertThrows(JugadorPerdioException.class, () -> {
			tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS);
		});
	}
}
