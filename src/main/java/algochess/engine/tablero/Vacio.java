package algochess.engine.tablero;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.posicion.Posicion;
import algochess.excepciones.ColocarEntidadException;
import algochess.excepciones.CasilleroVacioException;
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
        if (entidad.sosAmigo(getFaccion())) 
            recibirEntidad(entidad, tablero);
        else
            throw new ColocarEntidadException();

        return true;
    }

    public boolean recibirEntidad(Entidad entidad, Tablero tablero) {
        Recuadro casillero = new Ocupado(entidad, getPosicion(), getFaccion());
        tablero.cambiarCasillero(casillero);
        return true;
    }


    /*Métodos muertos */
    public void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion faccionJugador) {
        throw new CasilleroVacioException();
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

    @Override
    public boolean esSoldadoAmigo(Faccion faccion) {
        return false;
    }

    @Override
    public boolean poseesUnidad() {
        return false;
    }

}
