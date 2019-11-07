package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.TipoNoPuedeCurarException;

public class Jinete extends Tipo {
/*  -   Si hay al menos un Soldado de Infantería aliado cerca o no hay ningún enemigo cerca, 
        su arma de ataque es un Arco y Flecha y únicamente puede atacar a enemigos en distancia media..
    -   Si no hay ningún aliado cercano y hay enemigos cercanos , su arma de ataque es una Espada y 
        únicamente puede atacar a enemigos en distancia corta.
*/
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
        // Arco y flecha:   Verificar que hay al menos un Soldado de Infantería aliado cerca o
        //                  no hay ningun enemigo cerca 
        // -> Debemos ver si se cumple arco y flecha tenemos que tirar excepción que no se puede
        // -> usar este ataque de distancia corta 

        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(danio);
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaMedia distancia) {
        // Espada: Verificar que no hay ningún aliado cercano y hay enemigos cercanos
        // -> Debemos ver si se cumple la espada tenemos que tirar excepción que no se puede
        // -> usar este ataque de distancia media

        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(danio);
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaLejana distancia) {
        //  Debemos verificar que no tenga que usar Espada ni Arco y Flecha, en ese caso podemos atacar
        //  de distancia lejana 
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
