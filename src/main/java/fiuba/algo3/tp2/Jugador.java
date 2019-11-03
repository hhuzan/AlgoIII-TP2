package fiuba.algo3.tp2;

public class Jugador {

    int puntos = 20;

    public void restarPuntos(int puntos){

        this.puntos -= puntos;
    }

    public int obtenerPuntos() {

        return this.puntos;
    }
}
