package fiuba.algo3.tp2;

import java.util.List;
import java.util.ArrayList;

public class Jugador {

	private List<Entidad> entidades = new ArrayList<Entidad>();
	private CreadorEntidades creadorEntidades;

	private int puntos = 20;

	public void restarPuntos(int puntos) throws PuntosInsuficientesException {
		if (this.puntos >= puntos)
			this.puntos -= puntos;
		else
			throw new PuntosInsuficientesException();
	}

	public int getPuntos() {

		return this.puntos;
	}

	public void agregarSoldado() {
		agregar(creadorEntidades.CrearSoldado(this));
	}

	public void agregarJinete() {
		agregar(creadorEntidades.CrearJinete(this));
	}

	public void agregarCurandero() {
		agregar(creadorEntidades.CrearCurandero(this));
	}

	public void agregarCatapulta() {
		agregar(creadorEntidades.CrearCatapulta(this));
	}

	public void agregar(Entidad entidad) {
		restarPuntos(entidad.getCosto());
		entidades.add(entidad);
	}

}
