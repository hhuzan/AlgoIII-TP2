package fiuba.algo3.tp2.excepciones;

@SuppressWarnings("serial")
public class EntidadFueraDeAlcanceException extends RuntimeException {
		   public String toString(){
		     return ("La entidad a la que estas atacando esta fuera del alcance de la entidad atacante") ;
		  }
}
