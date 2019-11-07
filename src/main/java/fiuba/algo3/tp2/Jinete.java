package fiuba.algo3.tp2;

public class Jinete extends Tipo {

	private int vida = 100;
	private int costo = 3;
    private int danioCuerpo = 5;
    private int danioDistancia = 15;

	public Jinete(Jugador propietario) {
		setPropietario(propietario);
	};

    private int obtenerDanio(int distancia) {
        if(distancia == 1)
            return danioCuerpo;
        else
            return danioDistancia;
    }

	@Override
	public int getCosto() {
		return this.costo;
	}

    @Override 
    public int getVida() {
        return this.vida;
    }

    private void restarVida(Entidad entidad, int vida) {
        // Todo: Ver si murio la entidad => hay que sacarlo de la coleccion de entidades del jugador
        this.vida -= vida;

        if(this.vida <= 0) {
            // Sacar del casillero primero
            getPropietario().removerEntidad(entidad);
        }
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
        int danio = obtenerDanio(distancia);
        // Podemos agregar this, si queremos que el atacado sepa quien es el atacante
        entidadAtacada.recibirDanio(danio, distancia);
     
    }

    @Override 
    public void recibirDanio(Entidad entidad, int danio, int distancia) {
        restarVida(entidad, danio);
    }

}
