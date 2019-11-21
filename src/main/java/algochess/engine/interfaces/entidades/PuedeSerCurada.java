package algochess.engine.interfaces.entidades;

import algochess.engine.facciones.Faccion;

public interface PuedeSerCurada extends PuedeSerHerida{
    void aumentarVida(int cantidad, Faccion faccionQueCura);
}
