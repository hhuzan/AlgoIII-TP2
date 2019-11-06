package fiuba.algo3.tp2;

public class Enemigo extends Entidad {

	public Enemigo(Tipo tipo) {
		setTipo(tipo);
	}

	@Override
	public void colocarEn(Casillero casillero) {
		casillero.colocar(this);
	}
 }
