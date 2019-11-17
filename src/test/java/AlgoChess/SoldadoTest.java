package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import AlgoChess.engine.entidades.Soldado;


public class SoldadoTest {

	@Test
	public void test00ConstructorSoldadoNoDevuelveNull() {
		Soldado soldado = new Soldado();
		assertNotNull(soldado);
	}

// 	@Test 
// 	public void test01CreamosUnSoldadoYSuVidaEsLaEsperada() {
// 		int vidaSoldado = 100;
// 		Soldado soldado = new Soldado();
// 		assertEquals(vidaSoldado, soldado.getVida());
// 	}

// 	@Test 
// 	public void test03CreamosUnSoldadoYRestamosPuntosDeCostoAlJugador() {
// 		int costoSoldado = 1;
// 		int puntosJugadorNuevo = 20;
// 		Jugador jugador = new Jugador();
// 		Soldado soldado = new Soldado();
// 		soldado.restarAJugador();
// 		assertEquals(puntosJugadorNuevo - costoSoldado, jugador.getPuntos());
// 	}

// 	@Test 
// 	public void test04AtacamosConUnSoldadoYLaPiezaEnemigaPierdeVida() {
// 		int distancia = 1;
// 		Distancia tipoDistancia = new DistanciaCercana(distancia);
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador();	// TODO: Refactor esto..
// 		Entidad soldado = new Aliado(new Soldado());
// 		Entidad jinete = new Enemigo(new Jinete());
// 		jugador1.agregar(soldado);
// 		jugador2.agregar(jinete);
// 		soldado.atacar(jinete, tipoDistancia);
// 		assertEquals(90, jinete.getVida());
// 	}

// 	// Test 5: No puede atacar enemigo a distancia media o lejana 
// 	// Test 6: Ver lo de los 3 soldados contiguos...
}
