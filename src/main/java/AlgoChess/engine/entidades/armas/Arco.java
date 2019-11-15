package AlgoChess.engine.entidades.armas;

import AlgoChess.engine.entidades.armas.rangos.Medio;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaAtaca;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;

import static AlgoChess.engine.Constantes.ARCO_PODER;

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
