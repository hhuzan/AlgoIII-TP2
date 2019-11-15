package AlgoChess.engine.tablero;

import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeFormarBatallon;
import AlgoChess.engine.posicion.Posicion;

import java.util.HashSet;
import java.util.Queue;

public class Vacio extends Casillero {

    public Vacio(Posicion posicion, Faccion faccion) {
        super(posicion, faccion);
    }

    public Vacio(Recuadro casillero) {
        super(casillero.getPosicion(), casillero.getFaccion());
    }

    public boolean colocarEntidad(Entidad entidad, Tablero tablero) {
        if (entidad.sosAmigo(getFaccion())) {
            recibirEntidad(entidad, tablero);
        }
        return true;
    }

    public boolean recibirEntidad(Entidad entidad, Tablero tablero) {
        Recuadro casillero = new Ocupado(entidad, getPosicion(), getFaccion());
        tablero.cambiarCasillero(casillero);
        return true;
    }


    /*Métodos muertos */
    public void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion faccionJugador) {
    }

    public void curar(Recuadro casilleroCurado, Tablero tablero, Faccion faccionJugador) {
    }

    public void moverEntidad(Tablero tablero, Recuadro destino, Faccion faccionJugador) {
    }

    public void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {
    }

    public void infligirCuracionEnEntidad(int power, Faccion faccion) {
    }

    public void infligirDanioEnEntidad(int power, Faccion faccionEntidad, Tablero tablero) {
    }

    public void infigirDanioEnEntidadIgnorandoFaccionAtacante(int power, Tablero tablero) {
    }

}
