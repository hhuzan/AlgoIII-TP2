package algochess.engine.interfaces.armas;

import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;

public interface ArmaCura {
    void curar(Posicion origen, Casillero casilleroCurado, Faccion faccion);
}
