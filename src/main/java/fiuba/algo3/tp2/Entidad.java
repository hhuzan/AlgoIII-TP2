package fiuba.algo3.tp2;

public class Entidad {
	private int vida;
	private int costo;


	public void restarAJugador(Jugador jugador){

		jugador.restarPuntos(this.costo);
	}
}
