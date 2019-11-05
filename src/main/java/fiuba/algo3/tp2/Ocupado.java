package fiuba.algo3.tp2;

public class Ocupado implements Estado{
	private Casillero casillero;

	public Ocupado(Casillero casillero) {
		this.casillero = casillero;
	}

	@Override
	public boolean estaVacio() {
		return false;
	}

	@Override
	public Estado colocar(Entidad entidad) {
		throw new CasilleroOcupadoException();
	}

	@Override
	public Entidad getEntidad() {
		return casillero.getEntidad();
	}

}
