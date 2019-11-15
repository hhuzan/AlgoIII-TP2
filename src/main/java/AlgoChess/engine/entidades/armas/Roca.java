package AlgoChess.engine.entidades.armas;

import AlgoChess.engine.entidades.armas.rangos.Largo;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaAtaca;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;

import static AlgoChess.engine.Constantes.ROCA_PODER;

public class Roca extends Arma implements ArmaAtaca {

    public Roca() {
        super(ROCA_PODER, new Largo());
    }

    @Override
    public void atacar(Posicion posicion, Recuadro casilleroAtacado, Faccion faccionEntidad, Tablero tablero) {
        if (getRango().casilleroEstaEnRango(casilleroAtacado, posicion)) {
            casilleroAtacado.infigirDanioEnEntidadIgnorandoFaccionAtacante(getPower(), tablero);
        }

    }
}
