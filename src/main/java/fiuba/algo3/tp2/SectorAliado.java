package fiuba.algo3.tp2;

public class SectorAliado extends Sector {

	public SectorAliado() {
		super();
	}

	@Override
	public void colocar(Aliado aliado) {
		colocar_(aliado);
	}

	@Override
	public void colocar(Enemigo enemigo) {
		// TODO Agregar Excepcion?
	}

}
