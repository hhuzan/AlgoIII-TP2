package algochess.excepciones;

@SuppressWarnings("serial")

public class JugadorPerdioException extends RuntimeException {
	public String toString(){
		return ("El juego ha terminado") ;
	}
}

