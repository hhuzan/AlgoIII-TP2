package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
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
		entidadSeleccionada = new Soldado(jugadorAliado,Faccion.ALIADOS);
	}
	
	public void seleccionarJinete() {
		entidadSeleccionada = new Jinete(jugadorAliado,Faccion.ALIADOS);
	}
	
	public void seleccionarCatapulta() {
		entidadSeleccionada = new Catapulta(jugadorAliado,Faccion.ALIADOS);
	}
	
	public void seleccionarCurandero() {
		entidadSeleccionada = new Curandero(jugadorAliado,Faccion.ALIADOS);
	}
	
	public void comprarEntidad(int fila, int columna) {
		Casillero casillero = tablero.getCasilleros()[fila][columna];
			//TODO pedir jugador a turno
			jugadorAliado.comprarEntidad(vendedor, entidadSeleccionada);
			turno.colocarEntidad(casillero, jugadorAliado, entidadSeleccionada);
	}

//TODO ver si se saca
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