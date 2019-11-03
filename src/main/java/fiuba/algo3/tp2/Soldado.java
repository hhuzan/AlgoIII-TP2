package fiuba.algo3.tp2;

public class Soldado extends Entidad {

    private int vida = 100;
    private int costo = 1;
    private Jugador duenio;

    public Soldado(Jugador duenio) {
        this.duenio = duenio;
    }

    @Override
    public void restarAJugador() {
        duenio.restarPuntos(this.costo);
    }
}
