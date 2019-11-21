package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.tablero.Tablero;

public interface PuedeMoverse extends PuedeSerHerida{
    boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador);
}
