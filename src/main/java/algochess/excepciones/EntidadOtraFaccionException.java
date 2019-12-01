package algochess.excepciones;

@SuppressWarnings("serial")
public class EntidadOtraFaccionException extends RuntimeException {

	public String toString(){
        return ("Esta entidad no pertenece a tu facción") ;
    }

}
