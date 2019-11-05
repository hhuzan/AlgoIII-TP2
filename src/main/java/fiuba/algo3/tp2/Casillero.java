package fiuba.algo3.tp2;

public class Casillero {
	private Entidad entidad;

	public void colocar(Aliado aliado) {
		this.entidad = aliado;
		aliado.restarAJugador();
	}

	public void colocar(Enemigo enemigo) {
		this.entidad = enemigo;
		enemigo.restarAJugador();
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
