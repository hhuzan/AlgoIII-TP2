package AlgoChess.pruebasCatedra.entrega1;

import AlgoChess.engine.entidades.Catapulta;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import AlgoChess.excepciones.DineroInsuficienteException;
import AlgoChess.excepciones.NoMePagasteSuficienteException;
import org.junit.Test;

import static AlgoChess.engine.Constantes.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorTest {

    @Test
    public void Test00NoSePuedenComprarInfinitasEntidadesConDineroFinito() throws DineroInsuficienteException, NoMePagasteSuficienteException {
        Faccion faccion = new Faccion();
        Jugador jugador = new Jugador(faccion,"Pedro");
        Catapulta catapulta = new Catapulta();
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        for (int i = 0; i<(DINERO_JUGADOR/CATAPULTA_COSTO);i++){
            jugador.comprarEntidad(vendedor,catapulta);
        }

        assertThrows(DineroInsuficienteException.class,()-> jugador.comprarEntidad(vendedor,catapulta));
    }

    @Test
    public void Test01JugadorSinEntidadesPierde(){
        Jugador jugador = new Jugador(new Faccion(),"Pedro");

        assertTrue(jugador.perdio());

    }
}
