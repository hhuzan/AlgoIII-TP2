package algoChess;

import algoChess.engine.entidades.Jinete;
import algoChess.engine.entidades.armas.rangos.Medio;
import algoChess.engine.entidades.armas.rangos.Rango;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.jugador.Jugador;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Casillero;
import algoChess.engine.tablero.Ocupado;
import org.junit.Test;
import static org.junit.Assert.*;

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
