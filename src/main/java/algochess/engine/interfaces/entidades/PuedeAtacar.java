package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;

public interface PuedeAtacar extends PuedeSerHerida {
    void atacar(Casillero casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion);
}
