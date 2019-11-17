package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.posicion.Posicion;
import static AlgoChess.engine.Constantes.JINETE_VIDA;
import static AlgoChess.engine.Constantes.JINETE_COSTO;

public class JineteTest {

	@Test
	public void test00ConstructorJineteNoDevuelveNull() {
		Jinete jinete = new Jinete();
		assertNotNull(jinete);
	}

	@Test
	public void test01CreamosUnJineteYSuCostoEsElEsperado() {
		Faccion faccion = new Faccion();
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        Jugador jugador = new Jugador(faccion, "Pedro");
		Jinete jinete = new Jinete();
        jugador.comprarEntidad(vendedor, jinete);
        // TODO: Ver como hacer assert para verificar esto
		// assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());
	}

// 	@Test
// 	public void test02CreamosUnJineteYSuVidaEsLaEsperada() {
// 		int vidaJinete = 100;
// 		Jinete jinete = new Jinete();
// 		assertEquals(vidaJinete, jinete.getVida());
// 	}

// 	@Test
// 	public void test03CreamosUnJineteYRestamosPuntosDeCostoAlJugador() {
// 		int costoJinete = 3;
// 		int puntosJugadorNuevo = 20;
// 		Jugador jugador = new Jugador();
// 		Jinete jinete = new Jinete();
// 		jinete.restarAJugador();
// 		assertEquals(puntosJugadorNuevo - costoJinete, jugador.getPuntos());
// 	}

// 	@Test
// 	public void test04AtacamosConUnJineteYElEnemigoRecibeDanio() {
// 		int distancia = 7;
// 		Distancia tipoDistancia = new DistanciaLejana(distancia);
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
// 		Entidad catapulta = new Jinete();
// 		Entidad jinete = new Jinete();
// 		jugador1.agregar(catapulta);
// 		jugador2.agregar(jinete);
// 		catapulta.atacar(jinete, tipoDistancia);
// 		assertEquals(85, jinete.getVida());
// 	}

}
