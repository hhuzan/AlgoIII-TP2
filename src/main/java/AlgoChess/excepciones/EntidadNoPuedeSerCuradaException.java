package AlgoChess.excepciones;

@SuppressWarnings("serial")
public class EntidadNoPuedeSerCuradaException extends RuntimeException {
		   public String toString(){
		     return ("Este tipo de entidad no puede ser curada") ;
		  }
}
