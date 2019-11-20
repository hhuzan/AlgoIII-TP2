package AlgoChess;

import AlgoChess.engine.entidades.Catapulta;
import AlgoChess.engine.entidades.Curandero;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import AlgoChess.excepciones.DineroInsuficienteException;
import AlgoChess.excepciones.DineroInsuficienteException;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.excepciones.JugadorPerdioException;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static AlgoChess.engine.Constantes.*;
import static org.junit.Assert.assertTrue;


public class JugadorTest {

    @Test
    public void test00ConstructorCuranderoNoDevuelveNull() {
        Jugador jugador = new Jugador(Faccion.ALIADOS);
        assertNotNull(jugador);
    }


    @Test
    public void Test01NoSePuedenComprarInfinitasEntidadesConDineroFinito() throws DineroInsuficienteException {
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");
        Catapulta catapulta = new Catapulta(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        for (int i = 0; i<(DINERO_JUGADOR/CATAPULTA_COSTO);i++){
            jugador.comprarEntidad(vendedor,catapulta);
        }

        assertThrows(DineroInsuficienteException.class,()-> jugador.comprarEntidad(vendedor,catapulta));
    }

    @Test
    public void Test02JugadorSinEntidadesPierde(){
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");

        assertTrue(jugador.perdio());

    }


    @Test
    public void Test03JugadorNoPuedeComprarEntidadesDeOtraFaccion(){
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS, "Lucas"), Faccion.ENEMIGOS);

        assertThrows(EntidadDeMismaFaccionException.class,()-> jugador.comprarEntidad(new VendedorDeEntidades(), jinete));

    }
    

    @Test
    public void Test04CreoUnJugadorConUnaFaccionYObtengoLaFaccionQueLeColoque(){
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");
       assertEquals(Faccion.ALIADOS, jugador.getFaccion());

    }



}