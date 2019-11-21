package algochess.engine.tablero;

import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.posicion.Posicion;

public abstract class Casillero implements Recuadro {
    private Posicion posicion;
    private Faccion faccion;

    Casillero(Posicion posicion_, Faccion faccion_) {
        posicion = posicion_;
        faccion = faccion_;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public Faccion getFaccion() {
        return faccion;
	}

}
