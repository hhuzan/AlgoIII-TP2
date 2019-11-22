package algochess.engine.interfaces.armas;

import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;

public interface ArmaAtaca {
    void atacar(Posicion posicion, Casillero casilleroAtacado, Faccion faccionEntidad, Tablero tablero);
}
