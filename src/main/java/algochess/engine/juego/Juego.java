package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.facciones.Faccion;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.posicion.Posicion;

public class Juego {


	private Turno turno;
	private Tablero tablero;
	private Jugador jugadorAliado = null;
	private Jugador jugadorEnemigo = null;
	private VendedorDeEntidades vendedor;
	private Entidad entidadSeleccionada;

	public Juego(Jugador aliado, Jugador enemigo, Tablero tablero) {
		this.tablero = tablero;
		this.turno = new Turno(Faccion.ALIADOS);
		this.jugadorAliado = aliado;
		this.jugadorEnemigo = enemigo;
		this.vendedor = new VendedorDeEntidades();
	}

	public void seleccionarSodado() {
		entidadSeleccionada = new Soldado();
	}
	
	public void seleccionarJinete() {
		entidadSeleccionada = new Jinete();
	}
	
	public void seleccionarCatapulta() {
		entidadSeleccionada = new Catapulta();
	}
	
	public void seleccionarCurandero() {
		entidadSeleccionada = new Curandero();
	}
	
	public void comprarEntidad(Jugador jugador, Posicion posicion, Entidad entidad) {
		// TODO: Ver como obtener casillero dada la posición
		// Casillero casillero = new Casillero(posicion);
		try {
			jugador.comprarEntidad(vendedor, entidad);
			// turno.colocarEntidad(casillero, jugador, entidad);
		}
		catch(Exception ex) {
			// Se la enviamos a la GUI para que haga lo que sea
			throw ex;
		}

	}
	
	public Tablero getTablero() {
		return tablero;
	}
}