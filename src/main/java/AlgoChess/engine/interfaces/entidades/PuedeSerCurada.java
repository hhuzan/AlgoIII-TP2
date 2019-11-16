package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;

public interface PuedeSerCurada extends PuedeSerHerida{
    void aumentarVida(int cantidad, Faccion faccionQueCura);
}
