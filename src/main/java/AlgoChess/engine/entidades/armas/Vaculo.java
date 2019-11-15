package AlgoChess.engine.entidades.armas;

import AlgoChess.engine.entidades.armas.rangos.Cercano;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaCura;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;

import static AlgoChess.engine.Constantes.VACULO_PODER;

public class Vaculo extends Arma implements ArmaCura {


    public Vaculo() {
        super(VACULO_PODER, new Cercano());
    }

    @Override
    public void curar(Posicion origen, Recuadro casilleroCurado, Faccion faccion) {
        if (getRango().casilleroEstaEnRango(casilleroCurado, origen)) {
            casilleroCurado.infligirCuracionEnEntidad(getPower(), faccion);
        }
    }
}
