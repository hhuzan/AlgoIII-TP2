package fiuba.algo3.tp2;

public abstract class Casillero {

	private Entidad entidad;
	private Estado estado;
	protected int fila;
	protected int columna;

//	public Casillero() {
//		estado = new Vacio(this);
//	}

	public Casillero(int fila, int columna) {
		estado = new Vacio(this);
		this.fila = fila;
		this.columna = columna;
	}

	public abstract void colocar(Aliado aliado);

	public abstract void colocar(Enemigo enemigo);
	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
		estado = new Ocupado(this);
	}
	
	public Estado getEstado() {
		return estado;
	}

	public boolean estaVacio() {
		return estado.estaVacio();
	}

	public Entidad popEntidad() {
		Entidad respuesta = entidad;
		entidad = null;
		estado = new Vacio(this);
		return respuesta;
	}

	public int getFila() {
		return this.fila;
	} 

	public int getColumna() {
		return this.columna;
	}

	public void moverDesde(Casillero casillero) {
		estado = estado.moverDesde(casillero);
	}
}
