package algochess;

import algochess.engine.entidades.Jinete;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Turno;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.CasilleroOcupadoException;
import algochess.excepciones.NoEsTuTurnoException;
import javafx.geometry.Pos;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnoTest {

    @Test
    public void test00CreoUnTurnoYEsValido(){

        Turno turno = new Turno(Faccion.ALIADOS);
        assertNotNull(turno);

    }


//    @Test
//    public void test01ColocoEnTurnoIncorrectoYTiraError(){
//
//        Posicion posicion = new Posicion(1,1);
//        Turno turno = new Turno(Faccion.ENEMIGOS);
//        Casillero casillero = new Casillero(posicion, Faccion.ALIADOS);
//
//        assertThrows(NoEsTuTurnoException.class, () -> {
//            turno.colocarEntidad(casillero, new Jugador(Faccion.ALIADOS, "Lucas"),new Jinete());
//        });
//
//    }

    @Test
    public void test02AtacoEnTurnoIncorrectoYTiraError(){

        Posicion posicion = new Posicion(1,1);
        Posicion posicion2= new Posicion(2,2);
        Turno turno = new Turno(Faccion.ENEMIGOS);
        Casillero casillero = new Casillero(posicion, Faccion.ALIADOS);
        Casillero casillero2 = new Casillero(posicion2, Faccion.ENEMIGOS);

        assertThrows(NoEsTuTurnoException.class, () -> {
            turno.atacarCasillero(casillero,casillero2,new Tablero(),Faccion.ALIADOS);
        });

    }

    @Test
    public void test03CuroEnTurnoIncorrectoYTiraError(){

        Posicion posicion = new Posicion(1,1);
        Posicion posicion2= new Posicion(2,2);
        Turno turno = new Turno(Faccion.ENEMIGOS);
        Casillero casillero = new Casillero(posicion, Faccion.ALIADOS);
        Casillero casillero2 = new Casillero(posicion2, Faccion.ENEMIGOS);

        assertThrows(NoEsTuTurnoException.class, () -> {
            turno.curarCasillero(casillero,casillero2,new Tablero(),Faccion.ALIADOS);
        });

    }


    @Test
    public void test04MuevoEntidadEnTurnoIncorrectoYTiraError(){

        Posicion posicion = new Posicion(1,1);
        Posicion posicion2= new Posicion(2,2);
        Turno turno = new Turno(Faccion.ENEMIGOS);
        Casillero casillero = new Casillero(posicion, Faccion.ALIADOS);
        Casillero casillero2 = new Casillero(posicion2, Faccion.ENEMIGOS);

        assertThrows(NoEsTuTurnoException.class, () -> {
            turno.moverEntidad(casillero,casillero2,new Tablero(),Faccion.ALIADOS);
        });

    }







}
