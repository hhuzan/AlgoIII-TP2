package algochess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import algochess.engine.juego.Turno;
import org.junit.Test;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import static algochess.engine.ConstantesUtils.ESPADA_PODER;
import algochess.excepciones.CasilleroOcupadoException;
import algochess.excepciones.ColocarEntidadException;
import algochess.excepciones.CasilleroVacioException;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.excepciones.JugadorPerdioException;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Casillero;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.posicion.Posicion;

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
		tablero.colocarEntidad(soldado1, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(soldado2, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		});		
	}


	@Test
	public void test02AgregarEntidadDeUnaFaccionEnCasilleroDeOtraTiraExcepcion() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Entidad soldado = new Soldado();
		soldado.setFaccion(Faccion.ENEMIGOS);
		Posicion posicion = new Posicion(1, 1); // Posicion faccionAliada
		assertThrows(ColocarEntidadException.class, () -> {
			tablero.colocarEntidad(soldado, posicion, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		});
	}

	@Test
	public void test03MovemosHaciaUnCasilleroYElCasilleroSeOcupaConDichaEntidad() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Soldado soldado = new Soldado();
		soldado.setFaccion(Faccion.ALIADOS);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(soldado, posOrigen, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.moverEntidad(posOrigen, posDestino, Faccion.ALIADOS, new Turno(Faccion.ALIADOS));
			assertThrows(CasilleroOcupadoException.class, () -> {
				tablero.colocarEntidad(soldado, posDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
			});	
	}

	@Test 
	public void test04MovemosHaciaArribaYElCasilleroOrigenQuedaLibre() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Soldado soldado = new Soldado();
		soldado.setFaccion(Faccion.ALIADOS);

		Posicion posOrigen = new Posicion(1, 1);
		Posicion posDestino = new Posicion(1, 2);

		tablero.colocarEntidad(soldado, posOrigen, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.moverEntidad(posOrigen, posDestino, Faccion.ALIADOS, new Turno(Faccion.ALIADOS));
		assertThrows(CasilleroVacioException.class, () -> {
			tablero.atacarCasillero(posOrigen ,posDestino, Faccion.ALIADOS, new Turno(Faccion.ALIADOS));
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

		tablero.colocarEntidad(jineteOrigen, posOrigen, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldadoDestino, posDestino, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.moverEntidad(posOrigen, posDestino, Faccion.ALIADOS, new Turno(Faccion.ALIADOS));
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

		tablero.colocarEntidad(soldado, posSoldado, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(jinete, posJinete, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS, new Turno(Faccion.ALIADOS));

		Casillero casilleroDestino = tablero.obtenerCasillero(posJinete);

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(JINETE_VIDA - ESPADA_PODER, Faccion.ALIADOS, casilleroDestino);
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

		tablero.colocarEntidad(soldado, posSoldado, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(jinete, posJinete, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		assertThrows(EntidadDeMismaFaccionException.class, () -> {
			tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS, new Turno(Faccion.ALIADOS));
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

		tablero.colocarEntidad(soldado, posSoldado, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(jinete, posJinete, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
		for (int i = 0; i < 9; i++) {
			tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS,new Turno(Faccion.ALIADOS));
		}

		assertThrows(JugadorPerdioException.class, () -> {
			tablero.atacarCasillero(posSoldado, posJinete, Faccion.ALIADOS,new Turno(Faccion.ALIADOS));
		});
	}
}
