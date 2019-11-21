package AlgoChess;

import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.armas.rangos.Medio;
import AlgoChess.engine.entidades.armas.rangos.Rango;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.tablero.Ocupado;
import org.junit.Test;
import static org.junit.Assert.*;

public class MedioTest {

    @Test
    public void Test00CreoUnRangoCercanoYNoEsNull(){

        Rango rangoMedio = new Medio();

        assertNotNull(rangoMedio);

    }

    @Test
    public void Test01CasilleroQueEstaEnRangoNoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(6,6);
        Posicion origen = new Posicion(2,2);

        Rango rangoMedio = new Medio();
        Casillero casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertTrue(rangoMedio.casilleroEstaEnRango(casillero, origen));

    }

    @Test
    public void Test02CasilleroNoQueEstaEnRangoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(1,1);
        Posicion origen = new Posicion(2,2);

        Rango rangoMedio = new Medio();
        Recuadro casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertFalse(rangoMedio.casilleroEstaEnRango(casillero, origen));

    }



}
