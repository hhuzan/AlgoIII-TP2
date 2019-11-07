package fiuba.algo3.tp2;

public abstract class Tipo {
	private Jugador propietario;
	
	public void setPropietario(Jugador propietario) {
		this.propietario = propietario;
	}

	public Jugador getPropietario() {
		return propietario;
	}
	
	public abstract void restarAJugador();
	public abstract int getCosto();
	public abstract int getVida();
	public abstract void atacar(Entidad entidad, int distancia);
	public abstract void recibirDanio(Entidad entidad, int danio, int distancia);

}
