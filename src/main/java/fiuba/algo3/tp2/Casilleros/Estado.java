package fiuba.algo3.tp2;

public interface Estado {

	public boolean estaVacio();
	public Estado colocar(Entidad entidad) throws CasilleroOcupadoException;
	public Entidad getEntidad();
	public Estado moverDesde(Casillero origen);
	public void atacar(Casillero destino, int distancia);
	public void recibirAtaque(int danio, int distancia);

}
