 package algochess;

 import algochess.engine.facciones.Faccion;
 import algochess.engine.juego.Turno;
 import algochess.engine.jugador.Jugador;
 import algochess.engine.posicion.Posicion;
 import algochess.engine.tablero.Casillero;
 import algochess.engine.tablero.Tablero;
 import org.junit.Test;
 import static org.junit.Assert.assertNotNull;
 import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.junit.jupiter.api.Assertions.assertThrows;


public class TurnoTest {

     @Test
     public void test00CreoUnTurnoYEsValido(){

         Turno turno = new Turno(Faccion.ALIADOS);
         assertNotNull(turno);

     }

    @Test
    public void test01CreoUnTurnoYElPrimerTurnoEsAliado(){

        Turno turno = new Turno(Faccion.ALIADOS);
        assertEquals(turno.popFaccion(), Faccion.ALIADOS);

    }

    @Test
    public void test02CreoUnTurnoYCuandoCambioDeTurnoElTurnoEsDelJugador2(){

        Jugador jugador1 = new Jugador(Faccion.ALIADOS, "Lucas");
        Jugador jugador2 = new Jugador(Faccion.ENEMIGOS, "Guido");

        Turno turno = new Turno(jugador1,jugador2);
        assertEquals(turno.cambiarTurno(jugador1), jugador2);

    }

    @Test
    public void test03CreoUnTurnoYCuandoCambioDeTurnoElTurnoEsDelJugador1SiElTurnoEraDelJugador2(){

        Jugador jugador1 = new Jugador(Faccion.ALIADOS, "Lucas");
        Jugador jugador2 = new Jugador(Faccion.ENEMIGOS, "Guido");

        Turno turno = new Turno(jugador1,jugador2);
        Jugador jugadorTurnado = turno.cambiarTurno(jugador1);

        assertEquals(turno.cambiarTurno(jugadorTurnado), jugador1);

    }









}
