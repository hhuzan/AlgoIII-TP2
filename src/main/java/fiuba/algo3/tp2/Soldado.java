package fiuba.algo3.tp2;

public class Soldado extends Tipo {

    private int vida = 100;
    private int costo = 1;
 
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

    private void restarVida(Entidad entidad,int vida) {
        // TODO: Ver si murio la entidad => hay que sacarlo de la coleccion de entidades del jugador
        // y tambien sacarlo del tablero
    	this.vida -= vida;
    }

    private void sumarVida(int vida) {
        this.vida += vida;
    }
    
    @Override
    public void restarAJugador() {
        getPropietario().restarPuntos(this.costo);
    }

    @Override
    public void atacar(Casillero destino, int distancia) {
        /*  - Puede atacar a un enemigo a corta distancia.
            -   Si hay más de 3 Soldados contiguos (en cualquier dirección) se comportan como un Batallón y 
                PUEDEN moverse los 3 al mismo tiempo en el mismo turno. [Esto significa que cada uno de los 
                soldados se va a mover en la dirección solicitada. En caso que uno no pueda moverse al casillero, 
                únicamente ese Soldado se quedará quieto, y los demás si se moverán]
        */
        int danio = CalculadorDanio.danio(this, 1); 

        // Podemos agregar this, si queremos que el atacado sepa quien es el atacante
        destino.recibirAtaque(danio, distancia);
    }

    @Override 
    public void curar(Casillero destino, int distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override
    public void recibirAtaque(Entidad entidad, int danio, int distancia) {
        restarVida(entidad,danio);
    }

    @Override
    public void recibirCuracion(int curacion, int distancia) {
        sumarVida(curacion);
    }

}
