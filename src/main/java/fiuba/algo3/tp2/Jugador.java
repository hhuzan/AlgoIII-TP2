package fiuba.algo3.tp2;
import java.util.List;
import java.util.ArrayList;

public class Jugador {

	private List<Entidad> entidades = new ArrayList<Entidad>();

    private int puntos = 20;

    public void restarPuntos(int puntos){

        this.puntos -= puntos;
    }

    public int getPuntos() {

        return this.puntos;
    }

    public void agregarEntidad(Entidad entidad) {
    	restarPuntos(entidad.getCosto());
    	entidades.add(entidad);
    }

}
