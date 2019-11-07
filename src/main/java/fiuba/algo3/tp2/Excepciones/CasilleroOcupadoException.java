package fiuba.algo3.tp2.Excepciones;

@SuppressWarnings("serial")
public class CasilleroOcupadoException extends RuntimeException {
		   public String toString(){
		     return ("Intento colocar en un casillero ocupado") ;
		  }
}
