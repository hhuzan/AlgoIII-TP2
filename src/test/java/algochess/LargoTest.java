package algochess;

import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.armas.rangos.Largo;
import algochess.engine.entidades.armas.rangos.Rango;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Casillero;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LargoTest {

    @Test
    public void test00CreoUnRangoCercanoYNoEsNull(){

        Rango rangoLargo = new Largo();

        assertNotNull(rangoLargo);

    }

    @Test
    public void test01CasilleroQueNoEstaEnRangoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(1,1);
        Posicion origen = new Posicion(2,2);

        Rango rangoLargo = new Largo();
        Casillero casillero = new Casillero(posicion, Faccion.ALIADOS, jinete);
        assertFalse(rangoLargo.casilleroEstaEnRango(casillero, origen));

    }

    @Test
    public void test02CasilleroQueEstaEnRangoNoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(20,20);
        Posicion origen = new Posicion(2,2);

        Rango rangoLargo = new Largo();
        Casillero casillero = new Casillero(posicion, Faccion.ALIADOS, jinete);
        assertTrue(rangoLargo.casilleroEstaEnRango(casillero, origen));

    }


}
