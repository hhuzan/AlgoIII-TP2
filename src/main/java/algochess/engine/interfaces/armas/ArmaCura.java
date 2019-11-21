package algochess.engine.interfaces.armas;

import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.posicion.Posicion;

public interface ArmaCura {
    void curar(Posicion origen, Recuadro casilleroCurado, Faccion faccion);
}
