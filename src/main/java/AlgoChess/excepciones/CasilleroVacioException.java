package AlgoChess.excepciones;

@SuppressWarnings("serial")
public class CasilleroVacioException extends RuntimeException {
		   public String toString(){
		     return ("No puede realizar esta acción desde un casillero vacío") ;
		  }
}
