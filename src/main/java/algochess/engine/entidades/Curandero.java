package algochess.engine.entidades;

import algochess.engine.entidades.armas.Vaculo;
import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Vacio;
import algochess.engine.interfaces.armas.ArmaCura;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.entidades.PuedeCurar;
import algochess.engine.interfaces.entidades.PuedeMoverse;
import algochess.engine.interfaces.entidades.PuedeSerCurada;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.engine.jugador.Jugador;
import static algochess.engine.ConstantesUtils.CURANDERO_COSTO;
import static algochess.engine.ConstantesUtils.CURANDERO_VIDA;

public class Curandero extends Entidad implements PuedeCurar, PuedeMoverse, PuedeSerCurada, PuedeSerHerida {
    private ArmaCura arma;

    public Curandero() {
        super(CURANDERO_VIDA, CURANDERO_COSTO);
        arma = new Vaculo();
    }

    public Curandero(Jugador propietario, Faccion faccion) {
        super(CURANDERO_VIDA, CURANDERO_COSTO, propietario, faccion);
        arma = new Vaculo();
    }

    private void verificarMuerte(Casillero casillero, Jugador propietario) {
        if(estoyMuerto()) {
            casillero.cambiarEstado(new Vacio());
            propietario.removerEntidad(this);
        }
    }

    @Override
    public Curandero clonar() {
        return new Curandero();
    }

    @Override
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Casillero casillero) {
        if (sosEnemigo(faccionQueDania)) 
            getVida().disminuir(cantidad);
        else 
            throw new EntidadDeMismaFaccionException();
        
        verificarMuerte(casillero, getPropietario());
    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Casillero casillero) {
        getVida().disminuir(cantidad);
        verificarMuerte(casillero, getPropietario());
    }


    @Override
    public void curar(Casillero casilleroCurado, Faccion faccionJugador) {
        arma.curar(getPosicion(), casilleroCurado, getFaccion());
    }

    @Override
    public boolean moverA(Tablero tablero, Casillero origen, Casillero destino, Faccion faccionJugador) {
        if(origen.enRangoMovimiento(destino))
            return destino.recibirEntidad(this);
        else 
            return false;
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
        if (sosAmigo(faccionQueCura)) 
            getVida().aumentar(cantidad);
    }
}
