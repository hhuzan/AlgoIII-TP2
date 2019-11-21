package algochess;

import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Jinete;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.vendedorDeEntidades.VendedorDeEntidades;
import algochess.excepciones.DineroInsuficienteException;
import algochess.excepciones.EntidadDeMismaFaccionException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static algochess.engine.ConstantesUtils.*;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

    @Test
    public void test00ConstructorCuranderoNoDevuelveNull() {
        Jugador jugador = new Jugador(Faccion.ALIADOS);
        assertNotNull(jugador);
    }


    @Test
    public void test01NoSePuedenComprarInfinitasEntidadesConDineroFinito() throws DineroInsuficienteException {
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");
        Catapulta catapulta = new Catapulta(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        VendedorDeEntidades vendedor = new VendedorDeEntidades();

        for (int i = 0; i<(DINERO_JUGADOR/CATAPULTA_COSTO);i++){
            jugador.comprarEntidad(vendedor,catapulta);
        }

        assertThrows(DineroInsuficienteException.class,()-> jugador.comprarEntidad(vendedor,catapulta));
    }

    @Test
    public void test02JugadorSinEntidadesPierde(){
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");

        assertTrue(jugador.perdio());

    }


    @Test
    public void test03JugadorNoPuedeComprarEntidadesDeOtraFaccion(){
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");
        Jinete jinete = new Jinete(new Jugador(Faccion.ENEMIGOS, "Lucas"), Faccion.ENEMIGOS);

        assertThrows(EntidadDeMismaFaccionException.class,()-> jugador.comprarEntidad(new VendedorDeEntidades(), jinete));

    }
    

    @Test
    public void test04CreoUnJugadorConUnaFaccionYObtengoLaFaccionQueLeColoque(){
        Jugador jugador = new Jugador(Faccion.ALIADOS,"Pedro");
       assertEquals(Faccion.ALIADOS, jugador.getFaccion());

    }



}