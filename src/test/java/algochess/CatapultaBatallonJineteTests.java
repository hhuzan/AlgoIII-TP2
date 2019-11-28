package algochess;

import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Turno;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import org.junit.Test;

public class CatapultaBatallonJineteTests {

    /*Por si les sirve algunos tests*/
    /*No estan automatizados (los últimos tests si están automatizados), estos tests los corria, e imprimia por
    * pantalla lo que se estaba haciendoy lo corroboraba a papel. En los tests de batallon, para automatizarlos
    * se debería corroborar que, dependiendo de como se mueva el batallon, los casilleros quedan vacios/ocupados */
    @Test
    public void testBasura0001() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(1,2);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(1,3);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,Faccion.ALIADOS);
    }

    @Test
    public void testBasura0002() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(1,2);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(1,1);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,Faccion.ALIADOS);
    }

    @Test
    public void testBasura0003() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,3);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(1,2);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,Faccion.ALIADOS);
    }


    @Test
    public void testBasura0004() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,3);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(4,4);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado3.moverA(tablero,casilleroDestino,Faccion.ALIADOS);
    }

    @Test
    public void testBasura0005() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(1,2);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(2,3);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,Faccion.ALIADOS);

    }

    @Test
    public void testBasura0006() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(3,3);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(2,1);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,Faccion.ALIADOS);
        /*
         * Te tira soldados en 21|43|32|
         * */
    }

    @Test
    public void testBasura0007() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(2,0);
        Posicion pos2 = new Posicion(2,1);
        Posicion pos3 = new Posicion(2,2);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(2,3);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado3.moverA(tablero,casilleroDestino,Faccion.ALIADOS);

    }

    @Test
    public void testBasura0008() {
        Tablero tablero = new Tablero();

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(Faccion.ALIADOS);
        soldado2.setFaccion(Faccion.ALIADOS);
        soldado3.setFaccion(Faccion.ALIADOS);

        Posicion pos1 = new Posicion(2,1);
        Posicion pos2 = new Posicion(3,1);
        Posicion pos3 = new Posicion(3,2);

        tablero.colocarEntidad(soldado1,pos1, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado2,pos2, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));
        tablero.colocarEntidad(soldado3,pos3, new Turno(Faccion.ALIADOS), new Jugador(Faccion.ALIADOS, "Lucas"));

        Posicion posDestino = new Posicion(4,2);
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado2.moverA(tablero,casilleroDestino,Faccion.ALIADOS);

    }

    // @Test
    // public void testBasura0009() {
    //     Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);

    //     Soldado soldado1 = new Soldado();
    //     Soldado soldado2 = new Soldado();
    //     Soldado soldado3 = new Soldado();

    //     soldado1.setFaccion(Faccion.ALIADOS);
    //     soldado2.setFaccion(Faccion.ALIADOS);
    //     soldado3.setFaccion(Faccion.ALIADOS);


    //     Posicion pos1 = new Posicion(2,1);
    //     Posicion pos2 = new Posicion(3,1);
    //     Posicion pos3 = new Posicion(3,2);

    //     tablero.colocarEntidad(soldado1,pos1);
    //     tablero.colocarEntidad(soldado2,pos2);
    //     tablero.colocarEntidad(soldado3,pos3);

    //     Posicion posDestino = new Posicion(4,2);
    //     Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);

    //     soldado2.moverA(tablero,casilleroDestino,Faccion.ALIADOS);

    //     Posicion posTest1 = new Posicion(2,1);
    //     Posicion posTest3 = new Posicion(2,2);
    //     Posicion posTest2 = new Posicion(2,3);
    //     Posicion posTest4 = new Posicion(3,3);
    //     Posicion posTest5 = new Posicion(3,1);
    //     Posicion posTest6 = new Posicion(4,1);
    //     Posicion posTest7 = new Posicion(5,1);
    //     Posicion posTest8 = new Posicion(5,2);
    //     Posicion posTest9 = new Posicion(5,3);


    //     Casillero casillero1 = tablero.obtenerCasillero(posTest1);
    //     Casillero casillero2 = tablero.obtenerCasillero(posTest2);
    //     Casillero casillero3 = tablero.obtenerCasillero(posTest3);
    //     Casillero casillero4 = tablero.obtenerCasillero(posTest4);
    //     Casillero casillero5 = tablero.obtenerCasillero(posTest5);
    //     Casillero casillero6 = tablero.obtenerCasillero(posTest6);
    //     Casillero casillero7 = tablero.obtenerCasillero(posTest7);
    //     Casillero casillero8 = tablero.obtenerCasillero(posTest8);
    //     Casillero casillero9 = tablero.obtenerCasillero(posTest9);

    //     assertSame(casillero1.getClass(), Vacio.class);
    //     assertSame(casillero2.getClass(), Vacio.class);
    //     assertSame(casillero3.getClass(), Vacio.class);
    //     assertSame(casillero4.getClass(), Vacio.class);
    //     assertSame(casillero5.getClass(), Vacio.class);
    //     assertSame(casillero6.getClass(), Vacio.class);
    //     assertSame(casillero7.getClass(), Vacio.class);
    //     assertSame(casillero8.getClass(), Vacio.class);
    //     assertSame(casillero9.getClass(), Vacio.class);

    // }


    // @Test
    // public void TestBasura0013() {
    //     Faccion faccion = new Faccion();
    //     Tablero tablero = new Tablero(faccion,faccion);

    //     Soldado soldado1 = new Soldado();
    //     Soldado soldado2 = new Soldado();
    //     soldado1.setFaccion(faccion);
    //     soldado2.setFaccion(faccion);

    //     Posicion pos1 = new Posicion(1,1);
    //     Posicion pos2 = new Posicion(2,2);

    //     tablero.colocarEntidad(soldado1,pos1);
    //     tablero.colocarEntidad(soldado2,pos2);

    //     Casillero casilleroDestino = tablero.obtenerCasillero(pos2);

    //     soldado1.moverA(tablero,casilleroDestino,faccion);

    // }


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
