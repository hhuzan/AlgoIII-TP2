package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;

public interface PuedeSerHerida {
    void disminuirVida(double cantidad, Faccion faccionQueDania, Tablero tablero);

    void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Tablero tablero);

    boolean sosAmigo(Faccion unaFaccion);

    boolean sosEnemigo(Faccion unaFaccion);

    Posicion getPosicion();

}
