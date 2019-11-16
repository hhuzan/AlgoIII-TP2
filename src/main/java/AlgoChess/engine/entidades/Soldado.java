package AlgoChess.engine.entidades;

import AlgoChess.engine.comandante.Comandante;
import AlgoChess.engine.entidades.armas.Espada;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaAtaca;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.*;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.engine.jugador.Jugador;

import java.util.HashSet;
import java.util.Queue;

import static AlgoChess.engine.Constantes.SOLDADO_COSTO;
import static AlgoChess.engine.Constantes.SOLDADO_VIDA;

public class Soldado extends Entidad implements PuedeAtacar, PuedeMoverse, PuedeSerCurada, PuedeSerHerida, PuedeFormarBatallon {
    private ArmaAtaca arma;

    public Soldado() {
        super(SOLDADO_VIDA, SOLDADO_COSTO);
        arma = new Espada();
    }

    public Soldado(Jugador propietario, Faccion faccion) {
        super(SOLDADO_VIDA, SOLDADO_COSTO, propietario, faccion);
        arma = new Espada();
    }

    private void verificarMuerte(Tablero tablero, Jugador propietario) {
        if(estoyMuerto()) {
            tablero.colocarVacio(getPosicion());
            propietario.removerEntidad(this);
        }
    }

    @Override
    public Soldado clonar() {
        return new Soldado();
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
        if (sosAmigo(faccionQueCura)) {getVida().aumentar(cantidad);}
    }

    @Override
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Tablero tablero) {
        if (sosEnemigo(faccionQueDania)) 
            getVida().disminuir(cantidad);
        else 
            throw new EntidadDeMismaFaccionException();

        verificarMuerte(tablero, getPropietario());
    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Tablero tablero) {
        getVida().disminuir(cantidad);
        verificarMuerte(tablero, getPropietario());
    }

    @Override
    public void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion) {
        if (sosAmigo(ordenDeFaccion)) 
            arma.atacar(getPosicion(), casilleroAtacado, getFaccion(), tablero);

    }

    @Override
    public boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        if (sosEnemigo(faccionJugador)) { return false; }
        Comandante comandante = new Comandante(tablero);
        comandante.recluteMisCercanos(this);
        boolean batallonSeMovio = comandante.moverBatallon(casillero,this);
        if (!batallonSeMovio) {return casillero.recibirEntidad(this, tablero);
        }else{return false;}

    }


    @Override
    public void reclutarParaBatallon(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {
        if (somosIdenticos(entidad)) {
            reclutados.add(this);
            cola.add(getPosicion());
        }
    }

    @Override
    public boolean moverComoRecluta(Tablero tablero, Recuadro casillero) {
        return casillero.recibirEntidad(this, tablero);
    }

    private boolean somosIdenticos(PuedeFormarBatallon entidad) {
        boolean mismaFaccion = entidad.sosAmigo(getFaccion());
        boolean mismaClase = entidad.getClass() == getClass();
        return (mismaClase && mismaFaccion);
    }

}
