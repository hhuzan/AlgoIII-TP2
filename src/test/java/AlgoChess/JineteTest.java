package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.entidades.Catapulta;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.posicion.Posicion;
import static AlgoChess.engine.Constantes.JINETE_VIDA;
import static AlgoChess.engine.Constantes.JINETE_COSTO;
import AlgoChess.excepciones.JugadorPerdioException;
import AlgoChess.excepciones.CasilleroOcupadoException;

public class JineteTest {

	@Test
	public void test00ConstructorJineteNoDevuelveNull() {
		Jinete jinete = new Jinete();
		assertNotNull(jinete);
	}

	@Test
	public void test01CreamosUnJineteYSuCostoEsElEsperado() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        Jugador jugador = new Jugador(Faccion.ALIADOS, "Pedro");
		Jinete jinete = new Jinete();
        jugador.comprarEntidad(vendedor, jinete);
        // TODO: Ver como hacer assert para verificar esto
		// assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());
	}

	@Test
	public void test02AumentamosLaVidaDeUnJineteYDichaVidaAumenta() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1, 1);
		tablero.colocarEntidad(jinete, posicion);

		jinete.aumentarVida(20, Faccion.ALIADOS);
        // TODO: Ver como hacer assert para verificar esto
		// assertEquals(JINETE_VIDA + 20, jinete.getVida());
	}

	@Test
	public void test03DisminuimosTodaLaVidaDelJineteYMuere() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1, 1);
		tablero.colocarEntidad(jinete, posicion);

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(JINETE_VIDA, Faccion.ENEMIGOS, tablero);
		});
	}

	@Test
	public void test04JineteAtacaAEntidadEnemigaYDisminuyeLaVidaDeLaEntidadEnemiga() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador_1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador_2 = new Jugador(Faccion.ENEMIGOS);
		Jinete jinete = new Jinete(jugador_1, Faccion.ALIADOS);
		Soldado soldado = new Soldado(jugador_2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9, 1);
		tablero.colocarEntidad(jinete, posicion);

		Posicion posicionAtaque = new Posicion(10, 1);
		tablero.colocarEntidad(soldado, posicionAtaque);

		jinete.atacar(tablero.obtenerCasillero(posicionAtaque), tablero, Faccion.ALIADOS);
        // TODO: Ver como hacer assert para verificar esto
		// assertEquals(SOLDADO_VIDA - ESPADA_PODER, jinete.getVida());
	}

	@Test
	public void test05JineteAtacaAEntidadEnemigaConDagaDebidoACondicionesEstablecidas() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Posicion posJinete = new Posicion(9,10);


        Catapulta catapulta = new Catapulta();
        catapulta.setFaccion(Faccion.ENEMIGOS);
        Posicion posCatapulta = new Posicion(10,10);

        tablero.colocarEntidad(jinete,posJinete);
        tablero.colocarEntidad(catapulta, posCatapulta);

        tablero.atacarCasillero(posJinete, posCatapulta, Faccion.ALIADOS);

        // TODO: Ver como hacer assert para verificar esto
        // assertTrue(catapulta.tenesEstaVida(CATAPULTA_VIDA - DAGA_PODER));
	}

    @Test
    public void Test06JineteAtacaAEntidadEnemigaADistanciaMediaYFallaPuesEstaObligadoAUsarDaga(){
        // Aqui pongo un jinete
        // una catapulta1 enemiga distancia cercana (del jinete)
        // una catapulta2 enemiga distancia mediana (del jinete)
        // El jinete no debería poder atacar la catapulta2.
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);

        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Posicion posJinete = new Posicion(9,10);


        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();
        catapulta1.setFaccion(Faccion.ENEMIGOS);
        catapulta2.setFaccion(Faccion.ENEMIGOS);
        Posicion posCatapulta1 = new Posicion(10,10);
        Posicion posCatapulta2 = new Posicion(12,10);

        tablero.colocarEntidad(jinete,posJinete);
        tablero.colocarEntidad(catapulta1,posCatapulta1);
        tablero.colocarEntidad(catapulta2,posCatapulta2);

        tablero.atacarCasillero(posJinete,posCatapulta2,Faccion.ALIADOS);
        // TODO: Ver como hacer assert para verificar esto
        // assertTrue(catapulta2.tenesEstaVida(CATAPULTA_VIDA));

    }

    @Test 
    public void test07MovemosAlJineteYSeMueveAlCasilleroDestino() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(jinete, posicion);

		Posicion posicionDestino = new Posicion(1, 2);
		jinete.moverA(tablero, tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(jinete, posicionDestino);
		});	
    }
}
