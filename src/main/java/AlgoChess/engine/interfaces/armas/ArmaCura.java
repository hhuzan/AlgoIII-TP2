package AlgoChess.engine.interfaces.armas;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;

public interface ArmaCura {
    void curar(Posicion origen, Recuadro casilleroCurado, Faccion faccion);
}
