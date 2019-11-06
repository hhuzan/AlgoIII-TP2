package fiuba.algo3.tp2;

public class CreadorAliado implements CreadorEntidades {

	@Override
	public Entidad CrearSoldado(Jugador jugador) {
		return new Aliado(new Soldado(jugador));
	}

	@Override
	public Entidad CrearJinete(Jugador jugador) {
		return new Aliado(new Jinete(jugador));
	}

	@Override
	public Entidad CrearCurandero(Jugador jugador) {
		return new Aliado(new Curandero(jugador));
	}

	@Override
	public Entidad CrearCatapulta(Jugador jugador) {
		return new Aliado(new Catapulta(jugador));
	}

}
