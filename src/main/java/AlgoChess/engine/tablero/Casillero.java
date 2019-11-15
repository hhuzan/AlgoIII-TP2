package AlgoChess.engine.tablero;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;


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
