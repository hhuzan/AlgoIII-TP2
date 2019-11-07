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

	@Override
    public void atacar(Entidad atacado, Distancia distancia) {
        throw new TipoNoPuedeAtacarException();
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaCercana distancia) {
        throw new TipoNoPuedeAtacarException();
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaMedia distancia) {
        throw new TipoNoPuedeAtacarException();
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaLejana distancia) {
        throw new TipoNoPuedeAtacarException();
    }

    @Override
    public void curar(Entidad atacado, Distancia distancia) {
        distancia.realizarCuracion(this, atacado);
    }

    @Override
    public void curarEntidad(Entidad curado, DistanciaCercana distancia) {
        /* Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.*/
        int curacion = this.curacion;

        curado.recibirCuracion(curacion);
    }

    @Override
    public void curarEntidad(Entidad curado, DistanciaMedia distancia) {
        throw new EntidadFueraDeAlcanceException();
    }  
      
    @Override
    public void curarEntidad(Entidad curado, DistanciaLejana distancia) {
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
