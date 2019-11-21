package algoChess.engine.interfaces.entidades;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;

public interface PuedeCurar extends PuedeSerHerida{
    void curar(Recuadro casilleroCurado, Faccion faccionJugador);
}
