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
import algochess.excepciones.DineroInsuficienteException;
import algochess.excepciones.ColocarEntidadException;


public class Juego {

	private Turno turno;
	private Tablero tablero;
	private VendedorDeEntidades vendedor;
	private Jugador jugadorAliado;
	private Jugador jugadorEnemigo;
	private Jugador jugadorActual = null;
	private Faccion faccionActual = null;
	private Fase fase;

	public Juego(String nombreAliado, String nombreEnemigo) {
		tablero = new Tablero();
		jugadorAliado = new Jugador(Faccion.ALIADOS, nombreAliado);
		jugadorEnemigo = new Jugador(Faccion.ENEMIGOS, nombreEnemigo);
		turno = new Turno(jugadorAliado, jugadorEnemigo);
		vendedor = new VendedorDeEntidades();
		jugadorActual = turno.random();
		faccionActual = turno.popFaccion();
		fase = new Inicial();
	}

	public void seleccionarEntidad(Entidad entidad) {
		fase.seleccionarEntidad(jugadorActual, faccionActual, entidad);
	}

	public void seleccionarEntidad(int fila, int columna) {
		System.out.println("Seleccionando entidad en juego...");
		 tablero.seleccionarEntidad(fila, columna, this);
	}

	public Entidad obtenerEntidadSeleccionada() {
		return fase.obtenerEntidadSeleccionada();
	}

	public void liberarEntidadSeleccionada() {
		fase.liberarEntidadSeleccionada();
	}

	public void comprarEntidad(int fila, int columna) {
		try {
			Posicion posicion = new Posicion(fila, columna);
			fase.comprarEntidad(jugadorActual, vendedor);
			fase.colocarEntidad(tablero, jugadorActual, posicion);

			jugadorActual = turno.cambiarTurno(jugadorActual);
			faccionActual = turno.popFaccion();
		} catch (ColocarEntidadException ex) {
			fase.devolverDinero(jugadorActual);
			throw ex;
		} catch (DineroInsuficienteException ex) {
			throw ex;
		}
	}

	public boolean cambiarTurno() {
		boolean faseTerminada = fase.verificarFinDeFase(jugadorAliado, jugadorEnemigo);

		if(faseTerminada) {
			fase = new Final();
			return true;
		}

		jugadorActual = turno.cambiarTurno(jugadorActual);
		faccionActual = turno.popFaccion();
		return false;
	}

	public void atacar(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
		Posicion posicionOrigen = new Posicion(filaOrigen, colOrigen);
		Posicion posicionDestino = new Posicion(filaDestino, colDestino);
		fase.atacar(tablero, posicionOrigen, posicionDestino, faccionActual);
	}

	public void curar(int filaOrigen, int colOrigen, int filaDestino, int colDestino){
		Posicion posicionOrigen = new Posicion(filaOrigen, colOrigen);
		Posicion posicionDestino = new Posicion(filaDestino, colDestino);
		fase.curar(tablero,posicionOrigen,posicionDestino,faccionActual);
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