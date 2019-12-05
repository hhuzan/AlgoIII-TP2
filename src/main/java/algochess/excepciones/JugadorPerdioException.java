package algochess.excepciones;

import algochess.engine.jugador.Jugador;

@SuppressWarnings("serial")

public class JugadorPerdioException extends RuntimeException {
	
	private Jugador jugador;

	public JugadorPerdioException(Jugador jugador) {
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public String getMessage() {
		return "El jugador " + jugador.getNombre() + " ha perdido la partida";
	}
}

