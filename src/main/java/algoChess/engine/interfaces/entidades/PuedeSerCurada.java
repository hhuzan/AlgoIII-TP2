package algoChess.engine.interfaces.entidades;

import algoChess.engine.facciones.Faccion;

public interface PuedeSerCurada extends PuedeSerHerida{
    void aumentarVida(int cantidad, Faccion faccionQueCura);
}
