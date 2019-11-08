package fiuba.algo3.tp2;

public class DistanciaLejana extends Distancia  {

	private int distancia;

	public DistanciaLejana(int distancia) {
		this.distancia = distancia;
	}

	public int getDistanciaAsInt() {
		return distancia;
	}
	
	public void realizarAtaque(Tipo tipo, Entidad atacado) {
		tipo.atacarEntidad(atacado, this);
	}

	public void realizarCuracion(Tipo tipo, Entidad atacado) {
		tipo.curarEntidad(atacado, this);
	}
}
