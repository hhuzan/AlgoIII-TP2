package AlgoChess.excepciones.NoUsadas;

@SuppressWarnings("serial")
public class EntidadDelMismoEquipoException extends RuntimeException {
		   public String toString(){
		     return ("La entidad a la que estas atacando es del mismo equipo") ;
		  }
}