package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;

public interface PuedeCurar {
    void curar(Recuadro casilleroCurado, Faccion faccionJugador);
}
