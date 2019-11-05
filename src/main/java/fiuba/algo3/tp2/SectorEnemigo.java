package fiuba.algo3.tp2;

public class SectorEnemigo extends Sector {

	public SectorEnemigo() {
		super();
	}

	@Override
	public void colocar(Aliado aliado) {
		// TODO Agregar Excepcion?
	}

	@Override
	public void colocar(Enemigo enemigo) {
		colocar_(enemigo);
	}

}
