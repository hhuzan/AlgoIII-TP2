package fiuba.algo3.tp2;

public class Soldado extends Entidad {

    private int vida = 100;
    private int costo = 1;


    public void restarAJugador(Jugador jugador){

        jugador.restarPuntos(this.costo);
    }

}
