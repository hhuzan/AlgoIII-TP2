package algochess.engine.tablero;
import java.util.HashMap;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.NulaEntidad;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.interfaces.casillero.ColocarHandler;
import algochess.engine.interfaces.entidades.PuedeAtacar;
import algochess.engine.interfaces.entidades.PuedeCurar;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.interfaces.entidades.PuedeMoverse;
import algochess.engine.interfaces.entidades.PuedeSerCurada;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.posicion.Posicion;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.NulaEntidad;

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

    /* Table-Driven methods */
    private HashMap<Class, ColocarHandler> entidadMap;

    private void initEntidadMap() {
        entidadMap = new HashMap<>();
        entidadMap.put(Jinete.class,    (jinete) -> colocarJinete(jinete));
        entidadMap.put(Catapulta.class, (catapulta) -> colocarCatapulta(catapulta));
        entidadMap.put(Curandero.class, (curandero) -> colocarCurandero(curandero));
        entidadMap.put(Soldado.class,   (soldado) -> colocarSoldado(soldado));

    }

    public Ocupado(Entidad entidad, Posicion posicion, Faccion faccion) {
        super(posicion, faccion);
        this.initEntidadMap();
        ColocarHandler handler = this.entidadMap.get(entidad.getClass());
        handler.colocar(entidad);
        entidad.setPosicion(posicion);
    }

    public void colocarJinete(Entidad jinete) {
        puedeAtacar = (PuedeAtacar) jinete;
        puedeCurar = new NulaEntidad();
        puedeFormarBatallon = new NulaEntidad();
        puedeMoverse = (PuedeMoverse) jinete;
        puedeSerCurada = (PuedeSerCurada) jinete;
        puedeSerHerida = (PuedeSerHerida) jinete;
    }

    public void colocarSoldado(Entidad soldado) {
        puedeAtacar = (PuedeAtacar) soldado;
        puedeCurar = new NulaEntidad();
        puedeFormarBatallon = (PuedeFormarBatallon) soldado;
        puedeMoverse = (PuedeMoverse) soldado;
        puedeSerCurada = (PuedeSerCurada) soldado;
        puedeSerHerida = (PuedeSerHerida) soldado;
    }

    public void colocarCatapulta(Entidad catapulta) {
        puedeAtacar = (PuedeAtacar) catapulta;
        puedeCurar = new NulaEntidad();
        puedeFormarBatallon = new NulaEntidad();
        puedeMoverse = new NulaEntidad();
        puedeSerCurada = new NulaEntidad();
        puedeSerHerida = (PuedeSerHerida) catapulta;
    }

    public void colocarCurandero(Entidad curandero) {
        puedeAtacar = new NulaEntidad();
        puedeCurar = (PuedeCurar) curandero;
        puedeFormarBatallon = new NulaEntidad();
        puedeMoverse = (PuedeMoverse) curandero;
        puedeSerCurada = (PuedeSerCurada) curandero;
        puedeSerHerida = (PuedeSerHerida) curandero;
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
