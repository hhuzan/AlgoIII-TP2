package AlgoChess.engine.interfaces.entidades;

import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;

import java.util.HashSet;
import java.util.Queue;

public interface PuedeFormarBatallon extends PuedeSerHerida {
    void reclutarParaBatallon(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad);

    //Posicion getPosicion();

    //boolean sosAmigo(Faccion unaFaccion);

    boolean moverComoRecluta(Tablero tablero, Recuadro casillero);

}
