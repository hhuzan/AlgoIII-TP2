package AlgoChess;

import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;
import org.junit.Test;

public class BatallonTest {

    @Test
    public void test01() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1,2);
        Posicion pos3 = new Posicion(1,3);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(2,1);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
    }

    @Test
    public void test02() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,5);
        Posicion pos2 = new Posicion(2,5);
        Posicion pos3 = new Posicion(3,5);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(1,6);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
    }

    @Test
    public void test03() {
        Faccion faccion = new Faccion();
        Tablero tablero = new Tablero(faccion,faccion);

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        soldado1.setFaccion(faccion);
        soldado2.setFaccion(faccion);
        soldado3.setFaccion(faccion);

        Posicion pos1 = new Posicion(1,5);
        Posicion pos2 = new Posicion(2,5);
        Posicion pos3 = new Posicion(3,5);

        tablero.colocarEntidad(soldado1,pos1);
        tablero.colocarEntidad(soldado2,pos2);
        tablero.colocarEntidad(soldado3,pos3);

        Posicion posDestino = new Posicion(0,6);
        Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
    }

    // TODO: Este test falla
    // @Test
    // public void test04() {
    //     Faccion faccion = new Faccion();
    //     Tablero tablero = new Tablero(faccion,faccion);

    //     Soldado soldado1 = new Soldado();
    //     Soldado soldado2 = new Soldado();
    //     Soldado soldado3 = new Soldado();
    //     soldado1.setFaccion(faccion);
    //     soldado2.setFaccion(faccion);
    //     soldado3.setFaccion(faccion);

    //     Posicion pos1 = new Posicion(2,5);
    //     Posicion pos2 = new Posicion(3,5);
    //     Posicion pos3 = new Posicion(4,5);

    //     tablero.colocarEntidad(soldado1,pos1);
    //     tablero.colocarEntidad(soldado2,pos2);
    //     tablero.colocarEntidad(soldado3,pos3);

    //     Posicion posDestino = new Posicion(1,5);
    //     Recuadro casilleroDestino = tablero.obtenerCasillero(posDestino);

    //     soldado1.moverA(tablero,casilleroDestino,faccion);
    // }
}
