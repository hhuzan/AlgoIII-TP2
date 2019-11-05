package fiuba.algo3.tp2;

public abstract class Sector {
	Entidad entidad;

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;		
	}
	
	public abstract void colocar(Aliado aliado);

	public abstract void colocar(Enemigo enemigo);

	public boolean estaVacio() {
		return entidad == null;
	}

	public Entidad sacar() {
		Entidad respuesta = entidad;
		entidad = null;
		return respuesta;
	}

}
