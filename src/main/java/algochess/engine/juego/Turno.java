package algochess.engine.juego;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.NoEsTuTurnoException;

public class Turno {

    private Faccion faccion;

    public Turno(Faccion faccion){
        this.faccion = faccion;

    }

    public void colocarEntidad(Casillero casillero, Jugador jugador, Entidad entidad) {

        if (jugador.getFaccion() == this.faccion){

            // se puede crear un metodo en jugador que se llame sonMismoBando o algo asi para
            // encapsular un poquito mas

            casillero.colocarEntidad(entidad);
            this.faccion = Faccion.ENEMIGOS;
        }
        else{

            throw new NoEsTuTurnoException();

        }
    }

    public void atacarCasillero(Casillero casilleroAtacante, Casillero casilleroAtacado, Tablero tablero, Faccion faccionJugador) {
        if (faccionJugador == this.faccion){

            // se puede crear un metodo en jugador que se llame sonMismoBando o algo asi para
            // encapsular un poquito mas

            casilleroAtacante.atacar(casilleroAtacado, tablero, faccionJugador);
            this.faccion = Faccion.ENEMIGOS;
        }
        else{

            throw new NoEsTuTurnoException();

        }



    }

    public void curarCasillero(Casillero casilleroCurador, Casillero casilleroCurado, Tablero tablero, Faccion faccionJugador) {

        if (faccionJugador == this.faccion){

            // se puede crear un metodo en jugador que se llame sonMismoBando o algo asi para
            // encapsular un poquito mas

            casilleroCurador.curar(casilleroCurado, tablero, faccionJugador);
            this.faccion = Faccion.ENEMIGOS;
        }
        else{

            throw new NoEsTuTurnoException();

        }

    }

    public void moverEntidad(Casillero origen, Casillero destino, Tablero tablero, Faccion faccionJugador) {


        if (faccion == this.faccion){

            // se puede crear un metodo en jugador que se llame sonMismoBando o algo asi para
            // encapsular un poquito mas

            origen.moverEntidad(tablero,origen, destino, faccionJugador);
            this.faccion = Faccion.ENEMIGOS;
        }
        else{

            throw new NoEsTuTurnoException();

        }

    }
}
