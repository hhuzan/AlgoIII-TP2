package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
	public void test10AgregaEntidadesAJugadorQuedaSinPuntosArrojaException() {
		Jugador jugador = new Jugador(new CreadorAliado()); // TODO: Refactor esto..
		jugador.agregarCatapulta();
		jugador.agregarCatapulta();
		jugador.agregarCatapulta();
		jugador.agregarCatapulta();
		assertThrows(PuntosInsuficientesException.class, () -> {
			jugador.agregarCatapulta();
		});
	}

}
