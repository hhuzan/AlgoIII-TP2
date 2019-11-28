package algochess;

import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Turno;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TurnoTest {

    @Test
    public void test00CreoUnTurnoYEsValido(){

        Turno turno = new Turno(Faccion.ALIADOS);
        assertNotNull(turno);

    }







}
