package algochess.engine.interfaces.armas;

import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;

public interface ArmaAtaca {
    void atacar(Posicion posicion, Recuadro casilleroAtacado, Faccion faccionEntidad, Tablero tablero);
}
