package algoChess.engine.interfaces.casillero;

import algoChess.engine.entidades.Entidad;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.entidades.PuedeFormarBatallon;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;
import java.util.HashSet;
import java.util.Queue;

public interface Recuadro {
    Posicion getPosicion();

    Faccion getFaccion();

    boolean recibirEntidad(Entidad entidad, Tablero tablero);

    boolean colocarEntidad(Entidad entidad, Tablero tablero);

    void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion faccionJugador);

    void curar(Recuadro casilleroCurado, Tablero tablero, Faccion faccionJugador);

    void moverEntidad(Tablero tablero, Recuadro destino, Faccion faccionJugador);

    void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad);

    void infligirCuracionEnEntidad(int power, Faccion faccion);

    void infligirDanioEnEntidad(int power, Faccion faccionEntidad, Tablero tablero);

    void infigirDanioEnEntidadIgnorandoFaccionAtacante(int power, Tablero tablero);

    boolean esSoldadoAmigo(Faccion faccion);

    boolean poseesUnidad();
}
