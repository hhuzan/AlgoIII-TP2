package fiuba.algo3.tp2;

import fiuba.algo3.tp2.Excepciones.CasilleroOcupadoException;

public interface Estado {

	public boolean estaVacio();
	public Estado colocar(Entidad entidad) throws CasilleroOcupadoException;
	public Entidad getEntidad();
	public Estado moverDesde(Casillero origen);
	public void curar(Casillero destino, int distancia);
	public void atacar(Casillero destino, int distancia);
	public void recibirAtaque(int danio, int distancia);
	public void recibirCuracion(int curacion, int distancia);

}
