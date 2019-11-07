package fiuba.algo3.tp2.Excepciones;

@SuppressWarnings("serial")
public class CasilleroVacioException extends RuntimeException {
		   public String toString(){
		     return ("No puede realizar esta acción desde un casillero vacío") ;
		  }
}
