package AlgoChess.excepciones.NoUsadas;

@SuppressWarnings("serial")
public class TipoNoPuedeAtacarException extends RuntimeException {
		   public String toString(){
		     return ("Este tipo de entidad no puede atacar") ;
		  }
}
