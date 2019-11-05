package fiuba.algo3.tp2;

public class SectorAliado extends Sector {

	@Override
	public void colocar(Aliado aliado) {
		getEstado().colocar(aliado);
	}

	@Override
	public void colocar(Enemigo enemigo) {
		// TODO Agregar Excepcion?
	}

}
