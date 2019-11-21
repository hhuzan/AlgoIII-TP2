package algoChess.engine.entidades.armas;

import algoChess.engine.entidades.armas.rangos.Rango;

abstract class Arma {
    private int power;
    private Rango rango;


    public Arma(int power_, Rango rango_) {
        power = power_;
        rango = rango_;
    }

    Rango getRango() {
        return rango;
    }

    int getPower() {
        return power;
    }
}
