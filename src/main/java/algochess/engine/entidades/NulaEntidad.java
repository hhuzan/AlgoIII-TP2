package algochess.engine.entidades;

import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.entidades.PuedeAtacar;
import algochess.engine.interfaces.entidades.PuedeCurar;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.interfaces.entidades.PuedeMoverse;
import algochess.engine.interfaces.entidades.PuedeSerCurada;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import java.util.HashSet;
import java.util.Queue;

public class NulaEntidad extends Entidad implements PuedeAtacar, PuedeFormarBatallon, PuedeMoverse, PuedeCurar, PuedeSerHerida, PuedeSerCurada {

    public NulaEntidad() {
        super(0, 0);
    }

    @Override
    public Posicion getPosicion() {
        return new Posicion(0,0);
    }
    
    @Override
    public void atacar(Casillero casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion) {

    }

    @Override
    public void curar(Casillero casilleroCurado, Faccion faccionJugador) {
    }


    @Override
    public boolean moverA(Tablero tablero, Casillero casillero, Faccion faccionJugador) {
        return false;
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
    }

    @Override
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Casillero casillero) {

    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Casillero casilleroCurado) {

    }

    @Override
    public Entidad clonar() {
        return null;
    }

    @Override
    public void reclutarParaBatallon(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {

    }

    @Override
    public boolean sosAmigo(Faccion unaFaccion) {
        return false;
    }

    @Override
    public boolean moverComoRecluta(Tablero tablero, Casillero casillero) {
        return false;
    }

    @Override
    public boolean sosEnemigo(Faccion unaFaccion) {
        return false;
    }
}
