package AlgoChess.excepciones;

@SuppressWarnings("serial")

/*Es necesario hacer esto? En el juego se mostrará que habrá una entidad en X casillero, y si se quiere mover
a otro casillero con una unidad, se puede hacer nullpattern ya que el usuario puede asumir que no se puede mover porque
esta ocupado
* */
public class CasilleroOcupadoException extends RuntimeException {
		   public String toString(){
		     return ("Intento colocar en un casillero ocupado") ;
		  }
}
