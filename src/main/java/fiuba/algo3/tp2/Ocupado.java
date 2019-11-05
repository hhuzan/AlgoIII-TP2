package fiuba.algo3.tp2;

public class Ocupado implements Estado{
	private Sector sector;

	public Ocupado(Sector sector) {
		this.sector = sector;
	}

	@Override
	public boolean estaVacio() {
		return false;
	}

	@Override
	public Estado colocar(Entidad entidad) {
		// TODO Agregar excepcion???
		return this;
	}

	@Override
	public Entidad getEntidad() {
		return sector.getEntidad();
	}

}
