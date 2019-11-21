package algochess.engine.jugador;

import algochess.engine.Dinero;
import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.excepciones.JugadorPerdioException;
import java.util.ArrayList;
import java.util.List;
import static algochess.engine.ConstantesUtils.DINERO_JUGADOR;

public class Jugador {

    private List<Entidad> entidades = new ArrayList<>();
    private Dinero dinero;
    private String nombre;
    private Faccion faccion;

    public Jugador(Faccion faccion_, String nombre_) {
        faccion = faccion_;
        dinero = new Dinero(DINERO_JUGADOR);
        nombre = nombre_;
    }

    public Jugador(Faccion faccion_) {
        faccion = faccion_;
        dinero = new Dinero(DINERO_JUGADOR);
        nombre = ""; // TODO: Randomizer de nombre o table look-up
    }


    public Faccion getFaccion() {
        return faccion;
    }

    public boolean perdio() {
        return entidades.size() == 0;
    }

    private void agregarEntidad(Entidad entidad) {
        if (entidad.sosAmigo(this.faccion)){
            // TODO: Ver de sacar el constructor que no tiene faccion
            entidades.add(entidad);
        }
        else{
            throw new EntidadDeMismaFaccionException();
        }
    }

    public void removerEntidad(Entidad entidad) {
        entidades.remove(entidad);
        if(perdio())
            throw new JugadorPerdioException();
    }

    public void comprarEntidad(VendedorDeEntidades vendedor, Entidad entidad) {
        Dinero gasto = entidad.restarDinero(dinero);
        Entidad miEntidad = vendedor.venderEntidad(entidad, gasto);
        agregarEntidad(miEntidad);
    }

}
