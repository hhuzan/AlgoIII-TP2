package fiuba.algo3.tp2;

public class Jinete extends Entidad {

//    private int vida = 100;
    private int costo = 3;
    private Jugador duenio;

    public Jinete(Jugador duenio) {
       this.duenio = duenio;
    }

    @Override
    public void restarAJugador() {
        duenio.restarPuntos(this.costo);
    }


}
