package algochess;

import algochess.engine.comandante.Comandante;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.armas.rangos.Cercano;
import algochess.engine.entidades.armas.rangos.Rango;
import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.posicion.Posiciones;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Ocupado;

import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Vacio;
import javafx.geometry.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class PosicionesTest {
    @Test
    public void test00constructorNoNulo(){
        Posiciones posiciones = new Posiciones();
        assertNotNull(posiciones);
    }
    @Test
    public void test01posicionesPoseeConjuntoVacio(){
        Posiciones posiciones = new Posiciones();
        assertEquals(0, posiciones.posiciones().size());
    }

    @Test
    public void test02seAgregaPosicion(){
        Posiciones posiciones = new Posiciones();
        posiciones.agregar(new Posicion(1,1));
        assertEquals(1, posiciones.posiciones().size());
    }

    @Test
    public void test03seAgregaPosicionRepetida(){
        Posiciones posiciones = new Posiciones();
        posiciones.agregar(new Posicion(1,1));
        posiciones.agregar(new Posicion(1,1));
        assertEquals(1, posiciones.posiciones().size());
    }

    @Test
    public void test04posicionesContienePosicion(){
        Posiciones posiciones = new Posiciones();
        posiciones.agregar(new Posicion(1,1));
        assertTrue(posiciones.contiene(new Posicion(1, 1)));
    }

    @Test
    public void test05posicionesRemuevePosicion(){
        Posiciones posiciones = new Posiciones();
        Posicion posicion = new Posicion(1,1);
        posiciones.agregar(posicion);
        posiciones.remover(posicion);
        assertEquals(0, posiciones.posiciones().size());
    }



}

