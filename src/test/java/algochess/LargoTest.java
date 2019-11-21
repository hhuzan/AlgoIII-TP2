package algochess;

import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.armas.rangos.Largo;
import algochess.engine.entidades.armas.rangos.Rango;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Ocupado;
import org.junit.Test;
import static org.junit.Assert.*;

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
        Casillero casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertFalse(rangoLargo.casilleroEstaEnRango(casillero, origen));

    }

    @Test
    public void test02CasilleroQueEstaEnRangoNoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(20,20);
        Posicion origen = new Posicion(2,2);

        Rango rangoLargo = new Largo();
        Casillero casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertTrue(rangoLargo.casilleroEstaEnRango(casillero, origen));

    }


}
