package AlgoChess;


import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Ocupado;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.engine.tablero.Vacio;
import AlgoChess.excepciones.CasilleroOcupadoException;
import AlgoChess.excepciones.ColocarEntidadException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class VacioTest {


    @Test
    public void Test00CreoUnVacioYNoEsNull(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertNotNull(vacio);

    }

    @Test
    public void Test01ColocoEntidadDeDistintaFaccionYTiraError(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertThrows(ColocarEntidadException.class, () -> {
            vacio.colocarEntidad(new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ENEMIGOS), new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS));
        });
    }

    @Test
    public void Test02SoldadoAmigoSiempreDevuelveFalse(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertFalse(vacio.esSoldadoAmigo(Faccion.ALIADOS));

    }

    @Test
    public void Test03SPoseesUnidadSiempreDevuelveFalse(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertFalse(vacio.poseesUnidad());

    }


    @Test
    public void Test04ColocarEntidadEnVacioConvierteElCasilleroEnOcupado(){
        Tablero tablero = new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS);
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(Faccion.ALIADOS, "Lucas");
        Entidad jinete = new Jinete(jugador, Faccion.ALIADOS);
        Entidad jinete2 = new Jinete(jugador, Faccion.ALIADOS);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);


        vacio.colocarEntidad(jinete, tablero);
        assertThrows(CasilleroOcupadoException.class, ()-> tablero.obtenerCasillero(posicion).colocarEntidad(jinete2, tablero));


    }






}
