package fiuba.algo3.tp2;

public class Jinete extends Entidad {

    private int vida = 100;
    private int costo = 3;

    public void restarAJugador(Jugador jugador){

        jugador.restarPuntos(this.costo);
    }


}
