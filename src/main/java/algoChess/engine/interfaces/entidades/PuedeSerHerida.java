package algoChess.engine.interfaces.entidades;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;

public interface PuedeSerHerida {
    void disminuirVida(double cantidad, Faccion faccionQueDania, Tablero tablero);

    void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Tablero tablero);

    boolean sosAmigo(Faccion unaFaccion);

    boolean sosEnemigo(Faccion unaFaccion);

    Posicion getPosicion();

}
