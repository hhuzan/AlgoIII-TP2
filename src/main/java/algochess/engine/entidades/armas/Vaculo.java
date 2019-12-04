package algochess.engine.entidades.armas;

import algochess.engine.entidades.armas.rangos.Cercano;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaCura;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.excepciones.EntidadFueraDeAlcanceException;
import static algochess.engine.ConstantesUtils.VACULO_PODER;

public class Vaculo extends Arma implements ArmaCura {


    public Vaculo() {
        super(VACULO_PODER, new Cercano());
    }

    @Override
    public void curar(Posicion origen, Casillero casilleroCurado, Faccion faccion) {
        if (getRango().casilleroEstaEnRango(casilleroCurado, origen)) 
            casilleroCurado.infligirCuracionEnEntidad(getPower(), faccion);
        else
            throw new EntidadFueraDeAlcanceException();
    }
}
