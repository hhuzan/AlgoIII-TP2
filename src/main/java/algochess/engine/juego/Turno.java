package algochess.engine.juego;


import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
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
		int rand = Math.random() < 0.5 ? 0 : 1;
		faccionActual = rand == 0 ? Faccion.ALIADOS : Faccion.ENEMIGOS;
		return jugadores.get(rand);
	}

	public Faccion popFaccion() {
		return faccionActual;
	}

	public Jugador cambiarTurno(Jugador jugador) {
		faccionActual = (faccionActual == Faccion.ALIADOS) ? Faccion.ENEMIGOS : Faccion.ALIADOS;
		return jugadores.stream().filter(x -> jugador != x).findFirst().get();
	}

}
