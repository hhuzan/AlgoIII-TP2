package fiuba.algo3.tp2;

public class SectorAliado extends Sector {

	@Override
	public void colocar(Aliado aliado) {
		setEntidad(aliado);
		aliado.restarAJugador();
	}

	@Override
	public void colocar(Enemigo enemigo) {
		// TODO Auto-generated method stub
	}

}
