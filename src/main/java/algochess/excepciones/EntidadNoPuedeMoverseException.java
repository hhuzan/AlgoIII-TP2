package algochess.excepciones;

@SuppressWarnings("serial")

public class EntidadNoPuedeMoverseException extends RuntimeException {
	public String toString(){
		return ("La entidad no puede realizar este movimiento") ;
	}
}
