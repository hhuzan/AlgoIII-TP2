package algochess.engine.entidades.armas;

import algochess.engine.entidades.armas.rangos.Rango;

abstract class Arma {
    private int power;
    private Rango rango;


    public Arma(int power_, Rango rango_) {
        power = power_;
        rango = rango_;
    }

    public Rango getRango() {
        return rango;
    }

    public int getPower() {
        return power;
    }
}
