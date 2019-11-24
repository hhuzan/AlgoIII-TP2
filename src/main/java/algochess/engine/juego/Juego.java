package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.facciones.Faccion;


public class Juego {

	private Tablero tablero;
	private Jugador jugadorAliado = null;
	private Jugador jugadorEnemigo = null;

	public Juego(Tablero tablero, Jugador jugadorAliado, Jugador jugadorEnemigo) {
		this.tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
	}

	public void initJuego(String jugadorAliado, String jugadorEnemigo) {
		this.jugadorAliado = new Jugador(Faccion.ALIADOS, jugadorAliado);
		this.jugadorEnemigo = new Jugador(Faccion.ENEMIGOS, jugadorEnemigo);
	}
}