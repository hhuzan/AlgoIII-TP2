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

	public abstract void colocarEn(Casillero casillero);
}
