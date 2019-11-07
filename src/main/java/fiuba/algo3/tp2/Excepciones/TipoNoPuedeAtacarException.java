package fiuba.algo3.tp2.Excepciones;

@SuppressWarnings("serial")
public class TipoNoPuedeAtacarException extends RuntimeException {
		   public String toString(){
		     return ("Este tipo de entidad no puede atacar") ;
		  }
}
