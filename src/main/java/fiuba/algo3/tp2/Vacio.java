package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.CasilleroVacioException;

public class Vacio implements Estado {
	private Casillero casillero;

	public Vacio(Casillero casillero) {
		this.casillero = casillero;
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
	public void atacar(Entidad entidad, Casillero casilleroDestino, Distancia distancia) {
		throw new CasilleroVacioException();
	}

	@Override 
	public void curar(Entidad entidad, Casillero casilleroDestino, Distancia distancia) {
		throw new CasilleroVacioException();
	}

	@Override 
	public void recibirAtaque(Entidad atacado, Entidad atacante, int danio) {
		throw new CasilleroVacioException();
	}
	
	@Override 
	public void recibirAtaque(Entidad atacado, Entidad atacante, int danio, boolean daniaTodo) {
		throw new CasilleroVacioException();
	}

	@Override
	public void recibirCuracion(Entidad curado, Entidad curador, int danio) {
		throw new CasilleroVacioException();
	}

}
