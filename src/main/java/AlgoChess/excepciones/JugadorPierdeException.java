package AlgoChess.excepciones;

@SuppressWarnings("serial")

public class JugadorPierdeException extends RuntimeException {
    public String toString(){
        return ("El jugador perdio") ;
    }

}
