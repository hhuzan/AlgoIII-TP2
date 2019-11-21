package algochess.excepciones;

@SuppressWarnings("serial")
public class EntidadDeMismaFaccionException extends RuntimeException {
		   public String toString(){
		     return ("La entidad a la que estas atacando es de tu facción") ;
		  }
}
