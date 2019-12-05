package algochess.excepciones;

@SuppressWarnings("serial")

public class JugadorYaHaMovidoException extends RuntimeException {
		   public String toString(){
		     return ("Ya has movido una entidad en este turno") ;
		  }
}

