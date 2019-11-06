package fiuba.algo3.tp2;

public class CreadorAliado implements CreadorEntidades {

	@Override
	public Entidad CrearSoldado(Jugador jugador) {
		return new Aliado(new Soldado(jugador));
	}

	@Override
	public Entidad CrearJinete(Jugador jugador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidad CrearCurandero(Jugador jugador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidad CrearCatapulta(Jugador jugador) {
		// TODO Auto-generated method stub
		return null;
	}

}
