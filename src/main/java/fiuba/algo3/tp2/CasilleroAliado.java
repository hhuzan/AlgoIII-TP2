package fiuba.algo3.tp2;

public class CasilleroAliado extends Casillero {

	public CasilleroAliado() {
		super();
	}

	public CasilleroAliado(int fila, int columna) {
		super(fila, columna);
	}

	@Override
	public void colocar(Aliado aliado) {
		getEstado().colocar(aliado);
	}

	@Override
	public void colocar(Enemigo enemigo) {
		throw new ColocarEntidadException();
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
