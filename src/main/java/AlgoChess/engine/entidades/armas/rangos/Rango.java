package AlgoChess.engine.entidades.armas.rangos;

import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.matematica.Calculadora;
import AlgoChess.engine.posicion.Posicion;

public abstract class Rango {
    private int distanciaMax;
    private int distanciaMin;

    Rango(int distanciaMin_, int distanciaMax_) {
        distanciaMin = distanciaMin_;
        distanciaMax = distanciaMax_;
    }


    public boolean casilleroEstaEnRango(Recuadro casilleroTarget, Posicion origen) {
        Calculadora calculadora = new Calculadora();

        int x1, y1, x2, y2;

        x1 = origen.getColumna();
        y1 = origen.getFila();
        x2 = casilleroTarget.getPosicion().getColumna();
        y2 = casilleroTarget.getPosicion().getFila();

        return calculadora.distanciaValidaEntreDosPosiciones(x1, y1, x2, y2, distanciaMin, distanciaMax);

    }

}

