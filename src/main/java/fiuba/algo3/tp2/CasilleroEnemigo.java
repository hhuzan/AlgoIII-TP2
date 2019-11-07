package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.ColocarEntidadException;

public class CasilleroEnemigo extends Casillero {

	@Override
	public void colocar(Aliado aliado) {
		throw new ColocarEntidadException();
	}

	@Override
	public void colocar(Enemigo enemigo) {
		getEstado().colocar(enemigo);
	}

}
