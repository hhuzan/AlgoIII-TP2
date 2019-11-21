package algoChess.engine.tablero;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;

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
