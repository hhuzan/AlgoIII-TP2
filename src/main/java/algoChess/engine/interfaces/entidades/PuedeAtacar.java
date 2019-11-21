package algoChess.engine.interfaces.entidades;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.tablero.Tablero;

public interface PuedeAtacar extends PuedeSerHerida {
    void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion);
}
