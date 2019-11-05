package fiuba.algo3.tp2;

public class Curandero extends Tipo {

//    private int vida = 75;
	private int costo = 2;

	public Curandero(Jugador propietario) {
		setPropietario(propietario);
	}

	@Override
	public void restarAJugador() {
		getPropietario().restarPuntos(costo);
	}

}
