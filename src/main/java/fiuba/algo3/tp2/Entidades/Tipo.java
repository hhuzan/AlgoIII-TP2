<<<<<<< HEAD:src/main/java/fiuba/algo3/tp2/Entidades/Tipo.java
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
	public abstract void atacar(Casillero destino, int distancia);
	public abstract void recibirAtaque(Entidad entidad, int danio, int distancia);

}
=======
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
	public abstract void atacar(Casillero destino, int distancia);
	public abstract void recibirAtaque(Entidad entidad, int danio, int distancia);
	public abstract void curar(Casillero destino, int distancia);
	public abstract void recibirCuracion(int curacion, int distancia);

}
>>>>>>> master:src/main/java/fiuba/algo3/tp2/Tipo.java
