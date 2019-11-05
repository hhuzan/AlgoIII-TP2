package fiuba.algo3.tp2;

public class Vacio implements Estado {
	private Sector sector;

	public Vacio(Sector sector) {
		this.sector = sector;
	}

	@Override
	public boolean estaVacio() {
		return true;
	}

	@Override
	public Estado colocar(Entidad entidad) {
		sector.setEntidad(entidad);
		entidad.restarAJugador();
		return new Ocupado(sector);
	}

	@Override
	public Entidad getEntidad() {
		return sector.getEntidad();
	}

}
