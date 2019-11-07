package fiuba.algo3.tp2;

public class Vacio implements Estado {
	private Casillero casillero;

	public Vacio(Casillero casillero) {
		this.casillero = casillero;
	}

	@Override
	public boolean estaVacio() {
		return true;
	}

	@Override
	public Estado colocar(Entidad entidad) {
		casillero.setEntidad(entidad);
		entidad.restarAJugador();
		return new Ocupado(casillero);
	}

	@Override
	public Entidad getEntidad() {
		return casillero.getEntidad();
	}

	@Override
	public Estado moverDesde(Casillero origen) {
		casillero.setEntidad(origen.popEntidad());
		return new Ocupado(casillero);
	}

	@Override 
	public void atacar(Casillero destino, int distancia) {
		throw new CasilleroVacioException();
	}

	@Override 
	public void recibirAtaque(int danio, int distancia) {
		throw new CasilleroVacioException();
	}

	@Override 
	public void curar(Casillero destino, int distancia) {
		throw new CasilleroVacioException();
	}

	@Override 
	public void recibirCuracion(int curacion, int distancia) {
		throw new CasilleroVacioException();
	}

}
