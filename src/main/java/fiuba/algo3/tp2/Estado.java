package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.CasilleroOcupadoException;

public interface Estado {

	public Estado colocar(Entidad entidad) throws CasilleroOcupadoException;
	public Entidad getEntidad();
	public Estado moverDesde(Casillero origen);
	public void atacar(Entidad entidad, Casillero casilleroDestino, Distancia distancia);
	public void recibirCuracion(Entidad curado, Entidad curador, int danio);
	public void recibirAtaque(Entidad atacado, Entidad atacante, int danio);
	public void recibirAtaque(Entidad atacado, Entidad atacante, int danio, boolean daniaTodo);
	public void curar(Entidad entidad, Casillero casilleroDestino, Distancia distancia);

}
