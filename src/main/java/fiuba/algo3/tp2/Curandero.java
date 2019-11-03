package fiuba.algo3.tp2;

public class Curandero extends Entidad {

    private int vida = 75;
    private int costo = 2;

    public void restarAJugador(Jugador jugador){

        jugador.restarPuntos(this.costo);
    }

}
