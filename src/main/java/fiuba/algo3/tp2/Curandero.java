package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.TipoNoPuedeAtacarException;

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
    public void atacar(Entidad atacado, int distancia) {
        throw new TipoNoPuedeAtacarException();
    }

    @Override 
    public void curar(Entidad curado, int distancia) {
        /*Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.*/
        int curacion = this.curacion;

        curado.recibirCuracion(curacion, distancia);
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
