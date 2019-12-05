package algochess.engine.interfaces.casillero;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Casillero;
import algochess.engine.juego.Juego;

import java.util.HashSet;
import java.util.Queue;

public interface Estado {

    boolean recibirEntidad(Entidad entidad, Casillero casillero, Posicion posicionCasillero);

    boolean colocarEntidad(Entidad entidad, Casillero casillero, Faccion faccionCasillero, Posicion posicionCasillero);

    void atacar(Casillero casilleroAtacado, Tablero tablero, Faccion faccionJugador);

    void curar(Casillero casilleroCurado, Tablero tablero, Faccion faccionJugador);

    void moverEntidad(Tablero tablero, Casillero origen, Casillero destino, Faccion faccionJugador);

    void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad);

    void infligirCuracionEnEntidad(int power, Faccion faccion);

    void infligirDanioEnEntidad(int power, Faccion faccionCasillero, Faccion faccionEntidad, Casillero casillero);

    void infigirDanioEnEntidadIgnorandoFaccionAtacante(int power, Faccion faccionCasillero, Casillero casillero);

    boolean esSoldadoAmigo(Faccion faccion);

    boolean poseesUnidad();
    
    Entidad getEntidad();  //TODO sacar

    Entidad seleccionarEntidad(Juego juego);

    boolean enRangoMovimiento(Posicion posicion, Casillero destino);

    boolean isOcupado();
}
