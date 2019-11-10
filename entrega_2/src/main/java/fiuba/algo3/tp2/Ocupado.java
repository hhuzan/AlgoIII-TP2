package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.CasilleroOcupadoException;

public class Ocupado implements Estado{
	private Casillero casillero;

	public Ocupado(Casillero casillero) {
		this.casillero = casillero;
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
	public void atacar(Entidad entidad, Casillero destino, Distancia distancia) {
		entidad.atacar(destino, distancia);
	}

	@Override 
	public void curar(Entidad entidad, Casillero destino, Distancia distancia) {
		entidad.curar(destino, distancia);
	}

	@Override 
	public void recibirAtaque(Entidad atacado, Entidad atacante, int danio) {
		atacado.recibirAtaque(atacante, danio);
	}

	@Override 
	public void recibirAtaque(Entidad atacado, Entidad atacante, int danio, boolean daniaTodo) {
		atacado.recibirAtaque(atacante, danio, daniaTodo);
	}
	
	@Override
	public void recibirCuracion(Entidad curado, Entidad curador, int danio) {
		curado.recibirCuracion(curador, danio);
	}
}
