package AlgoChess.excepciones;

@SuppressWarnings("serial")
public class EntidadNoPuedeMoverseException extends RuntimeException {
		   public String toString(){
		     return ("Esta entidad no puede moverse") ;
		  }
}
