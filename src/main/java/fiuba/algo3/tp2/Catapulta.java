package fiuba.algo3.tp2;

public class Catapulta extends Entidad {

    private int vida = 50;
    private int costo = 5;
    private Jugador duenio;

    public Catapulta(Jugador duenio) {
        this.duenio = duenio;
    }

    @Override
    public void restarAJugador() {
        duenio.restarPuntos(this.costo);
    }

}
