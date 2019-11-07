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
    public void atacar(Entidad atacado, Distancia distancia) {
        distancia.realizarAtaque(this, atacado);
    }
    
    @Override
    public void atacarEntidad(Entidad atacado, DistanciaCercana distancia) {

        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(danio);
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaMedia distancia) {


        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(danio);
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaLejana distancia) {

        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(danio);   

    }

    @Override 
    public void curar(Entidad curado, Distancia distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override 
    public void curarEntidad(Entidad curado, DistanciaCercana distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override 
    public void curarEntidad(Entidad curado, DistanciaMedia distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override 
    public void curarEntidad(Entidad curado, DistanciaLejana distancia) {
        throw new TipoNoPuedeCurarException();
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
