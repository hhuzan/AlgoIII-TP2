package algochess;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import algochess.engine.tablero.Tablero;
import algochess.engine.entidades.Catapulta;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.posicion.Posicion;
import algochess.excepciones.JugadorPerdioException;
import static algochess.engine.Constantes.SOLDADO_VIDA;
import static algochess.engine.Constantes.JINETE_VIDA;
import static algochess.engine.Constantes.ROCA_PODER;
import algochess.excepciones.CasilleroOcupadoException;
import org.junit.Test;

public class CatapultaTest {

	@Test
	public void test00ConstructorCatapultaNoDevuelveNull() {
		Catapulta catapulta = new Catapulta();
		assertNotNull(catapulta);
	}

	@Test
	public void test01AtacamosConUnaCatapultaYElEnemigoRecibeDanio() { 
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        Catapulta catapulta = new Catapulta(new Jugador(Faccion.ALIADOS), Faccion.ALIADOS);
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(6,1);
        Posicion posDestino = new Posicion(12,1);

        tablero.colocarEntidad(catapulta, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        for(int i = 0; i < (JINETE_VIDA  / ROCA_PODER) - 1; i++) {
            catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
        }

        assertThrows(JugadorPerdioException.class, () -> {
            catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
        });
	}

	@Test
	public void test02AtacamosConUnaCatapultaYElAliadoRecibeDanio() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ALIADOS);

        Catapulta catapulta = new Catapulta(new Jugador(Faccion.ALIADOS), Faccion.ALIADOS);
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);

        catapulta.setFaccion(Faccion.ALIADOS);
        jinete.setFaccion(Faccion.ALIADOS);

        Posicion posOrigen = new Posicion(2,1);
        Posicion posDestino = new Posicion(8,1);

        tablero.colocarEntidad(catapulta, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);

        for(int i = 0; i < (JINETE_VIDA  / ROCA_PODER) - 2; i++) {
            catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
        }

        assertThrows(JugadorPerdioException.class, () -> {
            catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
        });
	}

	@Test
	public void test03IntentamosMoverUnaCatapultaPeroNoEsUnaEntidadMovible() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ALIADOS);

        Catapulta catapulta = new Catapulta();
        catapulta.setFaccion(Faccion.ALIADOS);

        Posicion posOrigen = new Posicion(1,1);
        Posicion posDestino = new Posicion(1,2);

        tablero.colocarEntidad(catapulta, posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);

        casilleroOrigen.moverEntidad(tablero, casilleroDestino, Faccion.ALIADOS); 

        assertThrows(CasilleroOcupadoException.class, () -> {
            tablero.colocarEntidad(catapulta, posOrigen);
        });
	}

	@Test 
    public void test04CatapultaNoAtacaADistanciaQueNoEsLejana() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

         Catapulta catapulta = new Catapulta(new Jugador(Faccion.ALIADOS), Faccion.ALIADOS);
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS), Faccion.ENEMIGOS);
        catapulta.setFaccion(Faccion.ALIADOS);
        jinete.setFaccion(Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(catapulta, posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
    }

    @Test
    public void test05CatapultaAtacaAUnidadesContiguasDelCasilleroDeAtaque(){
    // Pongo 5 unidades contiguas (enemigas y aliadas)
    // Una catapulta ataca a una de ellas, y debería poder bajarle vida a todas.

       Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
       Jugador jugador1 = new Jugador(Faccion.ALIADOS);
       Jugador jugador2 = new Jugador(Faccion.ENEMIGOS);

       /*Catapulta*/
       Catapulta catapulta = new Catapulta(jugador1, Faccion.ALIADOS);
       Posicion pcatapulta = new Posicion(0,10);
       tablero.colocarEntidad(catapulta, pcatapulta);

       /*Creo soldados*/
       Soldado soldado1 = new Soldado(jugador1, Faccion.ALIADOS);
       Soldado soldado2 = new Soldado(jugador1, Faccion.ALIADOS);
       Soldado soldado3 = new Soldado(jugador1, Faccion.ALIADOS);
       Soldado soldado4 = new Soldado(jugador1, Faccion.ALIADOS);
       Soldado soldado5 = new Soldado(jugador1, Faccion.ALIADOS);
       Soldado soldado6 = new Soldado(jugador1, Faccion.ALIADOS);
       Soldado soldado7 = new Soldado(jugador1, Faccion.ALIADOS);

       /*Creo jinetes*/
       Jinete jinete1 = new Jinete(jugador2, Faccion.ENEMIGOS);
       Jinete jinete2 = new Jinete(jugador2, Faccion.ENEMIGOS);
       Jinete jinete3 = new Jinete(jugador2, Faccion.ENEMIGOS);
       Jinete jinete4 = new Jinete(jugador2, Faccion.ENEMIGOS);
       Jinete jinete5 = new Jinete(jugador2, Faccion.ENEMIGOS);
       Jinete jinete6 = new Jinete(jugador2, Faccion.ENEMIGOS);

       /*Posiciones soldados f1*/
       Posicion psoldado1 = new Posicion(6,9);
       Posicion psoldado2 = new Posicion(7,9);
       Posicion psoldado3 = new Posicion(8,9);
       Posicion psoldado4 = new Posicion(9,9);
       Posicion psoldado5 = new Posicion(9,10);
       Posicion psoldado6 = new Posicion(8,11);
       Posicion psoldado7 = new Posicion(7,12);

       /*Posiciones jinetes f2*/
       Posicion pjinete1 = new Posicion(10,10);
       Posicion pjinete2 = new Posicion(11,10);
       Posicion pjinete3 = new Posicion(11,9);
       Posicion pjinete4 = new Posicion(12,8);
       Posicion pjinete5 = new Posicion(11,11);
       Posicion pjinete6 = new Posicion(12,12);

      /*Coloco soldados f1 en tablero*/
       tablero.colocarEntidad(soldado1, psoldado1);
       tablero.colocarEntidad(soldado2, psoldado2);
       tablero.colocarEntidad(soldado3, psoldado3);
       tablero.colocarEntidad(soldado4, psoldado4);
       tablero.colocarEntidad(soldado5, psoldado5);
       tablero.colocarEntidad(soldado6, psoldado6);
       tablero.colocarEntidad(soldado7, psoldado7);

       /*Coloco jinetes f2 en tablero*/
       tablero.colocarEntidad(jinete1, pjinete1);
       tablero.colocarEntidad(jinete2, pjinete2);
       tablero.colocarEntidad(jinete3, pjinete3);
       tablero.colocarEntidad(jinete4, pjinete4);
       tablero.colocarEntidad(jinete5, pjinete5);
       tablero.colocarEntidad(jinete6, pjinete6);

      /* Ataque un jinete enemigo */
       catapulta.atacar(tablero.obtenerCasillero(pjinete1), tablero, Faccion.ALIADOS);

       assertTrue(jinete1.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
       assertTrue(jinete2.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
       assertTrue(jinete3.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
       assertTrue(jinete4.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
       assertTrue(jinete5.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
       assertTrue(jinete6.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
       assertTrue(soldado1.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
       assertTrue(soldado2.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
       assertTrue(soldado3.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
       assertTrue(soldado4.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
       assertTrue(soldado5.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
       assertTrue(soldado6.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
       assertTrue(soldado7.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));

    }
}
