package algoChess.engine.entidades.armas;

import algoChess.engine.entidades.armas.rangos.Cercano;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.armas.ArmaCura;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import static algoChess.engine.Constantes.VACULO_PODER;

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
