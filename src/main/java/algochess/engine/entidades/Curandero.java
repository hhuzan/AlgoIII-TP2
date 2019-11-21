package algochess.engine.entidades;

import algochess.engine.entidades.armas.Vaculo;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaCura;
import algochess.engine.interfaces.casillero.Recuadro;
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

    private void verificarMuerte(Tablero tablero, Jugador propietario) {
        if(estoyMuerto()) {
            tablero.colocarVacio(getPosicion());
            propietario.removerEntidad(this);
        }
    }

    @Override
    public Curandero clonar() {
        return new Curandero();
    }

    @Override
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Tablero tablero) {
        if (sosEnemigo(faccionQueDania)) 
            getVida().disminuir(cantidad);
        else 
            throw new EntidadDeMismaFaccionException();
        
        verificarMuerte(tablero, getPropietario());
    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Tablero tablero) {
        getVida().disminuir(cantidad);
        verificarMuerte(tablero, getPropietario());
    }


    @Override
    public void curar(Recuadro casilleroCurado, Faccion faccionJugador) {
        if (sosAmigo(faccionJugador)) 
            arma.curar(getPosicion(), casilleroCurado, getFaccion());

    }

    @Override
    public boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        if (sosAmigo(faccionJugador)) 
            return casillero.recibirEntidad(this, tablero);

        return false;
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
        if (sosAmigo(faccionQueCura)) 
            getVida().aumentar(cantidad);
    }
}
