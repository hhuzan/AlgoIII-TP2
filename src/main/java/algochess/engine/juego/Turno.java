package algochess.engine.juego;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.NoEsTuTurnoException;

public class Turno {

	private Faccion faccionActual;
	private Jugador jugadorAliado;
	private Jugador jugadorEnemigo;
	private Jugador jugadorActual;

	public Turno(Faccion faccion) {
		faccionActual = faccion;
	}

	public Turno(Jugador aliado, Jugador enemigo) {
		jugadorAliado = aliado;
		jugadorEnemigo = enemigo;
		faccionActual = Faccion.ALIADOS;
		jugadorActual = aliado;
	}

	public void cambiarTurno() {
		if (faccionActual == Faccion.ALIADOS) {
			faccionActual = Faccion.ENEMIGOS;
			jugadorActual = jugadorEnemigo;
		} else {
			faccionActual = Faccion.ALIADOS;
			jugadorActual = jugadorAliado;
		}
	}

	public void colocarEntidad(Casillero casillero, Entidad entidad) {
		casillero.colocarEntidad(entidad);
		cambiarTurno();
	}

	public void colocarEntidad(Casillero casillero, Jugador jugador, Entidad entidad) {
		casillero.colocarEntidad(entidad);
		cambiarTurno();
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

	public Jugador getJugadorActual() {
		return jugadorActual;
	}
}
