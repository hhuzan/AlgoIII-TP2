package AlgoChess.engine.tablero;

import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.entidades.NulaEntidad;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.*;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.excepciones.CasilleroOcupadoException;

import java.util.HashSet;
import java.util.Queue;

public class Ocupado extends Casillero implements Recuadro {
    private PuedeAtacar puedeAtacar;
    private PuedeCurar puedeCurar;
    private PuedeFormarBatallon puedeFormarBatallon;
    private PuedeMoverse puedeMoverse;
    private PuedeSerCurada puedeSerCurada;
    private PuedeSerHerida puedeSerHerida;


    public Ocupado(Entidad entidad, Posicion posicion, Faccion faccion) {
        super(posicion, faccion);

        if (entidad instanceof PuedeAtacar) puedeAtacar = (PuedeAtacar) entidad;
        else {
            puedeAtacar = new NulaEntidad();
        }

        if (entidad instanceof PuedeCurar) puedeCurar = (PuedeCurar) entidad;
        else {
            puedeCurar = new NulaEntidad();
        }

        if (entidad instanceof PuedeFormarBatallon) puedeFormarBatallon = (PuedeFormarBatallon) entidad;
        else {
            puedeFormarBatallon = new NulaEntidad();
        }

        if (entidad instanceof PuedeMoverse) puedeMoverse = (PuedeMoverse) entidad;
        else {
            puedeMoverse = new NulaEntidad();
        }

        if (entidad instanceof PuedeSerCurada) puedeSerCurada = (PuedeSerCurada) entidad;
        else {
            puedeSerCurada = new NulaEntidad();
        }

        if (entidad instanceof PuedeSerHerida) puedeSerHerida = (PuedeSerHerida) entidad;
        else {
            puedeSerHerida = new NulaEntidad();
        }

        entidad.setPosicion(posicion);
    }

    public boolean tienesLaEntidad(Entidad entidad) {
        if (entidad == puedeAtacar) return true;
        if (entidad == puedeCurar) return true;
        if (entidad == puedeFormarBatallon) return true;
        if (entidad == puedeMoverse) return true;
        if (entidad == puedeSerCurada) return true;
        return entidad == puedeSerHerida;
    }

    public void infligirDanioEnEntidad(int power, Faccion entidadAtacante, Tablero tablero) {
        if (puedeSerHerida.sosAmigo(getFaccion())) {
            puedeSerHerida.disminuirVida(power, entidadAtacante, tablero);
        } else {
            puedeSerHerida.disminuirVida(power + 0.05 * power, entidadAtacante, tablero);
        }
    }

    public void infigirDanioEnEntidadIgnorandoFaccionAtacante(int power, Tablero tablero) {
        if (puedeSerHerida.sosAmigo(getFaccion())) {
            puedeSerHerida.disminuirVidaIgnorandoFaccionAtacante(power, tablero);
        } else {
            puedeSerHerida.disminuirVidaIgnorandoFaccionAtacante(power + 0.05 * power, tablero);
        }
    }

    public void infligirCuracionEnEntidad(int power, Faccion faccionCuradora) {
        puedeSerCurada.aumentarVida(power, faccionCuradora);
    }

    public void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion faccionJugador) {
        puedeAtacar.atacar(casilleroAtacado, tablero, faccionJugador);
    }

    public void curar(Recuadro casilleroCurado, Tablero tablero, Faccion faccionJugador) {
        puedeCurar.curar(casilleroCurado, faccionJugador);
    }


    public void moverEntidad(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        boolean seMovio = puedeMoverse.moverA(tablero, casillero, faccionJugador);
        if (seMovio) {
            tablero.colocarVacio(getPosicion());
        }
    }

    public void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidadOrigen) {
        puedeFormarBatallon.reclutarParaBatallon(reclutados, cola, entidadOrigen);
    }


    public Vacio removerEntidad() {
        return new Vacio(this);
    }

    public boolean recibirEntidad(Entidad entidad, Tablero tablero) {
        throw new CasilleroOcupadoException();
    }

    public boolean colocarEntidad(Entidad entidad, Tablero tablero) {
        throw new CasilleroOcupadoException();
    }

}
