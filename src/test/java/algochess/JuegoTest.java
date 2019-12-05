package algochess;

import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import javafx.scene.control.Tab;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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

    @Test
    public void test03LaPrimerFaccionEsAliada(){


        Juego juego = new Juego("Lucas", "Guido");
        assertEquals(Faccion.ALIADOS, juego.getFaccionActual());


    }

    @Test
    public void test04CreoUnJuegoYMeDevuelveUnTablero(){


        Juego juego = new Juego("Lucas", "Guido");
        Tablero tablero = juego.getTablero();
        assertNotNull(tablero);

    }

    @Test
    public void test05CreoUnJuegoYPuedoSeleccionarUnaEntidadDeUnCasillero(){


        Juego juego = new Juego("Lucas", "Guido");
       Entidad entidad =  juego.seleccionarEntidad(1,1);
       assertNotNull(entidad);

    }

    @Test
    public void test06CreoUnJuegoYNoPuedoCambiarDeTurnoSiElJugadorNoTerminoDeFase(){

        Juego juego = new Juego("Lucas", "Guido");
        assertFalse(juego.cambiarTurno());

    }

    @Test
    public void test07CreoUnJuegoYNoPuedoComprarUnaEntidadQueNoExiste(){

        Juego juego = new Juego("Lucas", "Guido");
        Assertions.assertThrows(NullPointerException.class, () -> {juego.comprarEntidad(1,1);});


    }











}
