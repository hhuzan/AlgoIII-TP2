package fiuba.algo3.tp2;

public class CasilleroAliado extends Casillero {

	@Override
	public void colocar(Aliado aliado) {
		getEstado().colocar(aliado);
	}

	@Override
	public void colocar(Enemigo enemigo) {
		// TODO Agregar Excepcion?
	}

}
