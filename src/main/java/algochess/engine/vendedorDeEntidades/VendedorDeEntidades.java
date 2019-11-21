package algochess.engine.vendedorDeEntidades;

import algochess.engine.Dinero;
import algochess.engine.entidades.Entidad;
import algochess.excepciones.DineroInsuficienteException;

public class VendedorDeEntidades {
	public Entidad venderEntidad(Entidad entidad, Dinero pago) {
		if (entidad.costosIguales(pago)) {
			return entidad;
		}

		else {
			throw new DineroInsuficienteException();
		}
	}

}
