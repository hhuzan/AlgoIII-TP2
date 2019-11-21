package algoChess.engine.entidades.armas;

import algoChess.engine.entidades.armas.rangos.Largo;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.armas.ArmaAtaca;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;
import java.util.HashSet;
import static algoChess.engine.Constantes.ROCA_PODER;

public class Roca extends Arma implements ArmaAtaca {

    public Roca() {
        super(ROCA_PODER, new Largo());
    }

    @Override
    public void atacar(Posicion posicion, Recuadro casilleroAtacado, Faccion faccionEntidad, Tablero tablero) {
        if (!getRango().casilleroEstaEnRango(casilleroAtacado, posicion)) { return;}

        HashSet<Recuadro> casillerosAtacados = new HashSet<>();
        casillerosAtacados.add(casilleroAtacado);

        tablero.colectaUnidadesContiguas(casilleroAtacado.getPosicion(),casillerosAtacados);

        for(Recuadro casillero:casillerosAtacados){
            casillero.infigirDanioEnEntidadIgnorandoFaccionAtacante(getPower(), tablero);
        }



    }
}
