package algochess;

import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.armas.rangos.Medio;
import algochess.engine.entidades.armas.rangos.Rango;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Ocupado;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MedioTest {

    @Test
    public void test00CreoUnRangoCercanoYNoEsNull(){

        Rango rangoMedio = new Medio();

        assertNotNull(rangoMedio);

    }

    @Test
    public void test01CasilleroQueEstaEnRangoNoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(6,6);
        Posicion origen = new Posicion(2,2);

        Rango rangoMedio = new Medio();
        Casillero casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertTrue(rangoMedio.casilleroEstaEnRango(casillero, origen));

    }

    @Test
    public void test02CasilleroNoQueEstaEnRangoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(1,1);
        Posicion origen = new Posicion(2,2);

        Rango rangoMedio = new Medio();
        Recuadro casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertFalse(rangoMedio.casilleroEstaEnRango(casillero, origen));

    }

}
