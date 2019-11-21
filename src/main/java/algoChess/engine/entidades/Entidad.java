package algoChess.engine.entidades;

import algoChess.engine.Dinero;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.jugador.Jugador;

public abstract class Entidad {
    private Vida vida;
    private Faccion faccion;
    private Dinero costo;
    private Posicion posicion;
    private Jugador propietario;

    // TODO: Agregar constructor con faccion para crear una entidad directamente con facción determinada
    public Entidad(int vida_, int costo_) {
        vida = new Vida(vida_);
        costo = new Dinero(costo_);
    }

    public Entidad(int vida_, int costo_, Jugador propietario_, Faccion faccion_) {
        vida = new Vida(vida_);
        costo = new Dinero(costo_);
        propietario = propietario_;
        faccion = faccion_;
    }

    public abstract Entidad clonar();

    Vida getVida() {
        return vida;
    }

    public boolean estoyMuerto() {
        return vida.fallecio();
    }


    //TODO metodo "tenesEstaVida" es para tests
    //TODO lo deberiamos borrar...
    public boolean tenesEstaVida(double number) {
        return vida.igualA(number);
    }

    public Jugador getPropietario() {
        return propietario;
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


    public Dinero restarDinero(Dinero dinero){
       Dinero dineroNuevo =  dinero.restarDinero(this.costo);
       return dineroNuevo;
    }


    public boolean costosIguales(Dinero pago){
        return (this.costo.sonIguales(pago));
    }
}
