package algoChess.engine.interfaces.armas;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;

public interface ArmaAtaca {
    void atacar(Posicion posicion, Recuadro casilleroAtacado, Faccion faccionEntidad, Tablero tablero);
}
