package algochess;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.Catapulta;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.posicion.Posicion;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import static algochess.engine.ConstantesUtils.SOLDADO_VIDA;
import static algochess.engine.ConstantesUtils.CATAPULTA_VIDA;
import static algochess.engine.ConstantesUtils.DAGA_PODER;
import algochess.excepciones.JugadorPerdioException;
import algochess.excepciones.CasilleroOcupadoException;

public class JineteTest {

	@Test
	public void test00ConstructorJineteNoDevuelveNull() {
		Jinete jinete = new Jinete();
		assertNotNull(jinete);
	}

	@Test
	public void test01AumentamosLaVidaDeUnJineteYDichaVidaAumenta() {
		Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		Jugador jugador = new Jugador(Faccion.ALIADOS);
		Jinete jinete = new Jinete(jugador, Faccion.ALIADOS);

		Posicion posicion = new Posicion(1, 1);
		tablero.colocarEntidad(jinete, posicion);

		jinete.disminuirVida(20, Faccion.ENEMIGOS, tablero);
		jinete.aumentarVida(20, Faccion.ALIADOS);
        
        assertThrows(JugadorPerdioException.class, () -> {
			jinete.disminuirVida(JINETE_VIDA, Faccion.ENEMIGOS, tablero);
		});
	}

	@Test
	public void test02DisminuimosTodaLaVidaDelJineteYMuere() {
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
	public void test03JineteAtacaAEntidadEnemigaYLeQuitaElEquivalenteAUnAtaqueCuerpoACuerpoDeUnJinete() {
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

		assertThrows(JugadorPerdioException.class, () -> {
			soldado.disminuirVida(SOLDADO_VIDA - DAGA_PODER, Faccion.ALIADOS, tablero);
		});
	}

	@Test
	public void test04JineteAtacaAEntidadEnemigaConDagaDebidoACondicionesEstablecidas() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Posicion posJinete = new Posicion(9,10);


        Catapulta catapulta = new Catapulta(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);
        catapulta.setFaccion(Faccion.ENEMIGOS);
        Posicion posCatapulta = new Posicion(10,10);

        tablero.colocarEntidad(jinete,posJinete);
        tablero.colocarEntidad(catapulta, posCatapulta);

        tablero.atacarCasillero(posJinete, posCatapulta, Faccion.ALIADOS);
		
		assertThrows(JugadorPerdioException.class, () -> {
			catapulta.disminuirVida( (SOLDADO_VIDA - DAGA_PODER), Faccion.ALIADOS, tablero);
		});
	}

    @Test
    public void test05JineteAtacaAEntidadEnemigaADistanciaMediaYFallaPuesEstaObligadoAUsarDaga(){
        // una catapulta1 enemiga distancia cercana (del jinete)
        // una catapulta2 enemiga distancia mediana (del jinete)
        // El jinete no debería poder atacar la catapulta2.
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);
        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Posicion posJinete = new Posicion(9,10);


        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta(jugador, Faccion.ENEMIGOS);
        catapulta1.setFaccion(Faccion.ENEMIGOS);
        catapulta2.setFaccion(Faccion.ENEMIGOS);
        Posicion posCatapulta1 = new Posicion(10,10);
        Posicion posCatapulta2 = new Posicion(12,10);

        tablero.colocarEntidad(jinete,posJinete);
        tablero.colocarEntidad(catapulta1,posCatapulta1);
        tablero.colocarEntidad(catapulta2,posCatapulta2);

        tablero.atacarCasillero(posJinete,posCatapulta2,Faccion.ALIADOS);
        
        assertThrows(JugadorPerdioException.class, () -> {
			catapulta2.disminuirVida(CATAPULTA_VIDA, Faccion.ALIADOS, tablero);
		});

    }

    @Test 
    public void test06MovemosAlJineteYSeMueveAlCasilleroDestino() {
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
