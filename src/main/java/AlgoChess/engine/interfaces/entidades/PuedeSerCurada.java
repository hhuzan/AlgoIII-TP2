package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;

public interface PuedeSerCurada {
    void aumentarVida(int cantidad, Faccion faccionQueCura);
}
