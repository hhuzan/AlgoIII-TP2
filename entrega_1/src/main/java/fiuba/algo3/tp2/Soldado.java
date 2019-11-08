package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.TipoNoPuedeCurarException;
import fiuba.algo3.tp2.excepciones.EntidadFueraDeAlcanceException;

public class Soldado extends Tipo {
/*  - Puede atacar a un enemigo a corta distancia.
    -   Si hay más de 3 Soldados contiguos (en cualquier dirección) se comportan como un Batallón y 
        PUEDEN moverse los 3 al mismo tiempo en el mismo turno. [Esto significa que cada uno de los 
        soldados se va a mover en la dirección solicitada. En caso que uno no pueda moverse al casillero, 
        únicamente ese Soldado se quedará quieto, y los demás si se moverán]
*/
    private int vida = 100;
    private int costo = 1;
 
    public Soldado(Jugador propietario) {
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

    private void restarVida(Entidad entidad,int vida) {
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
        int danio = CalculadorDanioUtils.danio(this, distancia); 

        // Podemos agregar this, si queremos que el atacado sepa quien es el atacante
        atacado.recibirAtaque(danio);
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaMedia distancia) {
        throw new EntidadFueraDeAlcanceException();
    }

    @Override
    public void atacarEntidad(Entidad atacado, DistanciaLejana distancia) {
        throw new EntidadFueraDeAlcanceException();
    }

    @Override 
    public void curar(Entidad curador, Distancia distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override 
    public void curarEntidad(Entidad curador, DistanciaCercana distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override 
    public void curarEntidad(Entidad curador, DistanciaMedia distancia) {
        throw new TipoNoPuedeCurarException();
    }

    @Override 
    public void curarEntidad(Entidad curador, DistanciaLejana distancia) {
        throw new TipoNoPuedeCurarException();
    }
    
    @Override
    public void recibirAtaque(Entidad entidad, int danio) {
        restarVida(entidad,danio);
    }

    @Override
    public void recibirCuracion(int curacion) {
        sumarVida(curacion);
    }

}
