package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;

public interface PuedeCurar extends PuedeSerHerida{
    void curar(Recuadro casilleroCurado, Faccion faccionJugador);
}
