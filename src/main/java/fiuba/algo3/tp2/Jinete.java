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

    /* ENTIDAD - ENTIDAD */
    /* ATAQUES */
    @Override 
    public void atacar(Entidad atacante, Entidad atacado, Distancia distancia) {
        distancia.realizarAtaque(this, atacante, atacado);
    }
    
    @Override
    public void ataque(Entidad atacante, Entidad atacado, DistanciaCercana distancia) {
        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(atacante, danio);
    }

    @Override
    public void ataque(Entidad atacante, Entidad atacado, DistanciaMedia distancia) {
        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(atacante, danio);
    }

    @Override
    public void ataque(Entidad atacante, Entidad atacado, DistanciaLejana distancia) {
        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(atacante, danio);   
    }

    /* -------------------------------------------------------- */
    /* CASILLERO - CASILLERO */
    /* ATAQUES */
    @Override 
    public void atacar(Entidad atacante, Casillero destino, Distancia distancia) {
        distancia.realizarAtaque(this, atacante, destino);
    }
    
    @Override
    public void ataque(Entidad atacante, Casillero casilleroDestino, DistanciaCercana distancia) {
        int danio = CalculadorDanioUtils.danio(this,distancia);
        casilleroDestino.recibirAtaque(atacante, danio);
    }

    @Override
    public void ataque(Entidad atacante, Casillero casilleroDestino, DistanciaMedia distancia) {
        int danio = CalculadorDanioUtils.danio(this,distancia);
        casilleroDestino.recibirAtaque(atacante, danio);
    }

    @Override
    public void ataque(Entidad atacante, Casillero casilleroDestino, DistanciaLejana distancia) {
        int danio = CalculadorDanioUtils.danio(this,distancia);
        casilleroDestino.recibirAtaque(atacante, danio);   
    }

    @Override
    public void recibirAtaque(Entidad entidad, int danio) {
        restarVida(entidad, danio);
    }

    @Override
    public void recibirCuracion(int curacion) {
        sumarVida(curacion);
    }
}
