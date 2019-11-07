package fiuba.algo3.tp2;

public class CasilleroEnemigo extends Casillero {

	public CasilleroEnemigo() {
		super();
	}
	
	public CasilleroEnemigo(int fila, int columna) {
		super(fila, columna);
	}

	@Override
	public void colocar(Aliado aliado) {
		throw new ColocarEntidadException();
	}

	@Override
	public void colocar(Enemigo enemigo) {
		getEstado().colocar(enemigo);
	}

	@Override
	public int getFila() {
		return this.fila;
	} 

	@Override 
	public int getColumna() {
		return this.columna;
	}

}
