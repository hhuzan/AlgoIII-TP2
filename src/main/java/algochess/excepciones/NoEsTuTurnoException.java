package algochess.excepciones;

@SuppressWarnings("serial")
public class NoEsTuTurnoException extends RuntimeException {

    public String toString(){
        return ("Movimiento invalido, el turno es del otro jugador.") ;
    }

}
