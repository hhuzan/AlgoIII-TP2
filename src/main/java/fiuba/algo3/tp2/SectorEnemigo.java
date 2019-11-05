package fiuba.algo3.tp2;

public class SectorEnemigo extends Sector {

	@Override
	public void colocar(Aliado aliado) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colocar(Enemigo enemigo) {
		setEntidad(enemigo);
		enemigo.restarAJugador();
	}

}
