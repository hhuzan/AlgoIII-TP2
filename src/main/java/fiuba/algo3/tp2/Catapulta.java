package fiuba.algo3.tp2;

public class Catapulta extends Tipo {

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
        /*  - No puede moverse en toda la partida.
			- Ataca en una distancia lejana únicamente. [Puede dañar tanto a Enemigos como Aliados]
			- Causa daño a la primera unidad enemiga alcanzada, y a todas las unidades directamente contiguas, 
			y si a su vez la segunda unidad tiene otra unidad contigua, también causa el mismo daño 
			(y así sucesivamente)
        */
        int danio = CalculadorDanio.danio(this,distancia);
        System.out.println("Catapulta ataca");
        System.out.println(danio);
        destino.recibirAtaque(danio, distancia);
    }

    @Override 
    public void recibirAtaque(Entidad entidad, int danio, int distancia) {
        restarVida(entidad, danio);
    }
}
