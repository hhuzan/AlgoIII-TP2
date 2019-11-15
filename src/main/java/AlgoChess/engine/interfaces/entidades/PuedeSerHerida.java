package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.tablero.Tablero;

public interface PuedeSerHerida {
    void disminuirVida(double cantidad, Faccion faccionQueDania, Tablero tablero);

    void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Tablero tablero);

    boolean sosAmigo(Faccion unaFaccion);

    boolean sosEnemigo(Faccion unaFaccion);
}
