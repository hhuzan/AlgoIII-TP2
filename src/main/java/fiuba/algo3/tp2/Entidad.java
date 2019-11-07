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

	public void atacar(Entidad entidad, int distancia) {
		tipo.atacar(entidad, distancia);
	}

	public void recibirDanio(int danio, int distancia) {
		tipo.recibirDanio(this, danio, distancia);
	}

	public abstract void colocarEn(Casillero casillero);
}
