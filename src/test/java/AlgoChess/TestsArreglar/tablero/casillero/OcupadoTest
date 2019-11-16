package AlgoChess.tablero.casillero;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Ocupado;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import AlgoChess.engine.tablero.Vacio;
import org.junit.Test;

public class OcupadoTest {
    @Test
    public void Test00SeCreaCasilleroOcupado(){
        Jinete jinete = new Jinete();
        Posicion posicion = new Posicion(1,1);
        Faccion faccion = new Faccion();
        Ocupado ocupado = new Ocupado(jinete,posicion,faccion);

        assertNotNull(ocupado);
    }

    @Test
    public void Test01ConstructorAsignaAtributosCorrectamente(){
        Jinete jinete = new Jinete();
        Posicion posicion = new Posicion(1,1);
        Faccion faccion = new Faccion();

        Ocupado ocupado = new Ocupado(jinete,posicion,faccion);

        assertTrue(ocupado.tienesLaEntidad(jinete));
        assertEquals(posicion,ocupado.getPosicion());
        assertEquals(faccion,ocupado.getFaccion());
    }

    @Test
    public void Test02RemoverEntidadDevuelveCasilleroVacio(){
        Jinete jinete = new Jinete();
        Posicion posicion = new Posicion(1,1);
        Faccion faccion = new Faccion();

        Ocupado ocupado = new Ocupado(jinete,posicion,faccion);

        Vacio vacio = ocupado.removerEntidad();

        assertNotNull(vacio);
    }

    @Test
    public void Test03CasilleroVacioDevueltoPoseeMismaFaccion(){
        Jinete jinete = new Jinete();
        Posicion posicion = new Posicion(1,1);
        Faccion faccion = new Faccion();

        Ocupado ocupado = new Ocupado(jinete,posicion,faccion);
        Vacio vacio = ocupado.removerEntidad();

        assertEquals(faccion,vacio.getFaccion());
    }

    @Test
    public void Test04CasilleroVacioDevueltoPoseeMismaPosicion(){
        Jinete jinete = new Jinete();
        Posicion posicion = new Posicion(1,1);
        Faccion faccion = new Faccion();

        Ocupado ocupado = new Ocupado(jinete,posicion,faccion);
        Vacio vacio = ocupado.removerEntidad();

        assertEquals(posicion,vacio.getPosicion());
    }


}
