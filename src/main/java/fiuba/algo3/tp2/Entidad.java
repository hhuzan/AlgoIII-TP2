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

	public void atacar(Casillero destino, int distancia) {
		tipo.atacar(destino, distancia);
	}

	public void curar(Casillero destino, int distancia) {
		tipo.curar(destino, distancia);
	}

	public void recibirAtaque(int danio, int distancia) {
		tipo.recibirAtaque(this, danio, distancia);
	}

	public void recibirCuracion(int curacion, int distancia) {
		tipo.recibirCuracion(curacion, distancia);
	}
	public abstract void colocarEn(Casillero casillero);
}
