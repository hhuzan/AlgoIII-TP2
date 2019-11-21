package algoChess.engine.interfaces.entidades;

import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;
import java.util.HashSet;
import java.util.Queue;

public interface PuedeFormarBatallon extends PuedeSerHerida {
    void reclutarParaBatallon(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad);

    //Posicion getPosicion();

    //boolean sosAmigo(Faccion unaFaccion);

    boolean moverComoRecluta(Tablero tablero, Recuadro casillero);

}
