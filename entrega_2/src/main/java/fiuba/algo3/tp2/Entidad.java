package fiuba.algo3.tp2;

public abstract class Entidad {

	protected Tipo tipo;

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void restarAJugador() {
		tipo.restarAJugador();
	}

	public int getCosto() {
		return tipo.getCosto();
	}

	public int getVida() {
		return tipo.getVida();
	}

	public void atacar(Entidad atacado, Distancia distancia) {
		tipo.atacar(this, atacado, distancia);
	}

	public void atacar(Casillero destino, Distancia distancia) {
		tipo.atacar(this, destino, distancia);
	}

	public void curar(Entidad curado, Distancia distancia) {
		tipo.curar(this, curado, distancia);
	}

	public void curar(Casillero destino, Distancia distancia) {
		tipo.curar(this, destino, distancia);
	}

	public abstract void recibirAtaque(Entidad atacante, int danio);
	public abstract void recibirAtaque(Entidad atacante, int danio, boolean daniaTodo);
	public abstract void ataque(Aliado atacanteAliado, int danio);
	public abstract void ataque(Aliado atacanteAliado, int danio, boolean daniaTodo);
	public abstract void ataque(Enemigo atacanteEnemigo, int danio);
	public abstract void ataque(Enemigo atacanteEnemigo, int danio, boolean daniaTodo);
	public abstract void verificarAtaque(Entidad atacante, int curacion);
	public abstract void verificarAtaque(Entidad atacante, int curacion, boolean daniaTodo);

	public abstract void recibirCuracion(Entidad atacante, int curacion);
	public abstract void curacion(Aliado atacanteAliado, int curacion);
	public abstract void curacion(Enemigo atacanteEnemigo, int curacion);
	public abstract void colocarEn(Casillero casillero);
	public abstract void verificarCuracion(Entidad atacante, int curacion);

}
