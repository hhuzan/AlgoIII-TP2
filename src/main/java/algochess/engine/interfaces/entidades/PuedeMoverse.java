package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;

public interface PuedeMoverse extends PuedeSerHerida{
    boolean moverA(Tablero tablero, Casillero casillero, Faccion faccionJugador);
}
