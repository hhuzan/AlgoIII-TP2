package AlgoChess.excepciones;

@SuppressWarnings("serial")
public class TipoNoPuedeCurarException extends RuntimeException {
		   public String toString(){
		     return ("Este tipo de entidad no puede curar") ;
		  }
}
