package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.TipoNoPuedeAtacarException;
import fiuba.algo3.tp2.excepciones.TipoNoPuedeCurarException;


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

	public abstract void recibirCuracion(int curacion);
	public abstract void recibirAtaque(Entidad entidad, int danio);
	public void atacar(Entidad atacante, Entidad atacado, Distancia distancia) {
		throw new TipoNoPuedeAtacarException();
	}
	public void ataque(Entidad atacante, Entidad atacado, DistanciaCercana distancia) {
		throw new TipoNoPuedeAtacarException();
	}
	public void ataque(Entidad atacante, Entidad atacado, DistanciaMedia distancia) {
		throw new TipoNoPuedeAtacarException();
	}
	public void ataque(Entidad atacante, Entidad atacado, DistanciaLejana distancia) {
		throw new TipoNoPuedeAtacarException();
	}
	
	public void curar(Entidad atacante, Entidad atacado, Distancia distancia) {
		throw new TipoNoPuedeCurarException();
	}

	public void curacion(Entidad atacante, Entidad curado, DistanciaCercana distancia) {
		throw new TipoNoPuedeCurarException();
	}
	public void curacion(Entidad atacante, Entidad curado, DistanciaMedia distancia) {
		throw new TipoNoPuedeCurarException();
	}
	public void curacion(Entidad atacante, Entidad curado, DistanciaLejana distancia) {
		throw new TipoNoPuedeCurarException();
	}

	public void atacar(Entidad atacante, Casillero destino, Distancia distancia) {
		throw new TipoNoPuedeAtacarException();
	}

	public void ataque(Entidad atacante, Casillero destino, DistanciaCercana distancia) {
		throw new TipoNoPuedeAtacarException();
	}
	public void ataque(Entidad atacante, Casillero destino, DistanciaMedia distancia) {
		throw new TipoNoPuedeAtacarException();
	}
	public void ataque(Entidad atacante, Casillero destino, DistanciaLejana distancia) {
		throw new TipoNoPuedeAtacarException();
	}

	public void curar(Entidad atacante, Casillero destino, Distancia distancia) {
		throw new TipoNoPuedeCurarException();
	}
	public void curacion(Entidad atacante, Casillero destino, DistanciaCercana distancia) {
		throw new TipoNoPuedeCurarException();
	}
	public void curacion(Entidad atacante, Casillero destino, DistanciaMedia distancia) {
		throw new TipoNoPuedeCurarException();
	}
	public void curacion(Entidad atacante, Casillero destino, DistanciaLejana distancia) {
		throw new TipoNoPuedeCurarException();
	}

}
