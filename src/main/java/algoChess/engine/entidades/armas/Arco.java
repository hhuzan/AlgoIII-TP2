package algoChess.engine.entidades.armas;

import algoChess.engine.entidades.armas.rangos.Medio;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.armas.ArmaAtaca;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;
import static algoChess.engine.Constantes.ARCO_PODER;

public class Arco extends Arma implements ArmaAtaca {

    public Arco() {
        super(ARCO_PODER, new Medio());
    }

    @Override
    public void atacar(Posicion posicion, Recuadro casilleroAtacado, Faccion faccionEntidad, Tablero tablero) {
        if (getRango().casilleroEstaEnRango(casilleroAtacado, posicion)) {
            casilleroAtacado.infligirDanioEnEntidad(getPower(), faccionEntidad, tablero);
        }
    }
}
