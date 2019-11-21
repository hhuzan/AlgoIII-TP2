package algoChess.engine.entidades.armas;

import algoChess.engine.entidades.armas.rangos.Cercano;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.armas.ArmaAtaca;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;
import static algoChess.engine.Constantes.DAGA_PODER;

public class Daga extends Arma implements ArmaAtaca {

    public Daga() {
        super(DAGA_PODER, new Cercano());
    }

    @Override
    public void atacar(Posicion posicion, Recuadro casilleroAtacado, Faccion faccionEntidad, Tablero tablero) {
        if (getRango().casilleroEstaEnRango(casilleroAtacado, posicion)) {
            casilleroAtacado.infligirDanioEnEntidad(getPower(), faccionEntidad, tablero);
        }
    }
}
