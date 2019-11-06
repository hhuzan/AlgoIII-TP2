package fiuba.algo3.tp2;

public class Soldado extends Tipo {

    private int vida = 100;
    private int costo = 1;
    private int danioCuerpo = 10;
    private int danioDistancia = 0;
 
    public Soldado(Jugador propietario) {
		setPropietario(propietario);
	};
 
 	@Override
	public int getCosto() {
		return this.costo;
	}

    @Override 
    public int getVida() {
        return this.vida;
    }

    private void restarVida(int vida) {
        // Todo: Ver si murio la entidad => hay que sacarlo de la coleccion de entidades del jugador
        this.vida -= vida;
    }

    @Override
    public void restarAJugador() {
        getPropietario().restarPuntos(this.costo);
    }

    @Override
    public void atacar(Entidad entidadAtacada, int distancia) {
        /*  - Puede atacar a un enemigo a corta distancia.
            -   Si hay más de 3 Soldados contiguos (en cualquier dirección) se comportan como un Batallón y 
                PUEDEN moverse los 3 al mismo tiempo en el mismo turno. [Esto significa que cada uno de los 
                soldados se va a mover en la dirección solicitada. En caso que uno no pueda moverse al casillero, 
                únicamente ese Soldado se quedará quieto, y los demás si se moverán]
        */
        int danio = 0;
        if(distancia == 1) {
            danio = danioCuerpo;
        } else {
            danio = danioDistancia;
        }

        // Podemos agregar this, si queremos que el atacado sepa quien es el atacante
        entidadAtacada.recibirDanio(danio, distancia);
    }

    @Override 
    public void recibirDanio(int danio, int distancia) {
        restarVida(danio);
    }

}
