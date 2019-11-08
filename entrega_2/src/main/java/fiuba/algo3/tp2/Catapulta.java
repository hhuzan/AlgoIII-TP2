package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.TipoNoPuedeCurarException;
import fiuba.algo3.tp2.excepciones.TipoNoPuedeSerCuradoException;
import fiuba.algo3.tp2.excepciones.EntidadFueraDeAlcanceException;

public class Catapulta extends Tipo {
/*  - No puede moverse en toda la partida.
    - Ataca en una distancia lejana únicamente. [Puede dañar tanto a Enemigos como Aliados]
    - Causa daño a la primera unidad enemiga alcanzada, y a todas las unidades directamente contiguas, 
    y si a su vez la segunda unidad tiene otra unidad contigua, también causa el mismo daño 
    (y así sucesivamente)
*/
	private int vida = 50;
    private int costo = 5;
    
	public Catapulta(Jugador propietario) {
		setPropietario(propietario);
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
        this.vida -= vida;

        if(this.vida <= 0) {
            // Sacar del casillero primero
            getPropietario().removerEntidad(entidad);
        }
    }

    @Override
    public void restarAJugador() {
        getPropietario().restarPuntos(costo);
    }

    @Override 
    public void atacar(Entidad atacado, Distancia distancia) {
        distancia.realizarAtaque(this, atacado);
    }

    @Override 
    public void atacarEntidad(Entidad atacado, DistanciaCercana distancia) {
        throw new EntidadFueraDeAlcanceException();
    }

    @Override 
    public void atacarEntidad(Entidad atacado, DistanciaMedia distancia) {
        throw new EntidadFueraDeAlcanceException();
    }  

    @Override 
    public void atacarEntidad(Entidad atacado, DistanciaLejana distancia) {
        int danio = CalculadorDanioUtils.danio(this,distancia);
        atacado.recibirAtaque(danio);
    }

    @Override 
    public void recibirAtaque(Entidad entidad, int danio) {
        restarVida(entidad, danio);
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
    public void recibirCuracion(int curacion) {
        throw new TipoNoPuedeSerCuradoException();
    }
}