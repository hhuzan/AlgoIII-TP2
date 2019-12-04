package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Casillero;


public interface PuedeSerHerida {
    void disminuirVida(double cantidad, Faccion faccionQueDania, Casillero casillero);

    void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Casillero casillero);

    boolean sosAmigo(Faccion unaFaccion);


    Posicion getPosicion();

}
