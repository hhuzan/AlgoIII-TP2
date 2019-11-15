package AlgoChess;

import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.entidades.armas.rangos.Cercano;
import AlgoChess.engine.entidades.armas.rangos.Largo;
import AlgoChess.engine.entidades.armas.rangos.Medio;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.CasilleroVacio;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Ocupado;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Vacio;
import AlgoChess.excepciones.NoMePuedesColocarUnaEntidadEnemigaException;
import org.junit.Test;


public class BasuraTest {
    @Test
    public void Test00(){
        Cercano rango = new Cercano();
        Ocupado ocupado = new Ocupado(new Jinete(),new Posicion(10,10),new Faccion());

        rango.casilleroEstaEnRango(ocupado,new Posicion(10,10));
    }

    @Test
    public void Test01(){
        Medio rango = new Medio();
        Ocupado ocupado = new Ocupado(new Jinete(),new Posicion(10,10),new Faccion());

        rango.casilleroEstaEnRango(ocupado,new Posicion(10,10));
    }

    @Test
    public void Test02(){
        Largo rango = new Largo();
        Ocupado ocupado = new Ocupado(new Jinete(),new Posicion(10,10),new Faccion());

        rango.casilleroEstaEnRango(ocupado,new Posicion(10,10));
    }

    @Test
    public void TestBasura() throws NoMePuedesColocarUnaEntidadEnemigaException {
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
        CasilleroVacio casilleroDestino = (CasilleroVacio) tablero.obtenerCasillero(posDestino);

        soldado1.moverA(tablero,casilleroDestino,faccion);
    }
    

}
