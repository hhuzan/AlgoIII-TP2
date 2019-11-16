package AlgoChess;

import AlgoChess.engine.entidades.Catapulta;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;

import static AlgoChess.engine.Constantes.*;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import AlgoChess.engine.tablero.Vacio;
import org.junit.Test;

public class CatapultaBatallonJineteTests {

    /*Por si les sirve algunos tests*/
    /*No estan automatizados (los últimos tests si están automatizados), estos tests los corria, e imprimia por
    * pantalla lo que se estaba haciendoy lo corroboraba a papel. En los tests de batallon, para automatizarlos
    * se debería corroborar que, dependiendo de como se mueva el batallon, los casilleros quedan vacios/ocupados */
    @Test
    public void TestBasura0001() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,2);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(1,3);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
    }

    @Test
    public void TestBasura0002() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,2);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(1,1);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
    }

    @Test
    public void TestBasura0003() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,3);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(1,2);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
    }


    @Test
    public void TestBasura0004() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,3);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(4,4);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado3.moverA(tablero,casilleroDestino,faccion);
    }

    @Test
    public void TestBasura0005() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,2);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(2,3);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);

    }

    @Test
    public void TestBasura0006() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,3);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(2,1);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
        /*
         * Te tira soldados en 21|43|32|
         * */
    }

    @Test
    public void TestBasura0007() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(2,0);
        Posicion pos2 = new Posicion(2,1);
        Posicion pos3 = new Posicion(2,2);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(2,3);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado3.moverA(tablero,casilleroDestino,faccion);

    }

    @Test
    public void TestBasura0008() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(2,1);
        Posicion pos2 = new Posicion(3,1);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(4,2);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado2.moverA(tablero,casilleroDestino,faccion);

    }

    @Test
    public void TestBasura0009() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();

        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);


        Posicion pos1 = new Posicion(2,1);
        Posicion pos2 = new Posicion(3,1);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(4,2);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado2.moverA(tablero,casilleroDestino,faccion);

        Posicion posTest1 = new Posicion(2,1);
        Posicion posTest3 = new Posicion(2,2);
        Posicion posTest2 = new Posicion(2,3);
        Posicion posTest4 = new Posicion(3,3);
        Posicion posTest5 = new Posicion(3,1);
        Posicion posTest6 = new Posicion(4,1);
        Posicion posTest7 = new Posicion(5,1);
        Posicion posTest8 = new Posicion(5,2);
        Posicion posTest9 = new Posicion(5,3);


        Recuadro casillero1 = tablero.obtenerCasillero(posTest1);
        Recuadro casillero2 = tablero.obtenerCasillero(posTest2);
        Recuadro casillero3 = tablero.obtenerCasillero(posTest3);
        Recuadro casillero4 = tablero.obtenerCasillero(posTest4);
        Recuadro casillero5 = tablero.obtenerCasillero(posTest5);
        Recuadro casillero6 = tablero.obtenerCasillero(posTest6);
        Recuadro casillero7 = tablero.obtenerCasillero(posTest7);
        Recuadro casillero8 = tablero.obtenerCasillero(posTest8);
        Recuadro casillero9 = tablero.obtenerCasillero(posTest9);

        assertSame(casillero1.getClass(), Vacio.class);
        assertSame(casillero2.getClass(), Vacio.class);
        assertSame(casillero3.getClass(), Vacio.class);
        assertSame(casillero4.getClass(), Vacio.class);
        assertSame(casillero5.getClass(), Vacio.class);
        assertSame(casillero6.getClass(), Vacio.class);
        assertSame(casillero7.getClass(), Vacio.class);
        assertSame(casillero8.getClass(), Vacio.class);
        assertSame(casillero9.getClass(), Vacio.class);

    }

    @Test
    public void Test0010(){
        //Aqui pongo un jinete y una catapulta enemiga cercana para que la ataque.
        //Deberia usar su daga.
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Tablero tablero = new Tablero(faccion1,faccion2);

        Jinete jinete = new Jinete();
        jinete.setFaccion(faccion1);
        Posicion posJinete = new Posicion(9,10);


        Catapulta catapulta = new Catapulta();
        catapulta.setFaccion(faccion2);
        Posicion posCatapulta = new Posicion(10,10);

        tablero.colocarEntidad(jinete,posJinete);
        tablero.colocarEntidad(catapulta,posCatapulta);

        tablero.atacarCasillero(posJinete,posCatapulta,faccion1);

        assertTrue(catapulta.tenesEstaVida(CATAPULTA_VIDA-DAGA_PODER));
    }

    @Test
    public void Test0011(){
        // Aqui pongo un jinete
        // una catapulta1 enemiga distancia cercana (del jinete)
        // una catapulta2 enemiga distancia mediana (del jinete)
        // El jinete no debería poder atacar la catapulta2.

        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Tablero tablero = new Tablero(faccion1,faccion2);

        Jinete jinete = new Jinete();
        jinete.setFaccion(faccion1);
        Posicion posJinete = new Posicion(9,10);


        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();
        catapulta1.setFaccion(faccion2);
        catapulta2.setFaccion(faccion2);
        Posicion posCatapulta1 = new Posicion(10,10);
        Posicion posCatapulta2 = new Posicion(12,10);

        tablero.colocarEntidad(jinete,posJinete);
        tablero.colocarEntidad(catapulta1,posCatapulta1);
        tablero.colocarEntidad(catapulta2,posCatapulta2);

        tablero.atacarCasillero(posJinete,posCatapulta2,faccion1);

        assertTrue(catapulta2.tenesEstaVida(CATAPULTA_VIDA));
    }

    @Test
    public void Test0012(){
        // Pongo 5 unidades contiguas (enemigas y aliadas)
        // Una catapulta ataca a una de ellas, y debería poder bajarle vida a todas.

        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Tablero tablero = new Tablero(faccion1,faccion2);

        /*Catapulta*/
        Catapulta catapulta = new Catapulta();
        catapulta.setFaccion(faccion1);
        Posicion pcatapulta = new Posicion(0,10);
        tablero.colocarEntidad(catapulta,pcatapulta);

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
        soldado1.setFaccion(faccion1);
        soldado2.setFaccion(faccion1);
        soldado3.setFaccion(faccion1);
        soldado4.setFaccion(faccion1);
        soldado5.setFaccion(faccion1);
        soldado6.setFaccion(faccion1);
        soldado7.setFaccion(faccion1);

        /*Jinetes f2*/
        jinete1.setFaccion(faccion2);
        jinete2.setFaccion(faccion2);
        jinete3.setFaccion(faccion2);
        jinete4.setFaccion(faccion2);
        jinete5.setFaccion(faccion2);
        jinete6.setFaccion(faccion2);

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

        /*Ataque un jinete enemigo*/
        tablero.atacarCasillero(pcatapulta,new Posicion(10,10),faccion1);

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



    /*
    ---------------------------------------
     0,0  |  0,1  |  0,2  |  0,3  |  0,4
    ---------------------------------------
     1,0  |  1,1  |  1,2  |  1,3  |  1,4
    ---------------------------------------
     2,0  |  2,1  |  2,2  |  2,3  |  2,4
    ---------------------------------------
     3,0  |  3,1  |  3,2  |  3,3  |  3,4
    ---------------------------------------
     4,0  |  4,1  |  4,2  |  4,3  |  4,4
    ---------------------------------------
     5,0  |  5,1  |  5,2  |  5,3  |  5,4
    ---------------------------------------
     6,0  |  6,1  |  6,2  |  6,3  |  6,4
    ---------------------------------------
    */

}
