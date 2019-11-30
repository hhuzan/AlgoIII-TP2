package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.posicion.Posicion;

public class Juego {

	private Turno turno;
	private Tablero tablero;
	private VendedorDeEntidades vendedor;
	private Entidad entidadSeleccionada;
	private Jugador jugadorAliado;
	private Jugador jugadorEnemigo;
	private Jugador jugadorActual = null;
	private Faccion faccionActual = null;

	public Juego(String nombreAliado, String nombreEnemigo) {
		tablero = new Tablero();
		jugadorAliado = new Jugador(Faccion.ALIADOS, nombreAliado);
		jugadorEnemigo = new Jugador(Faccion.ENEMIGOS, nombreEnemigo);
		turno = new Turno(jugadorAliado, jugadorEnemigo);
		vendedor = new VendedorDeEntidades();
		jugadorActual = turno.random();
		faccionActual = turno.popFaccion();
	}

	public void seleccionarSoldado() {
		entidadSeleccionada = new Soldado(jugadorActual, faccionActual);
	}

	public void seleccionarJinete() {
		entidadSeleccionada = new Jinete(jugadorActual, faccionActual);
	}

	public void seleccionarCatapulta() {
		entidadSeleccionada = new Catapulta(jugadorActual, faccionActual);
	}

	public void seleccionarCurandero() {
		entidadSeleccionada = new Curandero(jugadorActual, faccionActual);
	}

	public void comprarEntidad(int fila, int columna) {
		try {
			Posicion posicion = new Posicion(fila, columna);
			jugadorActual.comprarEntidad(vendedor, entidadSeleccionada);
			System.out.println("Compraada la pieza");
			tablero.colocarEntidad(entidadSeleccionada, posicion, jugadorActual);
			System.out.println("Colocada la entidad");
			jugadorActual = turno.cambiarTurno(jugadorActual);
			faccionActual = turno.popFaccion();
			System.out.println("Cambiado el turno");
		} catch (Exception ex) {
			System.out.println("Seteando dinero a jugador porque no pudo colocarse la pieza");
			jugadorActual.setDinero(entidadSeleccionada);
			throw ex;
		}
	}

	public boolean cambiarTurno() {
		System.out.println("Cambiando turno...");
		System.out.println(jugadorAliado);
		System.out.println(jugadorEnemigo);
		if(jugadorAliado.noPuedeComprar() && jugadorEnemigo.noPuedeComprar())
			return true;

		jugadorActual = turno.cambiarTurno(jugadorActual);
		faccionActual = turno.popFaccion();
		return false;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public Turno getTurno() {
		return turno;
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public Faccion getFaccionActual() {
		return faccionActual;
	}
}