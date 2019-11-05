package fiuba.algo3.tp2;

public abstract class Sector {

	private Estado estado;
	private Entidad entidad;
	
	public Sector() {
		estado = new Vacio(this);
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
		estado = new Ocupado(this);
	}

	public boolean estaVacio() { // TODO sacar? modificar?
		return estado.estaVacio();
	}
	
	public Entidad sacar() {
		Entidad respuesta = entidad;
		entidad = null;
		estado = new Vacio(this);
		return respuesta;
	}

	public abstract void colocar(Aliado aliado);

	public abstract void colocar(Enemigo enemigo);

}
