package fiuba.algo3.tp2;
import java.util.List;
import java.util.ArrayList;

public class Jugador {

	private List<Entidad> entidades = new ArrayList<Entidad>();
	private CreadorEntidades creadorEntidades;

    private int puntos = 20;

    public void restarPuntos(int puntos){

        this.puntos -= puntos;
    }

    public int getPuntos() {

        return this.puntos;
    }

<<<<<<< HEAD
    public void agregarSoldado() {
    	agregar(creadorEntidades.CrearSoldado(this));
    }
    
    public void agregarJinete() {
    	agregar(creadorEntidades.CrearJinete(this));
    }
    
    public void agregarCurandero() {
    	agregar(creadorEntidades.CrearCurandero(this));
    }
    
    public void agregarCatapulta() {
    	agregar(creadorEntidades.CrearCatapulta(this));
    }
    
    private void agregar(Entidad entidad) {
=======
    public void agregarEntidad(Entidad entidad) {
>>>>>>> branch 'master' of https://github.com/hhuzan/AlgoIII-TP2
    	restarPuntos(entidad.getCosto());
    	entidades.add(entidad);
    }

}
