package fiuba.algo3.tp2;

public class Casillero {
	private Entidad entidad;

	public void colocar(Entidad entidad) {
		this.entidad = entidad;
		entidad.restarAJugador();
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public boolean estaVacio() { // TODO refactorizar
		return entidad == null;
	}

	public Entidad sacar() {
		Entidad respuesta = entidad;
		entidad = null;
		return respuesta;
	}
}
