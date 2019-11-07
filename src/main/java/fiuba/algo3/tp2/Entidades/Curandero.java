<<<<<<< HEAD:src/main/java/fiuba/algo3/tp2/Entidades/Curandero.java
package fiuba.algo3.tp2;

public class Curandero extends Tipo {

	private int vida = 75;
	private int costo = 2;

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
        // Todo: Ver si murio la entidad => hay que sacarlo de la coleccion de entidades del jugador
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
	public void atacar(Casillero destino, int distancia) {
		/*
		 * Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia
		 * cercana.
		 */

	}

	@Override
	public void recibirAtaque(Entidad entidad, int danio, int distancia) {
		restarVida(entidad, danio);
	}

}
=======
package fiuba.algo3.tp2;

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
		getPropietario().restarPuntos(costo);
	}

	@Override
    public void atacar(Casillero destino, int distancia) {
        throw new TipoNoPuedeAtacarException();
    }

    @Override 
    }
        destino.recibirCuracion(curacion, distancia);

        int curacion = this.curacion;
        /*Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.*/
    public void curar(Casillero destino, int distancia) {

	@Override
	public void recibirAtaque(Entidad entidad, int danio, int distancia) {
		restarVida(entidad, danio);
	}

    @Override
    public void recibirCuracion(int curacion, int distancia) {
        sumarVida(curacion);
    }
}
>>>>>>> master:src/main/java/fiuba/algo3/tp2/Curandero.java
