package fiuba.algo3.tp2;

public class CreadorAliado implements CreadorEntidades {

	@Override
	public Entidad crearSoldado(Jugador jugador) {
		return new Aliado(new Soldado(jugador));
	}

	@Override
	public Entidad crearJinete(Jugador jugador) {
		return new Aliado(new Jinete(jugador));
	}

	@Override
	public Entidad crearCurandero(Jugador jugador) {
		return new Aliado(new Curandero(jugador));
	}

	@Override
	public Entidad crearCatapulta(Jugador jugador) {
		return new Aliado(new Catapulta(jugador));
	}

}
