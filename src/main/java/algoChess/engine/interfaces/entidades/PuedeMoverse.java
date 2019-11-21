package algoChess.engine.interfaces.entidades;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.tablero.Tablero;

public interface PuedeMoverse extends PuedeSerHerida{
    boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador);
}
