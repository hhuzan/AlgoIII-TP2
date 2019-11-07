package fiuba.algo3.tp2;

import java.util.List;
import java.util.ArrayList;

public class Jugador {

	private List<Entidad> entidades = new ArrayList<Entidad>();
	private CreadorEntidades creadorEntidades;
	private int puntos = 20;

	public Jugador() {  //TODO ver como queda el constructor
		
	}
	
	public Jugador(CreadorEntidades creadorEntidades) {
		this.creadorEntidades = creadorEntidades;
	}

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
		agregar(creadorEntidades.crearSoldado(this));
	}

	public void agregarJinete() {
		agregar(creadorEntidades.crearJinete(this));
	}

	public void agregarCurandero() {
		agregar(creadorEntidades.crearCurandero(this));
	}

	public void agregarCatapulta() {
		agregar(creadorEntidades.crearCatapulta(this));
	}

	public void agregar(Entidad entidad) { // TODO revisar
		try {
			restarPuntos(entidad.getCosto());
			entidades.add(entidad);
		}
		catch (PuntosInsuficientesException e) {
			throw e;
		}
	}

	public void removerEntidad(Entidad entidad) {
		entidades.remove(entidad);
		if(entidades.size() == 0)
			throw new JugadorPierdeException();
	}

}
