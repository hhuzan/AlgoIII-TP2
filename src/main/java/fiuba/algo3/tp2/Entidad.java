package fiuba.algo3.tp2;

public abstract class Entidad {

	private Tipo tipo;
//	private int vida;
//	private int costo;

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

	public void atacar(Entidad atacado, int distancia) {
		tipo.atacar(atacado, distancia);
	}

	public void curar(Entidad curado, int distancia) {
		tipo.curar(curado, distancia);
	}

	public void recibirAtaque(int danio, int distancia) {
		tipo.recibirAtaque(this, danio, distancia);
	}

	public void recibirCuracion(int curacion, int distancia) {
		tipo.recibirCuracion(curacion, distancia);
	}
	public abstract void colocarEn(Casillero casillero);
}
