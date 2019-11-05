package fiuba.algo3.tp2;

public interface Estado {

	public boolean estaVacio();
	public Estado colocar(Entidad entidad);
	public Entidad getEntidad();

}
