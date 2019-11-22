package algochess.engine.entidades.armas.rangos;

import algochess.engine.tablero.Casillero;
import algochess.engine.matematica.Calculadora;
import algochess.engine.posicion.Posicion;

public abstract class Rango {
    private int distanciaMax;
    private int distanciaMin;

    Rango(int distanciaMin_, int distanciaMax_) {
        distanciaMin = distanciaMin_;
        distanciaMax = distanciaMax_;
    }


    public boolean casilleroEstaEnRango(Casillero casilleroTarget, Posicion origen) {
        Calculadora calculadora = new Calculadora();

        int x1 = origen.getColumna();
        int y1 = origen.getFila();
        int x2 = casilleroTarget.getPosicion().getColumna();
        int y2 = casilleroTarget.getPosicion().getFila();

        return calculadora.distanciaValidaEntreDosPosiciones(x1, y1, x2, y2, distanciaMin, distanciaMax);

    }

}

