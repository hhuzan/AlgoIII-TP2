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
import algochess.engine.juego.Fase;

public class Final implements Fase {

	private Entidad entidadSeleccionada;

	public void seleccionarEntidad(Jugador jugador, Faccion faccion, Entidad entidad) {
		if(entidad.sosAmigo(faccion))
			entidadSeleccionada = entidad;

	}

	public void comprarEntidad(Jugador jugador, VendedorDeEntidades vendedor) {
	}

	public void colocarEntidad(Tablero tablero, Jugador jugador, Posicion posicion) {
	}

	public void devolverDinero(Jugador jugador) {
	}

	public boolean verificarFinDeFase(Jugador jugadorAliado, Jugador jugadorEnemigo) {
		return (jugadorAliado.perdio() || jugadorEnemigo.perdio());
	}

	public Entidad obtenerEntidadSeleccionada() {
		return entidadSeleccionada;
	}

	public void liberarEntidadSeleccionada() {
		entidadSeleccionada = null;
	}

	public void atacar(Tablero tablero, Posicion posOrigen, Posicion posDestino, Faccion faccion) {
		tablero.atacarCasillero(posOrigen, posDestino, faccion);
	}

	public void curar(Tablero tablero, Posicion posOrigen, Posicion posDestino, Faccion faccion) {
		tablero.curarCasillero(posOrigen,posDestino,faccion);
	}

	// public boolean cambiarTurno() {
	// 	if(jugadorAliado.noPuedeComprar() && jugadorEnemigo.noPuedeComprar())
	// 		return true;

	// 	jugadorActual = turno.cambiarTurno(jugadorActual);
	// 	faccionActual = turno.popFaccion();
	// 	return false;
	// }
}