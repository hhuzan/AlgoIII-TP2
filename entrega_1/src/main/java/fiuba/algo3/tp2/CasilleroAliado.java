package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.ColocarEntidadException;

public class CasilleroAliado extends Casillero {

	@Override
	public void colocar(Aliado aliado) {
		getEstado().colocar(aliado);
	}

	@Override
	public void colocar(Enemigo enemigo) {
		throw new ColocarEntidadException();
	}

}
