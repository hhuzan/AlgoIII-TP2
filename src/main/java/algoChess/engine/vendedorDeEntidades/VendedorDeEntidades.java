package algoChess.engine.vendedorDeEntidades;

import algoChess.engine.Dinero;
import algoChess.engine.entidades.Entidad;
import algoChess.excepciones.DineroInsuficienteException;

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
