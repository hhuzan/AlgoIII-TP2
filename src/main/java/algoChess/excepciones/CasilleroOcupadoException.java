package algoChess.excepciones;

@SuppressWarnings("serial")

public class CasilleroOcupadoException extends RuntimeException {
		   public String toString(){
		     return ("Intento colocar en un casillero ocupado") ;
		  }
}

