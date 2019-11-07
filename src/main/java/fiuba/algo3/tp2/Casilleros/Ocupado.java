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

	@Override
	public Estado moverDesde(Casillero casillero) {
		throw new CasilleroOcupadoException();
	}

	@Override 
	public void atacar(Casillero destino, int distancia) {
		Entidad entidad = getEntidad();
		entidad.atacar(destino, distancia);
	}

	@Override 
	public void recibirAtaque(int danio, int distancia) {
		Entidad entidad = getEntidad();
		entidad.recibirAtaque(danio, distancia);
	}

	@Override 
	public void curar(Casillero destino, int distancia) {
		Entidad entidad = getEntidad();
		entidad.curar(destino, distancia);
	}

	@Override 
	public void recibirCuracion(int curacion, int distancia) {
		Entidad entidad = getEntidad();
		entidad.recibirCuracion(curacion, distancia);
	}
}
