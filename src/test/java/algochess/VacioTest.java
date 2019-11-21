package algochess;

import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Vacio;
import algochess.excepciones.CasilleroOcupadoException;
import algochess.excepciones.ColocarEntidadException;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VacioTest {

    @Test
    public void test00CreoUnVacioYNoEsNull(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertNotNull(vacio);

    }

    @Test
    public void test01ColocoEntidadDeDistintaFaccionYTiraError(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertThrows(ColocarEntidadException.class, () -> {
            vacio.colocarEntidad(new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ENEMIGOS), new Tablero(Faccion.ALIADOS, Faccion.ENEMIGOS));
        });
    }

    @Test
    public void test02SoldadoAmigoSiempreDevuelveFalse(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertFalse(vacio.esSoldadoAmigo(Faccion.ALIADOS));

    }

    @Test
    public void test03SPoseesUnidadSiempreDevuelveFalse(){

        Posicion posicion = new Posicion(1,1);
        Vacio vacio = new Vacio(posicion, Faccion.ALIADOS);
        assertFalse(vacio.poseesUnidad());

    }


    @Test
    public void test04ColocarEntidadEnVacioConvierteElCasilleroEnOcupado(){
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
