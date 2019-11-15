// package AlgoChess;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import org.junit.Test;

// import AlgoChess.excepciones.TipoNoPuedeSerCuradoException;

// public class CuranderoTest {

// 	@Test
// 	public void test00ConstructorCuranderoNoDevuelveNull() {
// 		Curandero curandero = new Curandero();
// 		assertNotNull(curandero);
// 	}

// 	@Test
// 	public void test01CreamosUnCuranderoYSuCostoEsElEsperado() {
// 		int costoCurandero = 2;
// 		Curandero curandero = new Curandero();
// 		assertEquals(costoCurandero, curandero.getCosto());
// 	}

// 	@Test
// 	public void test02CreamosUnCuranderoYSuVidaEsLaEsperada() {
// 		int vidaCurandero = 75;
// 		Curandero curandero = new Curandero();
// 		assertEquals(vidaCurandero, curandero.getVida());
// 	}

// 	@Test
// 	public void test03CreamosUnCuranderoYRestamosPuntosDeCostoAlJugador() {
// 		int costoCurandero = 2;
// 		int puntosJugadorNuevo = 20;
// 		Jugador jugador = new Jugador();
// 		Curandero curandero = new Curandero();
// 		curandero.restarAJugador();
// 		assertEquals(puntosJugadorNuevo - costoCurandero, jugador.getPuntos());
// 	}

// 	@Test
// 	public void test04CuramosConUnCuranderoYElAliadoSumaVida() {
// 		int distancia = 1;
// 		Distancia tipoDistancia = new DistanciaCercana(distancia);
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
// 		Entidad curandero = new Curandero();
// 		Entidad jinete = new Jinete();
// 		jugador1.agregar(curandero);
// 		jugador2.agregar(jinete);
// 		curandero.curar(jinete, tipoDistancia);
// 		assertEquals(115, jinete.getVida());
// 	}

// 	@Test
// 	public void test05CuranderCuraACatapultaArrojaExcepcion() {
// 		int distancia = 1;
// 		Distancia tipoDistancia = new DistanciaCercana(distancia);
// 		Jugador jugador1 = new Jugador();
// 		Jugador jugador2 = new Jugador(); // TODO: Refactor esto..
// 		Entidad curandero = new Aliado(new Curandero());
// 		Entidad catapulta = new Aliado(new Catapulta());
// 		jugador1.agregar(curandero);
// 		jugador2.agregar(catapulta);
// 		assertThrows(TipoNoPuedeSerCuradoException.class, () -> {
// 			curandero.curar(catapulta, tipoDistancia);
// 		});
// 	}

// 	// Test 06: Falla al curar de distancia media o lejana
// }
