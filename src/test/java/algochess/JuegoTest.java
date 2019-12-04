package algochess;

import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.jugador.Jugador;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;

public class JuegoTest {

    @Test
    public void test00CreoUnJuegoYNoTiraNull(){

        Juego juego = new Juego("Lucas", "Guido");
        assertNotNull(juego);

    }

    @Test
    public void test01SeleccionoUnaEntidadYObtengoLaSeleccionada(){

        Jugador jugador = new Jugador(Faccion.ALIADOS, "lucas");
        Entidad jinete = new Jinete(jugador,Faccion.ALIADOS);

        Juego juego = new Juego("Lucas", "Guido");
        juego.seleccionarEntidad(jinete);
        assertEquals(juego.obtenerEntidadSeleccionada(), jinete);


    }

    @Test
    public void test02LiberoUnaEntidadSeleccionadaYSiQuieroObtenerlaMeDevuelveNull(){

        Jugador jugador = new Jugador(Faccion.ALIADOS, "lucas");
        Entidad jinete = new Jinete(jugador,Faccion.ALIADOS);

        Juego juego = new Juego("Lucas", "Guido");
        juego.seleccionarEntidad(jinete);
        juego.liberarEntidadSeleccionada();
        assertNull(juego.obtenerEntidadSeleccionada());


    }








}
