package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.posicion.Posicion;
import algochess.engine.juego.Fase;

public interface Fase {

	void seleccionarEntidad(Jugador jugador, Faccion faccion, Entidad entidad);
	void comprarEntidad(Jugador jugador, VendedorDeEntidades vendedor);
	void colocarEntidad(Tablero tablero, Jugador jugador, Posicion posicion);
	void devolverDinero(Jugador jugador);
	boolean verificarFinDeFase(Jugador jugadorAliado, Jugador jugadorEnemigo);
	// boolean cambiarTurno();

}