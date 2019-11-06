package fiuba.algo3.tp2;

public class CreadorEnemigo implements CreadorEntidades {

	@Override
	public Entidad CrearSoldado(Jugador jugador) {
		return new Enemigo(new Soldado(jugador));
	}

	@Override
	public Entidad CrearJinete(Jugador jugador) {
		return new Enemigo(new Jinete(jugador));
	}

	@Override
	public Entidad CrearCurandero(Jugador jugador) {
		return new Enemigo(new Curandero(jugador));
	}

	@Override
	public Entidad CrearCatapulta(Jugador jugador) {
		return new Enemigo(new Catapulta(jugador));
	}

}
