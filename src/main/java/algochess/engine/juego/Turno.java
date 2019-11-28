package algochess.engine.juego;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.NoEsTuTurnoException;

public class Turno {

	private Faccion faccionActual;

	public Turno(Faccion faccion) {
		faccionActual = faccion;

	}

	public void cambiarTurno() {
		if (faccionActual == Faccion.ALIADOS)
			faccionActual = Faccion.ALIADOS;
		else
			faccionActual = Faccion.ENEMIGOS;
	}

	public void colocarEntidad(Casillero casillero, Jugador jugador, Entidad entidad) {

		if (jugador.getFaccion() == this.faccionActual) {

			// se puede crear un metodo en jugador que se llame sonMismoBando o algo asi
			// para
			// encapsular un poquito mas

			casillero.colocarEntidad(entidad);
			cambiarTurno();
		} else {

			throw new NoEsTuTurnoException();

		}
	}

	public void atacarCasillero(Casillero casilleroAtacante, Casillero casilleroAtacado, Tablero tablero,
			Faccion faccionJugador) {
		if (faccionJugador == this.faccionActual) {

			// se puede crear un metodo en jugador que se llame sonMismoBando o algo asi
			// para
			// encapsular un poquito mas

			casilleroAtacante.atacar(casilleroAtacado, tablero, faccionJugador);
			cambiarTurno();
		} else {

			throw new NoEsTuTurnoException();

		}

	}

	public void curarCasillero(Casillero casilleroCurador, Casillero casilleroCurado, Tablero tablero,
			Faccion faccionJugador) {

		if (faccionJugador == this.faccionActual) {

			// se puede crear un metodo en jugador que se llame sonMismoBando o algo asi
			// para
			// encapsular un poquito mas

			casilleroCurador.curar(casilleroCurado, tablero, faccionJugador);
			this.faccionActual = Faccion.ENEMIGOS;
		} else {

			throw new NoEsTuTurnoException();

		}

	}

	public void moverEntidad(Casillero origen, Casillero destino, Tablero tablero, Faccion faccionJugador) {

		if (faccionJugador == this.faccionActual) {

			// se puede crear un metodo en jugador que se llame sonMismoBando o algo asi
			// para
			// encapsular un poquito mas

			origen.moverEntidad(tablero, origen, destino, faccionJugador);
			this.faccionActual = Faccion.ENEMIGOS;
		} else {

			throw new NoEsTuTurnoException();

		}

	}

	public Faccion getFaccionActual() {
		return faccionActual;
	}
}
