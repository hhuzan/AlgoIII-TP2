package algochess.excepciones;

@SuppressWarnings("serial")
public class ColocarEntidadException extends RuntimeException {
		   public String toString(){
		     return ("No se puede colocar una entidad en un casillero de otra facción") ;
		  }
}
