package AlgoChess.engine.entidades;

import AlgoChess.engine.Dinero;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.posicion.Posicion;

public abstract class Entidad {
    private Vida vida;
    private Faccion faccion;
    private Dinero costo;
    private Posicion posicion;

    // TODO: Agregar constructor con faccion para crear una entidad directamente con facción determinada
    public Entidad(int vida_, int costo_) {
        vida = new Vida(vida_);
        costo = new Dinero(costo_);
    }

    public abstract Entidad clonar();

    Vida getVida() {
        return vida;
    }

    public boolean estoyMuerto() {
        return vida.fallecio();
    }

    public boolean tenesEstaVida(double number) {
        return vida.igualA(number);
    }

    public Faccion getFaccion() {
        return faccion;
    }

    public void setFaccion(Faccion faccion_) {
        faccion = faccion_;
    }

    public Dinero getCosto() {
        return costo;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion_) {
        posicion = posicion_;
    }

    public boolean sosAmigo(Faccion unaFaccion) {
        return faccion == unaFaccion;
    }

    public boolean sosEnemigo(Faccion unaFaccion) {
        return !sosAmigo(unaFaccion);
    }


}
