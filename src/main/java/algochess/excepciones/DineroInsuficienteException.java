package algochess.excepciones;

@SuppressWarnings("serial")
public class DineroInsuficienteException extends RuntimeException {

	public String toString(){
        return ("No tenes dinero suficiente para comprar esta entidad") ;
    }

}
