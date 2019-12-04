package algochess.engine.tablero;

import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.NulaEntidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.posicion.Posicion;
import algochess.engine.interfaces.casillero.Estado;
import algochess.excepciones.ColocarEntidadException;
import algochess.excepciones.CasilleroVacioException;
import algochess.engine.juego.Juego;
import java.util.HashSet;
import java.util.Queue;

public class Vacio implements Estado {

    public boolean colocarEntidad(Entidad entidad, Casillero casillero, Faccion faccionCasillero, Posicion posicionCasillero) {
        if (entidad.sosAmigo(faccionCasillero)) 
            recibirEntidad(entidad, casillero, posicionCasillero);
        else
            throw new ColocarEntidadException();

        return true;
    }

    public boolean recibirEntidad(Entidad entidad, Casillero casillero, Posicion posicion) {
        casillero.cambiarEstado(new Ocupado(entidad, posicion));
        return true;
    }


    /*Métodos muertos */
    public void atacar(Casillero casilleroAtacado, Tablero tablero, Faccion faccionJugador) {
        throw new CasilleroVacioException();
    }

    public void curar(Casillero casilleroCurado, Tablero tablero, Faccion faccionJugador) {
    }

    public void moverEntidad(Tablero tablero, Casillero origen, Casillero destino, Faccion faccionJugador) {
    }

    public void reclutarEntidad(HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {
    }

    public void infligirCuracionEnEntidad(int power, Faccion faccion) {
    }

    public void infligirDanioEnEntidad(int power, Faccion faccionCasillero, Faccion faccionEntidad, Casillero casillero) {
    }

    public void infigirDanioEnEntidadIgnorandoFaccionAtacante(int power, Faccion faccionCasillero, Casillero casillero) {
    }

    @Override
    public boolean esSoldadoAmigo(Faccion faccion) {
        return false;
    }

    @Override
    public boolean poseesUnidad() {
        return false;
    }

	@Override
	public Entidad getEntidad() {
		return new NulaEntidad();
	}

    @Override 
    public Entidad seleccionarEntidad(Juego juego) {
        return new NulaEntidad();
    }

    @Override 
    public boolean enRangoMovimiento(Posicion posicion, Casillero destino) {
        return false;
    }
}
