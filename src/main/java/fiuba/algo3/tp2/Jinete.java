package fiuba.algo3.tp2;

public class Jinete extends Tipo {

	private int vida = 100;
	private int costo = 3;
    private int danioCuerpo = 5;
    private int danioDistancia = 15;

	public Jinete(Jugador propietario) {
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
        /*  - 	Si hay al menos un Soldado de Infantería aliado cerca o no hay ningún enemigo cerca, 
        		su arma de ataque es un Arco y Flecha y únicamente puede atacar a enemigos en distancia media..
			- 	Si no hay ningún aliado cercano y hay enemigos cercanos , su arma de ataque es una Espada y 
				únicamente puede atacar a enemigos en distancia corta.
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
