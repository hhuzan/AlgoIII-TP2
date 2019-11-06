package fiuba.algo3.tp2;

public class Jinete extends Tipo {

//    private int vida = 100;
	private int costo = 3;

	public Jinete(Jugador propietario) {
		setPropietario(propietario);
	};

	@Override
	public int getCosto() {
		return this.costo;
	}

	@Override
	public void restarAJugador() {
		getPropietario().restarPuntos(this.costo);
	}

}
