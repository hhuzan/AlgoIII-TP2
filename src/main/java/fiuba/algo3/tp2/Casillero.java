package fiuba.algo3.tp2;

public class Casillero {
	private Sector sector;

	public Casillero(Sector sector) {
		this.sector = sector;
	}

	public void colocar(Aliado aliado) {
		sector.colocar(aliado);
	}

	public void colocar(Enemigo enemigo) {
		sector.colocar(enemigo);
	}

	public void setEntidad(Entidad entidad) {
		sector.setEntidad(entidad);
	}

	public boolean estaVacio() {
		return sector.estaVacio();
	}

	public Entidad sacar() {
		return sector.sacar();
	}

}
