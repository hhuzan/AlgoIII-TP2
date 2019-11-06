package fiuba.algo3.tp2;

public class CasilleroAliado extends Casillero {

	public CasilleroAliado() {
		super();
	}

	public CasilleroAliado(int fila, int columna) {
		super();
	}

	@Override
	public void colocar(Aliado aliado) {
		getEstado().colocar(aliado);
	}

	@Override
	public void colocar(Enemigo enemigo) {
		// TODO Agregar Excepcion?
	}

}
