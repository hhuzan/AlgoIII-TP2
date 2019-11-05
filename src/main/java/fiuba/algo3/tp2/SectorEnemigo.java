package fiuba.algo3.tp2;

public class SectorEnemigo extends Sector {

	@Override
	public void colocar(Aliado aliado) {
		// TODO Agregar Excepcion?
	}

	@Override
	public void colocar(Enemigo enemigo) {
		getEstado().colocar(enemigo);
	}

}
