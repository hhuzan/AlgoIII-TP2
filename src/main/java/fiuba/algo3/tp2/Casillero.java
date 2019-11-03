package fiuba.algo3.tp2;

public class Casillero {
	Entidad entidad;

	public void colocar(Entidad entidad) {
		this.entidad = entidad;
	}

	public boolean estaVacio() { // TODO refactorizar
		return entidad == null;
	}
}
