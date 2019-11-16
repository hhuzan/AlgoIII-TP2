package AlgoChess.excepciones;

@SuppressWarnings("serial")

//Comentario, ¿es necesario hacer esto?
//Podriamos guardar una variable en Jugador, "Perdio", y la seteamos en True si pierde.
public class JugadorPerdioException extends RuntimeException {
    public String toString(){
        return ("El jugador perdio") ;
    }

}
