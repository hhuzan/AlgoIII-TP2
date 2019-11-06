package fiuba.algo3.tp2;

public class Catapulta extends Tipo {

//    private int vida = 50;
    private int costo = 5;
    
	public Catapulta(Jugador propietario) {
		setPropietario(propietario);
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

    @Override
    public void restarAJugador() {
        getPropietario().restarPuntos(costo);
    }

}
