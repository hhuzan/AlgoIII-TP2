package fiuba.algo3.tp2;

public class Aliado extends Entidad {

	public Aliado(Tipo tipo) {
		setTipo(tipo);
	}

	@Override
	public void colocarEn(Casillero casillero) {
		casillero.colocar(this);
	}

}
