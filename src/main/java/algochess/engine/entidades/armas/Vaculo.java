package algochess.engine.entidades.armas;

import algochess.engine.entidades.armas.rangos.Cercano;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaCura;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.posicion.Posicion;
import static algochess.engine.Constantes.VACULO_PODER;

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
