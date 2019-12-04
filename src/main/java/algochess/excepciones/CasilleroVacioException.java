package algochess.excepciones;

@SuppressWarnings("serial")

public class CasilleroVacioException extends RuntimeException {
	public String toString(){
		return ("No se puede realizar esta accion desde un casillero vacio");
	}
}
