package fiuba.algo3.tp2;

public class CreadorEnemigo implements CreadorEntidades {

	@Override
	public Entidad crearSoldado(Jugador jugador) {
		return new Enemigo(new Soldado(jugador));
	}

	@Override
	public Entidad crearJinete(Jugador jugador) {
		return new Enemigo(new Jinete(jugador));
	}

	@Override
	public Entidad crearCurandero(Jugador jugador) {
		return new Enemigo(new Curandero(jugador));
	}

	@Override
	public Entidad crearCatapulta(Jugador jugador) {
		return new Enemigo(new Catapulta(jugador));
	}

}
