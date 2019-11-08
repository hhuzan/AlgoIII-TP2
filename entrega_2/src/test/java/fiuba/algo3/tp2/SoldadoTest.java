package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class SoldadoTest {

	@Test
	public void test00ConstructorSoldadoNoDevuelveNull() {
		Soldado soldado = new Soldado(new Jugador());
		assertNotNull(soldado);
	}

	@Test 
	public void test01CreamosUnSoldadoYSuVidaEsLaEsperada() {
		int vidaSoldado = 100;
		Soldado soldado = new Soldado(new Jugador());
		assertEquals(vidaSoldado, soldado.getVida());
	}

	@Test 
	public void test03CreamosUnSoldadoYRestamosPuntosDeCostoAlJugador() {
		int costoSoldado = 1;
		int puntosJugadorNuevo = 20;
		Jugador jugador = new Jugador();
		Soldado soldado = new Soldado(jugador);
		soldado.restarAJugador();
		assertEquals(puntosJugadorNuevo - costoSoldado, jugador.getPuntos());
	}

	@Test 
	public void test04AtacamosConUnSoldadoYLaPiezaEnemigaPierdeVida() {
		int distancia = 1;
		DistanciaCercana tipoDistancia = new DistanciaCercana(distancia);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
		Entidad soldado = new Aliado(new Soldado(jugador1));
		Entidad jinete = new Enemigo(new Jinete(jugador2));
		jugador1.agregar(soldado);
		jugador2.agregar(jinete);
		soldado.atacar(jinete, tipoDistancia);
		assertEquals(90, jinete.getVida());
	}

	// Test 5: No puede atacar enemigo a distancia media o lejana 
	// Test 6: Ver lo de los 3 soldados contiguos...
}
