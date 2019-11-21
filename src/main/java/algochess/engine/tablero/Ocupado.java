package algochess.engine.tablero;

import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.NulaEntidad;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.interfaces.entidades.*;
import algochess.engine.posicion.Posicion;
import algochess.excepciones.CasilleroOcupadoException;
import java.util.HashSet;
import java.util.Queue;

public class Ocupado extends Casillero {
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

    @Override
    public boolean esSoldadoAmigo(Faccion faccion) {
        //Los soldados siempre pueden ser heridos.
        return Soldado.class == puedeSerHerida.getClass() && puedeSerHerida.sosAmigo(faccion);
    }

    @Override
    public boolean poseesUnidad() {
        return puedeSerHerida.getClass() != NulaEntidad.class;
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
            puedeSerHerida.disminuirVidaIgnorandoFaccionAtacante(power*(1.05), tablero);
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
        if (puedeMoverse.moverA(tablero, casillero, faccionJugador)) {
            tablero.colocarVacio(getPosicion());
        }
    }

    public void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidadOrigen) {
        puedeFormarBatallon.reclutarParaBatallon(reclutados, cola, entidadOrigen);
    }


    public boolean recibirEntidad(Entidad entidad, Tablero tablero) {
        throw new CasilleroOcupadoException();
    }

    public boolean colocarEntidad(Entidad entidad, Tablero tablero) {
        throw new CasilleroOcupadoException();
    }

}
