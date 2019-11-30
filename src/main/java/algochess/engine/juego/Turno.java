package algochess.engine.juego;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import java.util.ArrayList;

public class Turno {

	private Faccion faccionActual;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	public Turno(Faccion faccion) {
		faccionActual = faccion;
	}

	public Turno(Jugador aliado, Jugador enemigo) {
		jugadores.add(aliado);
		jugadores.add(enemigo);
		faccionActual = Faccion.ALIADOS;
	}

	public Jugador random() {
		// TODO: Hacer random 50-50
		faccionActual = Faccion.ALIADOS;
		return jugadores.get(0);
	}

	public Faccion popFaccion() {
		return faccionActual;
	}

	public Jugador cambiarTurno(Jugador jugador) {
		faccionActual = (faccionActual == Faccion.ALIADOS) ? Faccion.ENEMIGOS : Faccion.ALIADOS;
		System.out.println("Cambiando turno");
		System.out.println(jugador);
		System.out.println(jugadores.get(0));
		System.out.println(jugadores.get(1));
		return jugadores.stream().filter(x -> jugador != x).findFirst().get();
	}

	public Faccion getFaccionActual() {
		return faccionActual;
	}
}
