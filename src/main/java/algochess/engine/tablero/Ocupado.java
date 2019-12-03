package algochess.engine.tablero;
import java.util.HashMap;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.NulaEntidad;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.casillero.ColocarHandler;
import algochess.engine.interfaces.entidades.PuedeAtacar;
import algochess.engine.interfaces.entidades.PuedeCurar;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.interfaces.entidades.PuedeMoverse;
import algochess.engine.interfaces.entidades.PuedeSerCurada;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.interfaces.casillero.Estado;
import algochess.engine.posicion.Posicion;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.excepciones.CasilleroOcupadoException;
import algochess.engine.juego.Juego;
import java.util.HashSet;
import java.util.Queue;

public class Ocupado implements Estado {
	private Entidad entidad;
    private PuedeAtacar puedeAtacar;
    private PuedeCurar puedeCurar;
    private PuedeFormarBatallon puedeFormarBatallon;
    private PuedeMoverse puedeMoverse;
    private PuedeSerCurada puedeSerCurada;
    private PuedeSerHerida puedeSerHerida;

    /* Table-Driven methods */
    @SuppressWarnings("rawtypes")
	private HashMap<Class, ColocarHandler> entidadMap;

    private void initEntidadMap() {
        entidadMap = new HashMap<>();
        entidadMap.put(Jinete.class,    (jinete) -> colocarJinete(jinete));
        entidadMap.put(Catapulta.class, (catapulta) -> colocarCatapulta(catapulta));
        entidadMap.put(Curandero.class, (curandero) -> colocarCurandero(curandero));
        entidadMap.put(Soldado.class,   (soldado) -> colocarSoldado(soldado));

    }

    public Ocupado(Entidad entidad, Posicion posicion) {
        this.initEntidadMap();
        ColocarHandler handler = this.entidadMap.get(entidad.getClass());
        handler.colocar(entidad);
        entidad.setPosicion(posicion);
    }

    public void colocarJinete(Entidad jinete) {
    	entidad = jinete;
        puedeAtacar = (PuedeAtacar) jinete;
        puedeCurar = new NulaEntidad();
        puedeFormarBatallon = new NulaEntidad();
        puedeMoverse = (PuedeMoverse) jinete;
        puedeSerCurada = (PuedeSerCurada) jinete;
        puedeSerHerida = (PuedeSerHerida) jinete;
    }

    public void colocarSoldado(Entidad soldado) {
    	entidad = soldado;
        puedeAtacar = (PuedeAtacar) soldado;
        puedeCurar = new NulaEntidad();
        puedeFormarBatallon = (PuedeFormarBatallon) soldado;
        puedeMoverse = (PuedeMoverse) soldado;
        puedeSerCurada = (PuedeSerCurada) soldado;
        puedeSerHerida = (PuedeSerHerida) soldado;
    }

    public void colocarCatapulta(Entidad catapulta) {
    	entidad = catapulta;
        puedeAtacar = (PuedeAtacar) catapulta;
        puedeCurar = new NulaEntidad();
        puedeFormarBatallon = new NulaEntidad();
        puedeMoverse = new NulaEntidad();
        puedeSerCurada = new NulaEntidad();
        puedeSerHerida = (PuedeSerHerida) catapulta;
    }

    public void colocarCurandero(Entidad curandero) {
    	entidad = curandero;
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

    public void infligirDanioEnEntidad(int power, Faccion entidadCasillero, Faccion entidadAtacante, Casillero casillero) {
        if (puedeSerHerida.sosAmigo(entidadCasillero)) {
            puedeSerHerida.disminuirVida(power, entidadAtacante, casillero);
        } else {
            puedeSerHerida.disminuirVida(power*1.05, entidadAtacante, casillero);
        }
    }

    public void infigirDanioEnEntidadIgnorandoFaccionAtacante(int power, Faccion entidadCasillero, Casillero casillero) {
        if (puedeSerHerida.sosAmigo(entidadCasillero)) {
            puedeSerHerida.disminuirVidaIgnorandoFaccionAtacante(power, casillero);
        } else {
            puedeSerHerida.disminuirVidaIgnorandoFaccionAtacante(power*1.05, casillero);
        }
    }

    public void infligirCuracionEnEntidad(int power, Faccion faccionCuradora) {
        puedeSerCurada.aumentarVida(power, faccionCuradora);
    }

    public void atacar(Casillero casilleroAtacado, Tablero tablero, Faccion faccionJugador) {
        puedeAtacar.atacar(casilleroAtacado, tablero, faccionJugador);
    }

    public void curar(Casillero casilleroCurado, Tablero tablero, Faccion faccionJugador) {
        puedeCurar.curar(casilleroCurado, faccionJugador);
    }


    public void moverEntidad(Tablero tablero, Casillero origen, Casillero destino, Faccion faccionJugador) {
        if (puedeMoverse.moverA(tablero, destino, faccionJugador)) 
            origen.cambiarEstado(new Vacio());            
    }

    public void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidadOrigen) {
        puedeFormarBatallon.reclutarParaBatallon(reclutados, cola, entidadOrigen);
    }


    public boolean recibirEntidad(Entidad entidad, Casillero casillero, Posicion posicion) {
        throw new CasilleroOcupadoException();
    }

    public boolean colocarEntidad(Entidad entidad, Casillero casillero, Faccion faccion, Posicion posicion) {
        throw new CasilleroOcupadoException();
    }

    public Entidad getEntidad() {
    	return entidad;
    }

    @Override
    public Entidad seleccionarEntidad(Juego juego) {
        juego.seleccionarEntidad(entidad);
        return entidad;
    }
}
