package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.TipoNoPuedeCurarException;

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
        this.vida -= vida;

        if(this.vida <= 0) {
            // TODO Sacar del casillero primero
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
    public void atacar(Entidad atacado, int distancia) {
        /*  - 	Si hay al menos un Soldado de Infantería aliado cerca o no hay ningún enemigo cerca, 
        		su arma de ataque es un Arco y Flecha y únicamente puede atacar a enemigos en distancia media..
			- 	Si no hay ningún aliado cercano y hay enemigos cercanos , su arma de ataque es una Espada y 
				únicamente puede atacar a enemigos en distancia corta.
        */
        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(danio, distancia);
     
    }

    @Override 
    public void curar(Entidad curado, int distancia) {
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
