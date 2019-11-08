package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.CasilleroOcupadoException;

public interface Estado {

	public Estado colocar(Entidad entidad) throws CasilleroOcupadoException;
	public Entidad getEntidad();
	public Estado moverDesde(Casillero origen);

}
