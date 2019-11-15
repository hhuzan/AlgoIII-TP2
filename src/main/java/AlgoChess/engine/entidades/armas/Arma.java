package AlgoChess.engine.entidades.armas;

import AlgoChess.engine.entidades.armas.rangos.Rango;

abstract class Arma {
    private int power;
    private Rango rango;


    Arma(int power_, Rango rango_) {
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
