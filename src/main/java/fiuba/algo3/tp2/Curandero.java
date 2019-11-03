package fiuba.algo3.tp2;

public class Curandero extends Entidad {

    private int vida = 75;
    private int costo = 2;
    private Jugador duenio;

    public Curandero(Jugador duenio) {
        this.duenio = duenio;
    }

    @Override
    public void restarAJugador() {
        duenio.restarPuntos(this.costo);
    }
}
