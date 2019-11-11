package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.TipoNoPuedeAtacarException;
import fiuba.algo3.tp2.excepciones.EntidadFueraDeAlcanceException;

public class Curandero extends Tipo {

	private int vida = 75;
	private int costo = 2;
    private int curacion = 15;

	public Curandero(Jugador propietario) {
		setPropietario(propietario);
	}

	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

    private void restarVida(Entidad entidad, int vida) {
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
		getPropietario().restarPuntos(costo);
	}

    /* ENTIDAD - ENTIDAD */
    @Override
    public void curar(Entidad atacante, Entidad atacado, Distancia distancia) {
        distancia.realizarCuracion(this, atacante, atacado);
    }

    @Override
    public void curacion(Entidad atacante, Entidad curado, DistanciaCercana distancia) {
        /* Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.*/
        int curacion = this.curacion;
        curado.recibirCuracion(atacante, curacion);
    }

    @Override
    public void curacion(Entidad atacante, Entidad curado, DistanciaMedia distancia) {
        throw new EntidadFueraDeAlcanceException();
    }  
      
    @Override
    public void curacion(Entidad atacante, Entidad curado, DistanciaLejana distancia) {
        throw new EntidadFueraDeAlcanceException();
    }
    /* --------------------------------------------- */
    /* CASILLERO - CASILLERO */
    @Override
    public void curar(Entidad atacante, Casillero destino, Distancia distancia) {
        distancia.realizarCuracion(this, atacante, destino);
    }

    @Override
    public void curacion(Entidad atacante, Casillero casilleroDestino, DistanciaCercana distancia) {
        /* Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.*/
        int curacion = this.curacion;
        casilleroDestino.recibirCuracion(atacante, curacion);
    }

    @Override
    public void curacion(Entidad atacante, Casillero destino, DistanciaMedia distancia) {
        throw new EntidadFueraDeAlcanceException();
    }  
      
    @Override
    public void curacion(Entidad atacante, Casillero destino, DistanciaLejana distancia) {
        throw new EntidadFueraDeAlcanceException();
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
