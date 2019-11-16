package AlgoChess.engine.vendedorDeEntidades;

import AlgoChess.engine.Dinero;
import AlgoChess.engine.entidades.Entidad;

public class VendedorDeEntidades {
    public Entidad venderEntidad(Entidad entidad, Dinero pago) {
        if (entidad.getCosto().sonIguales(pago)) {
            return entidad;
        }
        return null;
    }

}
