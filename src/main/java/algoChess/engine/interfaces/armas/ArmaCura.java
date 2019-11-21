package algoChess.engine.interfaces.armas;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;

public interface ArmaCura {
    void curar(Posicion origen, Recuadro casilleroCurado, Faccion faccion);
}
