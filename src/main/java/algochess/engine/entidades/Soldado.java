package algochess.engine.entidades;

import algochess.engine.comandante.Comandante;
import algochess.engine.entidades.armas.Espada;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaAtaca;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.entidades.PuedeAtacar;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.interfaces.entidades.PuedeMoverse;
import algochess.engine.interfaces.entidades.PuedeSerCurada;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Vacio;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.engine.jugador.Jugador;
import java.util.HashSet;
import java.util.Queue;
import static algochess.engine.ConstantesUtils.SOLDADO_COSTO;
import static algochess.engine.ConstantesUtils.SOLDADO_VIDA;

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

    private void verificarMuerte(Casillero casillero, Jugador propietario) {
        if(estoyMuerto()) {
            casillero.cambiarEstado(new Vacio());
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
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Casillero casillero) {
        if (sosEnemigo(faccionQueDania)) 
            getVida().disminuir(cantidad);
        else 
            throw new EntidadDeMismaFaccionException();

        verificarMuerte(casillero, getPropietario());
    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Casillero casillero) {
        getVida().disminuir(cantidad);
        verificarMuerte(casillero, getPropietario());
    }

    @Override
    public void atacar(Casillero casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion) {
        if (sosAmigo(ordenDeFaccion)) 
            arma.atacar(getPosicion(), casilleroAtacado, getFaccion(), tablero);

    }

    @Override
    public boolean moverA(Tablero tablero, Casillero casillero, Faccion faccionJugador) {
        if (sosEnemigo(faccionJugador))
            return false;

        Comandante comandante = new Comandante(tablero);
        comandante.recluteMisCercanos(this);
        boolean batallonSeMovio = comandante.moverBatallon(tablero, casillero, this);
        if (!batallonSeMovio) 
            return casillero.recibirEntidad(this);
        else
            return false;

    }


    @Override
    public void reclutarParaBatallon(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {
        if (somosIdenticos(entidad)) {
            reclutados.add(this);
            cola.add(getPosicion());
        }
    }

    @Override
    public boolean moverComoRecluta(Tablero tablero, Casillero casillero) {
        return casillero.recibirEntidad(this);
    }

    private boolean somosIdenticos(PuedeFormarBatallon entidad) {
        boolean mismaFaccion = entidad.sosAmigo(getFaccion());
        boolean mismaClase = entidad.getClass() == getClass();
        return (mismaClase && mismaFaccion);
    }

}
