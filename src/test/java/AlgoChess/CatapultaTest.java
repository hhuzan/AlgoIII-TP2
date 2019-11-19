package AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.entidades.Catapulta;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;

import AlgoChess.excepciones.CasilleroOcupadoException;
import org.junit.Test;

public class CatapultaTest {

	@Test
	public void test00ConstructorCatapultaNoDevuelveNull() {
		Catapulta catapulta = new Catapulta();
		assertNotNull(catapulta);
	}

	@Test
	public void test01CreamosUnaCatapultaYSuCostoEsElEsperado() {
        VendedorDeEntidades vendedor = new VendedorDeEntidades();
        Jugador jugador = new Jugador(Faccion.ALIADOS, "Pedro");
		Catapulta catapulta = new Catapulta(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        jugador.comprarEntidad(vendedor, catapulta);
        // TODO: Ver como hacer assert para verificar esto
	// assertEquals(DINERO_JUGADOR - CATAPULTA_COSTO, jugador.getDinero());
	}

	@Test
	public void test02AtacamosConUnaCatapultaYElEnemigoRecibeDanio() { 
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        Posicion posOrigen = new Posicion(6,1);
        Posicion posDestino = new Posicion(12,1);

        catapulta.setFaccion(Faccion.ALIADOS);
        jinete.setFaccion(Faccion.ENEMIGOS);

        tablero.colocarEntidad(catapulta, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
        // TODO: Ver como hacer assert para verificar esto
		//assertEquals(jinete.getVida(), JINETE_VIDA - ROCA_PODER);
	}

	@Test
	public void test03AtacamosConUnaCatapultaYElAliadoRecibeDanio() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ALIADOS);

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        catapulta.setFaccion(Faccion.ALIADOS);
        jinete.setFaccion(Faccion.ALIADOS);

        Posicion posOrigen = new Posicion(1,1);
        Posicion posDestino = new Posicion(1,2);

        tablero.colocarEntidad(catapulta, posOrigen);
        tablero.colocarEntidad(jinete, posDestino);

        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
        // TODO: Ver como hacer assert para verificar esto
		//assertEquals(jinete.getVida(), JINETE_VIDA - ROCA_PODER);
	}

	@Test
	public void test04IntentamosMoverUnaCatapultaPeroNoEsUnaEntidadMovible() {
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

	// Test 05: Catapulta falla al atacar a distancia cercana o media
	@Test 
    public void test05CatapultaNoAtacaADistanciaQueNoEsLejana() {
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        catapulta.setFaccion(Faccion.ALIADOS);
        jinete.setFaccion(Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(catapulta, posOrigen);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);
        Recuadro casilleroOrigen = tablero.obtenerCasillero(posOrigen);

        catapulta.atacar(casilleroDestino, tablero, Faccion.ALIADOS);
        // TODO: Assert 
    }

    @Test
    public void Test06CatapultaAtacaAUnidadesContiguasDelCasilleroDeAtaque(){
        // Pongo 5 unidades contiguas (enemigas y aliadas)
        // Una catapulta ataca a una de ellas, y debería poder bajarle vida a todas.

        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        /*Catapulta*/
        Catapulta catapulta = new Catapulta();
        catapulta.setFaccion(Faccion.ALIADOS);
        Posicion pcatapulta = new Posicion(0,10);
        tablero.colocarEntidad(catapulta, pcatapulta);

        /*Creo soldados*/
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Soldado soldado4 = new Soldado();
        Soldado soldado5 = new Soldado();
        Soldado soldado6 = new Soldado();
        Soldado soldado7 = new Soldado();

        /*Creo jinetes*/
        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();
        Jinete jinete3 = new Jinete();
        Jinete jinete4 = new Jinete();
        Jinete jinete5 = new Jinete();
        Jinete jinete6 = new Jinete();

        /*Soldados f1*/
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);
        soldado4.setFaccion(Faccion.ALIADOS);
        soldado5.setFaccion(Faccion.ALIADOS);
        soldado6.setFaccion(Faccion.ALIADOS);
        soldado7.setFaccion(Faccion.ALIADOS);

        /*Jinetes f2*/
        jinete1.setFaccion(Faccion.ENEMIGOS);
        jinete2.setFaccion(Faccion.ENEMIGOS);
        jinete3.setFaccion(Faccion.ENEMIGOS);
        jinete4.setFaccion(Faccion.ENEMIGOS);
        jinete5.setFaccion(Faccion.ENEMIGOS);
        jinete6.setFaccion(Faccion.ENEMIGOS);

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
        tablero.colocarEntidad(soldado1,psoldado1);
        tablero.colocarEntidad(soldado2,psoldado2);
        tablero.colocarEntidad(soldado3,psoldado3);
        tablero.colocarEntidad(soldado4,psoldado4);
        tablero.colocarEntidad(soldado5,psoldado5);
        tablero.colocarEntidad(soldado6,psoldado6);
        tablero.colocarEntidad(soldado7,psoldado7);

        /*Coloco jinetes f2 en tablero*/
        tablero.colocarEntidad(jinete1,pjinete1);
        tablero.colocarEntidad(jinete2,pjinete2);
        tablero.colocarEntidad(jinete3,pjinete3);
        tablero.colocarEntidad(jinete4,pjinete4);
        tablero.colocarEntidad(jinete5,pjinete5);
        tablero.colocarEntidad(jinete6,pjinete6);

        /* Ataque un jinete enemigo */
        catapulta.atacar(tablero.obtenerCasillero(pcatapulta), tablero, Faccion.ALIADOS);

        // TODO: Ver como hacer sin getters
        // assertTrue(jinete1.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
        // assertTrue(jinete2.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
        // assertTrue(jinete3.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
        // assertTrue(jinete4.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
        // assertTrue(jinete5.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
        // assertTrue(jinete6.tenesEstaVida(JINETE_VIDA-ROCA_PODER));
        // assertTrue(soldado1.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
        // assertTrue(soldado2.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
        // assertTrue(soldado3.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
        // assertTrue(soldado4.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
        // assertTrue(soldado5.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
        // assertTrue(soldado6.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));
        // assertTrue(soldado7.tenesEstaVida(SOLDADO_VIDA-ROCA_PODER));

    }
}
