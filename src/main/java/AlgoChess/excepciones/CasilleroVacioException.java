package AlgoChess.excepciones;

@SuppressWarnings("serial")

/*Esta tambien es muy entendible, si estas jugando ajedrez, y quieres hacer algo "desde" un casillero vacio
el juego no te dice "no puedes hacer eso"
* */
public class CasilleroVacioException extends RuntimeException {
		   public String toString(){
		     return ("No puede realizar esta acción desde un casillero vacío") ;
		  }
}
