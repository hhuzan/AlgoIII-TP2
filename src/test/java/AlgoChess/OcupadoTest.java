package AlgoChess;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.Soldado;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Ocupado;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.excepciones.CasilleroOcupadoException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;

public class OcupadoTest {
    @Test
    public void test00SeCreaCasilleroOcupado(){
        Jinete jinete = new Jinete();
        Posicion posicion = new Posicion(1,1);
        Ocupado ocupado = new Ocupado(jinete,posicion,Faccion.ALIADOS);

        assertNotNull(ocupado);
    }


    @Test
    public void test01ConstructorAsignaAtributosCorrectamente(){
        Jinete jinete = new Jinete();
        Posicion posicion = new Posicion(1,1);

        Ocupado ocupado = new Ocupado(jinete,posicion,Faccion.ALIADOS);

        assertTrue(ocupado.poseesUnidad());
        assertEquals(posicion,ocupado.getPosicion());
        assertEquals(Faccion.ALIADOS,ocupado.getFaccion());
    }


    @Test
    public void test02IntentoColocarUnaEntidadEnUnCasilleroOcupadoYTiraError(){
        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Jinete jinete2 = new Jinete();
        jinete2.setFaccion(Faccion.ALIADOS);
        Posicion posicion = new Posicion(1,1);
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        tablero.colocarEntidad(jinete, posicion);
        assertThrows(CasilleroOcupadoException.class, () -> {
            tablero.colocarEntidad(jinete2,posicion);
        });

    }

    @Test
    public void test03CasilleroVacioDevueltoPoseeMismaFaccion(){
        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,2);
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        tablero.colocarEntidad(jinete, posicion);
        tablero.moverEntidad(posicion, posicion2, Faccion.ALIADOS);
        assertEquals(tablero.obtenerCasillero(posicion).getFaccion(), Faccion.ALIADOS);
    }


    @Test
    public void test04CasilleroVacioDevueltoPoseeMismaPosicion(){
        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,2);
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        tablero.colocarEntidad(jinete, posicion);
        tablero.moverEntidad(posicion, posicion2, Faccion.ALIADOS);
        assertEquals(tablero.obtenerCasillero(posicion).getPosicion().getFila(),posicion.getFila() );
        assertEquals(tablero.obtenerCasillero(posicion).getPosicion().getColumna(),posicion.getColumna());
    }

    @Test
    public void test05SacoUnaEntidadDelCasilleroYPuedoVolverAPonerOtra(){
        // este test tambien prueba que al mover una entidad de un casillero ocupado este pasa a ser vacio

        Jinete jinete = new Jinete();
        jinete.setFaccion(Faccion.ALIADOS);
        Jinete jinete2 = new Jinete();
        jinete2.setFaccion(Faccion.ALIADOS);
        Jinete jinete3 = new Jinete();
        jinete3.setFaccion(Faccion.ALIADOS);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,2);
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);


        tablero.colocarEntidad(jinete, posicion);
        tablero.moverEntidad(posicion, posicion2, Faccion.ALIADOS);
        tablero.colocarEntidad(jinete2, posicion);
        assertThrows(CasilleroOcupadoException.class, () -> {
            tablero.colocarEntidad(jinete3,posicion);
        });

    }


    @Test
    public void test06PuedoMoverUnaEntidadAOtroCasillero(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS), Faccion.ALIADOS);

        jinete.setFaccion(Faccion.ALIADOS);
        Jinete jinete2 = new Jinete();
        jinete2.setFaccion(Faccion.ALIADOS);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,2);
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);

        tablero.colocarEntidad(jinete, posicion);
        tablero.moverEntidad(posicion, posicion2, Faccion.ALIADOS);
        assertThrows(CasilleroOcupadoException.class, () -> {
            tablero.colocarEntidad(new Jinete(),posicion2);
        });

    }

    @Test
    public void test07AgregoUnSoldadoYEsAmigoDeLaMismaFaccion(){

        Soldado soldado = new Soldado(new Jugador(Faccion.ALIADOS), Faccion.ALIADOS);

        Posicion posicion = new Posicion(1,1);

        Ocupado ocupado = new Ocupado(soldado, posicion, Faccion.ALIADOS);
        assertTrue(ocupado.esSoldadoAmigo(Faccion.ALIADOS));

    }








}
