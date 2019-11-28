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

	public Juego(Jugador aliado, Jugador enemigo, Tablero tablero) {
		this.tablero = tablero;
		turno = new Turno(aliado, enemigo);
		vendedor = new VendedorDeEntidades();
	}

	public Juego(String nombreAliado, String nombreEnemigo) {
		tablero = new Tablero();
		Jugador aliado = new Jugador(Faccion.ALIADOS, nombreAliado);
		Jugador enemigo = new Jugador(Faccion.ENEMIGOS, nombreEnemigo);
		turno = new Turno(aliado, enemigo);
		vendedor = new VendedorDeEntidades();
	}

	public void seleccionarSodado() {
		entidadSeleccionada = new Soldado(turno.getJugadorActual(), turno.getFaccionActual());
	}

	public void seleccionarJinete() {
		entidadSeleccionada = new Jinete(turno.getJugadorActual(), turno.getFaccionActual());
	}

	public void seleccionarCatapulta() {
		entidadSeleccionada = new Catapulta(turno.getJugadorActual(), turno.getFaccionActual());
	}

	public void seleccionarCurandero() {
		entidadSeleccionada = new Curandero(turno.getJugadorActual(), turno.getFaccionActual());
	}

	public void comprarEntidad(int fila, int columna) {
		Casillero casillero = tablero.getCasilleros()[fila][columna];
		turno.getJugadorActual().comprarEntidad(vendedor, entidadSeleccionada);
		turno.colocarEntidad(casillero, entidadSeleccionada);
	}

//TODO ver si se saca
	public void comprarEntidad(Jugador jugador, Posicion posicion, Entidad entidad) {
		// TODO: Ver como obtener casillero dada la posición
		// Casillero casillero = new Casillero(posicion);
		try {
			jugador.comprarEntidad(vendedor, entidad);
			// turno.colocarEntidad(casillero, jugador, entidad);
		} catch (Exception ex) {
			// Se la enviamos a la GUI para que haga lo que sea
			throw ex;
		}

	}

	public Tablero getTablero() {
		return tablero;
	}

	public Turno getTurno() {
		return turno;
	}
}