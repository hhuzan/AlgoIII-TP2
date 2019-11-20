package AlgoChess.engine.vendedorDeEntidades;

import AlgoChess.engine.Dinero;
import AlgoChess.engine.entidades.Entidad;
import AlgoChess.excepciones.DineroInsuficienteException;

public class VendedorDeEntidades {
    public Entidad venderEntidad(Entidad entidad, Dinero pago){
        if (entidad.costosIguales(pago)) {
            return entidad;
        }

        else {throw new DineroInsuficienteException();}

    }

}
