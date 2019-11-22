package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;

public interface PuedeCurar extends PuedeSerHerida{
    void curar(Casillero casilleroCurado, Faccion faccionJugador);
}
