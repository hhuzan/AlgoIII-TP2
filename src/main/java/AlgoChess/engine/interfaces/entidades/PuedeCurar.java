package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;

public interface PuedeCurar extends PuedeSerHerida{
    void curar(Recuadro casilleroCurado, Faccion faccionJugador);
}
