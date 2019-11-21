package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.tablero.Tablero;

public interface PuedeAtacar extends PuedeSerHerida {
    void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion);
}
