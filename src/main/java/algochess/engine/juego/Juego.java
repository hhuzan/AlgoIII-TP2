package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.facciones.Faccion;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.engine.entidades.Entidad;


public class Juego {


	private Turno turno;
	private Tablero tablero;
	private Jugador jugadorAliado = null;
	private Jugador jugadorEnemigo = null;
	private VendedorDeEntidades vendedor;

	public Juego() {
		this.tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
		this.turno = new Turno(Faccion.ALIADOS);
	}

	public void iniciarPartida(String jugadorAliado, String jugadorEnemigo) {
		this.jugadorAliado = new Jugador(Faccion.ALIADOS, jugadorAliado);
		this.jugadorEnemigo = new Jugador(Faccion.ENEMIGOS, jugadorEnemigo);
	}

	public void comprarEntidad(Entidad entidad) {
	}
}