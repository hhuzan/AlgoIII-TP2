package fiuba.algo3.tp2;

import fiuba.algo3.tp2.Excepciones.TipoNoPuedeCurarException;

public class Jinete extends Tipo {

	private int vida = 100;
	private int costo = 3;

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

    private void restarVida(Entidad entidad, int vida) {
        // Todo: Ver si murio la entidad => hay que sacarlo de la coleccion de entidades del jugador
        this.vida -= vida;

        if(this.vida <= 0) {
            // Sacar del casillero primero
            getPropietario().removerEntidad(entidad);
        }
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
        /*  - 	Si hay al menos un Soldado de Infantería aliado cerca o no hay ningún enemigo cerca, 
        		su arma de ataque es un Arco y Flecha y únicamente puede atacar a enemigos en distancia media..
			- 	Si no hay ningún aliado cercano y hay enemigos cercanos , su arma de ataque es una Espada y 
				únicamente puede atacar a enemigos en distancia corta.
        */
        int danio = CalculadorDanio.danio(this,distancia);
        destino.recibirAtaque(danio, distancia);
     
    }

    @Override 
    public void curar(Casillero destino, int distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override
    public void recibirAtaque(Entidad entidad, int danio, int distancia) {
        restarVida(entidad, danio);
    }

    @Override
    public void recibirCuracion(int curacion, int distancia) {
        sumarVida(curacion);
    }
}
