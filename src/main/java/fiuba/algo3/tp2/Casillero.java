package fiuba.algo3.tp2;

public class Casillero {
	Unidad unidad;

	public void colocar(Unidad unidad) {
		this.unidad = unidad;
	}

	public boolean estaVacio() { // TODO refactorizar
		return unidad == null;
	}
}
