package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void test00ConstructorJugadorNoDevuelveNull() {
		Jugador jugador = new Jugador();
		assertNotNull(jugador);
	}

	@Test
	public void test01PuedoSacarlePuntosAlJugador() {
		Jugador jugador = new Jugador();
		jugador.restarPuntos(10);
		assertEquals(10, jugador.getPuntos());
	}

	@Test
	public void test02PuedoSacarlePuntosDosVecesAlJugador() {
		Jugador jugador = new Jugador();
		jugador.restarPuntos(10);
		jugador.restarPuntos(5);
		assertEquals(5, jugador.getPuntos());
	}

	@Test
	public void test03AgregaEntidadesAJugadorQuedaSinPuntosArrojaException() {
		Jugador jugador = new Jugador(new CreadorAliado()); // TODO: Refactor esto..
		jugador.agregarCatapulta();
		jugador.agregarCatapulta();
		jugador.agregarCatapulta();
		jugador.agregarCatapulta();
		assertThrows(PuntosInsuficientesException.class, () -> {
			jugador.agregarCatapulta();
		});
	}

<<<<<<< HEAD
=======
	@Test 
	public void test04AgregarEntidadesAlJugadorAgregaLaEntidadCorrecta() {
		Jugador jugador = new Jugador();
		Entidad entidad = new Aliado(new Soldado(jugador));
		jugador.agregar(entidad);
		assertTrue(jugador.esEntidadDeJugador(entidad));
	}

	@Test 
	public void test04BuscoUnaEntidadInexistenteEnElJugadorYObtengoQueNoExiste() {
		Jugador jugador = new Jugador();
		Entidad entidad1 = new Aliado(new Soldado(jugador));
		Entidad entidad2 = new Aliado(new Jinete(jugador));
		jugador.agregar(entidad1);
		assertFalse(jugador.esEntidadDeJugador(entidad2));
	}
>>>>>>> master

}
