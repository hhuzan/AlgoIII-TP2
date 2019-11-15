package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.tablero.Tablero;

public interface PuedeMoverse {
    boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador);
}
