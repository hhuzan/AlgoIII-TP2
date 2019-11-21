package algochess.engine.entidades.armas.rangos;

import static algochess.engine.Constantes.RANGO_CERCANO_MAXIMO;
import static algochess.engine.Constantes.RANGO_CERCANO_MINIMO;

public class Cercano extends Rango {
    public Cercano() {
        super(RANGO_CERCANO_MINIMO, RANGO_CERCANO_MAXIMO);
    }

}
