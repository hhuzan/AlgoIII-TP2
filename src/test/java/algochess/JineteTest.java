package algochess;

import static algochess.engine.ConstantesUtils.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.Test;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.Catapulta;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.excepciones.JugadorPerdioException;
import algochess.excepciones.EntidadFueraDeAlcanceException;
import algochess.excepciones.CasilleroOcupadoException;

public class JineteTest {

	@Test
	public void test00ConstructorJineteNoDevuelveNull() {
		Jinete jinete = new Jinete();
		assertNotNull(jinete);
	}

	@Test
	public void test01AumentamosLaVidaDeUnJineteYDichaVidaAumenta() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1, 1);
		tablero.colocarEntidad(jinete, posicion, new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicion);

		jinete.disminuirVida(20, Faccion.ENEMIGOS, casilleroDestino);
		jinete.aumentarVida(20, Faccion.ALIADOS);
        
        assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(JINETE_VIDA, Faccion.ENEMIGOS, casilleroDestino);
		});
	}

	@Test
	public void test02DisminuimosTodaLaVidaDelJineteYMuere() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1, 1);
		tablero.colocarEntidad(jinete, posicion, new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicion);

		assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(JINETE_VIDA, Faccion.ENEMIGOS, casilleroDestino);
		});
	}

	@Test
	public void test03JineteAtacaAEntidadEnemigaYLeQuitaElEquivalenteAUnAtaqueCuerpoACuerpoDeUnJinete() {
		Tablero tablero = new Tablero();
		Jugador jugador_1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador_2 = new Jugador(Faccion.ENEMIGOS);
		Jinete jinete = new Jinete(jugador_1, Faccion.ALIADOS);
		Soldado soldado = new Soldado(jugador_2, Faccion.ENEMIGOS);

		Posicion posicion = new Posicion(9, 1);
		tablero.colocarEntidad(jinete, posicion, new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionAtaque = new Posicion(10, 1);
		tablero.colocarEntidad(soldado, posicionAtaque, new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posicionAtaque);

		jinete.atacar(tablero.obtenerCasillero(posicionAtaque), tablero, Faccion.ALIADOS);

		assertThrows(JugadorPerdioException.class, () -> {
			soldado.disminuirVida(SOLDADO_VIDA - DAGA_PODER, Faccion.ALIADOS, casilleroDestino);
		});
	}

	//TEST AÑADIDO 12/6/19
	@Test
	public void test03JineteAtacaAEntidadEnemigaYLeQuitaElEquivalenteAUnAtaqueADistanciaDeUnJinete() {
		/* Se coloca un jinete y un soldado junto, y un soldado enemigo a distancia media del jinete
		el jinete ataca con su arco.
		 */
		Tablero tablero = new Tablero();
		Jugador jugador_1 = new Jugador(Faccion.ALIADOS);
		Jugador jugador_2 = new Jugador(Faccion.ENEMIGOS);

		Jinete jinete = new Jinete(jugador_1, Faccion.ALIADOS);
		Soldado soldado1 = new Soldado(jugador_1,Faccion.ALIADOS);
		Soldado soldado = new Soldado(jugador_2, Faccion.ENEMIGOS);


		Posicion posicionJinete = new Posicion(9, 1);
		Posicion posicionSoldado1 = new Posicion(9,2);
		Posicion posicionSoldado = new Posicion(13, 1);

		tablero.colocarEntidad(jinete, posicionJinete, jugador_1);
		tablero.colocarEntidad(soldado1,posicionSoldado1,jugador_1);
		tablero.colocarEntidad(soldado, posicionSoldado, jugador_2);

		Casillero casilleroAtacado = tablero.obtenerCasillero(posicionSoldado);

		jinete.atacar(casilleroAtacado, tablero, Faccion.ALIADOS);

		assertTrue(soldado.tenesEstaVida(SOLDADO_VIDA-ARCO_PODER));
		/*assertThrows(JugadorPerdioException.class, () -> {
			soldado.disminuirVida(SOLDADO_VIDA - ARCO_PODER, Faccion.ALIADOS, casilleroAtacado);
		});*/
	}

	@Test
	public void test04JineteAtacaAEntidadEnemigaConDagaDebidoACondicionesEstablecidas() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Posicion posJinete = new Posicion(9,10);


        Catapulta catapulta = new Catapulta(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);
        catapulta.setFaccion(Faccion.ENEMIGOS);
        Posicion posCatapulta = new Posicion(10,10);

        tablero.colocarEntidad(jinete,posJinete, new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(catapulta, posCatapulta, new Jugador(Faccion.ALIADOS, "Lucas"));
		Casillero casilleroDestino = tablero.obtenerCasillero(posCatapulta);

        tablero.atacarCasillero(posJinete, posCatapulta, Faccion.ALIADOS);
		
		assertThrows(JugadorPerdioException.class, () -> {
			catapulta.disminuirVida( (SOLDADO_VIDA - DAGA_PODER), Faccion.ALIADOS, casilleroDestino);
		});
	}

    @Test
    public void test05JineteAtacaAEntidadEnemigaADistanciaMediaYFallaPuesEstaObligadoAUsarDaga(){
        // una catapulta1 enemiga distancia cercana (del jinete)
        // una catapulta2 enemiga distancia mediana (del jinete)
        // El jinete no debería poder atacar la catapulta2.
        Tablero tablero = new Tablero();
		Jugador jugadorAliados = new Jugador(Faccion.ALIADOS);
		Jugador jugadorEnemigos = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete();
		Soldado soldado = new Soldado();
		jinete.setFaccion(Faccion.ALIADOS);
        soldado.setFaccion(Faccion.ENEMIGOS);

        Posicion posJinete = new Posicion(9,10);
		Posicion posSoldado = new Posicion(10,10);


        tablero.colocarEntidad(jinete,posJinete, jugadorAliados);
        tablero.colocarEntidad(soldado,posSoldado,jugadorEnemigos);
		Casillero casilleroDestino = tablero.obtenerCasillero(posSoldado);

		tablero.atacarCasillero(posJinete,posSoldado,Faccion.ALIADOS);
        assertTrue(soldado.tenesEstaVida(SOLDADO_VIDA-DAGA_PODER));
    }

    @Test 
    public void test06MovemosAlJineteYSeMueveAlCasilleroDestino() {
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador(Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador1, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1,1);
		tablero.colocarEntidad(jinete, posicion, new Jugador(Faccion.ALIADOS, "Lucas"));

		Posicion posicionDestino = new Posicion(1, 2);
		jinete.moverA(tablero, tablero.obtenerCasillero(posicion), tablero.obtenerCasillero(posicionDestino), Faccion.ALIADOS);

		assertThrows(CasilleroOcupadoException.class, () -> {
			tablero.colocarEntidad(jinete, posicionDestino, new Jugador(Faccion.ALIADOS, "Lucas"));
		});	
    }



}
