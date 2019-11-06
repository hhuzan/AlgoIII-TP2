package fiuba.algo3.tp2;

public class CasilleroEnemigo extends Casillero {

	public CasilleroEnemigo() {
		super();
	}
	
	public CasilleroEnemigo(int fila, int columna) {
		super();
	}

	@Override
	public void colocar(Aliado aliado) {
		// TODO Agregar Excepcion?
	}

	@Override
	public void colocar(Enemigo enemigo) {
		getEstado().colocar(enemigo);
	}

}
