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
	public abstract void atacar(Entidad atacado, Distancia distancia);
	public abstract void atacarEntidad(Entidad atacado, DistanciaCercana distancia);
	public abstract void atacarEntidad(Entidad atacado, DistanciaMedia distancia);
	public abstract void atacarEntidad(Entidad atacado, DistanciaLejana distancia);
	public abstract void recibirAtaque(Entidad entidad, int danio);
	public abstract void curar(Entidad atacado, Distancia distancia);
	public abstract void curarEntidad(Entidad curado, DistanciaCercana distancia);
	public abstract void curarEntidad(Entidad curado, DistanciaMedia distancia);
	public abstract void curarEntidad(Entidad curado, DistanciaLejana distancia);

	public abstract void recibirCuracion(int curacion);

}
