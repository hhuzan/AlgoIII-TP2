package fiuba.algo3.tp2;

public class Catapulta extends Entidad {

    private int vida = 50;
    private int costo = 5;


    public void restarAJugador(Jugador jugador){

        jugador.restarPuntos(this.costo);
    }

}
