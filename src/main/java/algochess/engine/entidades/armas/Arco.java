package algochess.engine.entidades.armas;

import algochess.engine.entidades.armas.rangos.Medio;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaAtaca;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.EntidadFueraDeAlcanceException;
import static algochess.engine.ConstantesUtils.ARCO_PODER;

public class Arco extends Arma implements ArmaAtaca {

    public Arco() {
        super(ARCO_PODER, new Medio());
    }

    @Override
    public void atacar(Posicion posicion, Casillero casilleroAtacado, Faccion faccionEntidad, Tablero tablero) {
        if (getRango().casilleroEstaEnRango(casilleroAtacado, posicion))
            casilleroAtacado.infligirDanioEnEntidad(getPower(), faccionEntidad);
       	else 
       		throw new EntidadFueraDeAlcanceException();
    }
}
