package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.facciones.Faccion;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.engine.entidades.Entidad;


public class Juego {
	private Tablero tablero;
	private Jugador jugadorAliado = null;
	private Jugador jugadorEnemigo = null;
	private VendedorDeEntidades vendedor;
	private Faccion turno;

	public Juego(Jugador jugadorAliado, Jugador jugadorEnemigo, Tablero tablero) {
		this.vendedor = new VendedorDeEntidades();
		this.jugadorAliado = jugadorAliado;
		this.jugadorEnemigo = jugadorEnemigo;
		this.tablero = tablero;
	}

	public void iniciarPartida() {
		this.turno = Faccion.ALIADOS;
	}

	public void comprarEntidad(Entidad entidad) {
		if(turno == Faccion.ALIADOS) {
			jugadorAliado.comprarEntidad(vendedor, entidad);
		} else if(turno == Faccion.ENEMIGOS) {
			jugadorEnemigo.comprarEntidad(vendedor, entidad);
		}
	}
	
	public Tablero getTablero() {
		return tablero;
	}

}