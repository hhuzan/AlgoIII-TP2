package AlgoChess.excepciones;

@SuppressWarnings("serial")

/*
¿Es necesario hacer esto?, cuando juegas Ajedrez, y no podes mover una pieza, el juego no te dice "no podes mover una pieza"
simplemente no te deja hacerlo.
En el GUI, podemos hacer que se muestren "Instrucciones", de tal manera que el jugador sepa este comportamiento de antemano
y podamos seguir usando el nullpattern.
* */
public class EntidadNoPuedeMoverseException extends RuntimeException {
		   public String toString(){
		     return ("Esta entidad no puede moverse") ;
		  }
}
