package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.tablero.Tablero;

public interface PuedeAtacar {
    void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion);
}
