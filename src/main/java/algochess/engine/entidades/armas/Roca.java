package algochess.engine.entidades.armas;

import algochess.engine.entidades.armas.rangos.Largo;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaAtaca;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import java.util.HashSet;
import static algochess.engine.ConstantesUtils.ROCA_PODER;

public class Roca extends Arma implements ArmaAtaca {

    public Roca() {
        super(ROCA_PODER, new Largo());
    }

    @Override
    public void atacar(Posicion posicion, Casillero casilleroAtacado, Faccion faccionEntidad, Tablero tablero) {
        if (!getRango().casilleroEstaEnRango(casilleroAtacado, posicion)) { return;}

        HashSet<Casillero> casillerosAtacados = new HashSet<>();
        casillerosAtacados.add(casilleroAtacado);

        tablero.colectaUnidadesContiguas(casilleroAtacado.getPosicion(),casillerosAtacados);

        for(Casillero casillero:casillerosAtacados){
            casillero.infigirDanioEnEntidadIgnorandoFaccionAtacante(getPower());
        }



    }
}
