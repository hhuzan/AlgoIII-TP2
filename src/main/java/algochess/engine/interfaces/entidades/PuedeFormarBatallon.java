package algochess.engine.interfaces.entidades;

import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import java.util.HashSet;
import java.util.Queue;

public interface PuedeFormarBatallon extends PuedeSerHerida {
    void reclutarParaBatallon(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad);

    //Posicion getPosicion();

    //boolean sosAmigo(Faccion unaFaccion);

    boolean moverComoRecluta(Tablero tablero, Casillero casillero);

}
