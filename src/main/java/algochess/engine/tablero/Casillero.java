package algochess.engine.tablero;

import algochess.engine.facciones.Faccion;
import algochess.engine.posicion.Posicion;
import algochess.engine.entidades.Entidad;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.tablero.Tablero;
import algochess.engine.interfaces.casillero.Estado;
import java.util.HashSet;
import java.util.Queue;

public class Casillero  {
    private Posicion posicion;
    private Faccion faccion;
    private Estado estado;

    public Casillero(Posicion posicion_, Faccion faccion_) {
        posicion = posicion_;
        faccion = faccion_;
        estado = new Vacio();
    }

    public Casillero(Posicion posicion_, Faccion faccion_, Estado estado_) {
        posicion = posicion_;
        faccion = faccion_;
        estado = estado_;
    }

    public Casillero(Posicion posicion_, Faccion faccion_, Entidad entidad) {
        posicion = posicion_;
        faccion = faccion_;
        estado = new Ocupado(entidad, posicion);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public Faccion getFaccion() {
        return faccion;
	}

    public boolean recibirEntidad(Entidad entidad) {
        return estado.recibirEntidad(entidad, this, posicion);
    }

    public boolean colocarEntidad(Entidad entidad) {
        return estado.colocarEntidad(entidad, this, faccion, posicion);
    }

    public void atacar(Casillero atacado, Tablero tablero, Faccion faccionJugador) {
        estado.atacar(atacado, tablero, faccionJugador);
    }

    public void curar(Casillero casilleroCurado, Tablero tablero, Faccion faccionJugador) {
        estado.curar(casilleroCurado, tablero, faccionJugador);
    }

    public void moverEntidad(Tablero tablero, Casillero origen, Casillero destino, Faccion faccionJugador) {
        estado.moverEntidad(tablero, origen, destino, faccionJugador);
    }

    public void infligirCuracionEnEntidad(int power, Faccion faccion) {
        estado.infligirCuracionEnEntidad(power, faccion);
    }

    public void infligirDanioEnEntidad(int power, Faccion faccionEntidad) {
        estado.infligirDanioEnEntidad(power, faccion, faccionEntidad, this);
    }

    public void infigirDanioEnEntidadIgnorandoFaccionAtacante(int power) {
        estado.infigirDanioEnEntidadIgnorandoFaccionAtacante(power, getFaccion(), this);
    }

    public void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {
        estado.reclutarEntidad(reclutados, cola, entidad);
    }

    public boolean esSoldadoAmigo(Faccion faccion) {
        return estado.esSoldadoAmigo(faccion);
    }

    public boolean poseesUnidad() {
        return estado.poseesUnidad();
    }

    public void cambiarEstado(Estado estadoCasillero) {
        estado = estadoCasillero;
    }


}
