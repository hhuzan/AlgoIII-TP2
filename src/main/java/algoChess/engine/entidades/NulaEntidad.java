package algoChess.engine.entidades;

import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.interfaces.entidades.*;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;
import java.util.HashSet;
import java.util.Queue;

public class NulaEntidad extends Entidad implements PuedeAtacar, PuedeFormarBatallon, PuedeMoverse, PuedeCurar, PuedeSerHerida, PuedeSerCurada {

    public NulaEntidad() {
        super(0, 0);
    }

    @Override
    public void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion) {

    }

    @Override
    public void curar(Recuadro casilleroCurado, Faccion faccionJugador) {
    }


    @Override
    public boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        return false;
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
    }

    @Override
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Tablero tablero) {

    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Tablero tablero) {

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
    public boolean moverComoRecluta(Tablero tablero, Recuadro casillero) {
        return false;
    }

    @Override
    public boolean sosEnemigo(Faccion unaFaccion) {
        return false;
    }
}
