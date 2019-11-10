package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class JineteTest {

	@Test
	public void test00ConstructorJineteNoDevuelveNull() {
		Jinete jinete = new Jinete(new Jugador());
		assertNotNull(jinete);
	}

	@Test
	public void test01CreamosUnJineteYSuCostoEsElEsperado() {
		int costoJinete = 3;
		Jinete jinete = new Jinete(new Jugador());
		assertEquals(costoJinete, jinete.getCosto());
	}

	@Test
	public void test02CreamosUnJineteYSuVidaEsLaEsperada() {
		int vidaJinete = 100;
		Jinete jinete = new Jinete(new Jugador());
		assertEquals(vidaJinete, jinete.getVida());
	}

	@Test
	public void test03CreamosUnJineteYRestamosPuntosDeCostoAlJugador() {
		int costoJinete = 3;
		int puntosJugadorNuevo = 20;
		Jugador jugador = new Jugador();
		Jinete jinete = new Jinete(jugador);
		jinete.restarAJugador();
		assertEquals(puntosJugadorNuevo - costoJinete, jugador.getPuntos());
	}

	@Test
	public void test04AtacamosConUnJineteYElEnemigoRecibeDanio() {
		int distancia = 7;
		Distancia tipoDistancia = new DistanciaLejana(distancia);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
		Entidad catapulta = new Aliado(new Jinete(jugador1));
		Entidad jinete = new Enemigo(new Jinete(jugador2));
		jugador1.agregar(catapulta);
		jugador2.agregar(jinete);
		catapulta.atacar(jinete, tipoDistancia);
		assertEquals(85, jinete.getVida());
	}

}
