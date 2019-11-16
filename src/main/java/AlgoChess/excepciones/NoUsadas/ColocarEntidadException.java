package AlgoChess.excepciones.NoUsadas;

@SuppressWarnings("serial")
public class ColocarEntidadException extends RuntimeException {
		   public String toString(){
		     return ("Intento colocar una entidad enemiga en un casillero aliado o viceversa") ;
		  }
}
