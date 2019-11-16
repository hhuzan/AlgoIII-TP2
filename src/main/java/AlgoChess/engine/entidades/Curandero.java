package AlgoChess.engine.entidades;

import AlgoChess.engine.entidades.armas.Vaculo;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaCura;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeCurar;
import AlgoChess.engine.interfaces.entidades.PuedeMoverse;
import AlgoChess.engine.interfaces.entidades.PuedeSerCurada;
import AlgoChess.engine.interfaces.entidades.PuedeSerHerida;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.engine.jugador.Jugador;

import static AlgoChess.engine.Constantes.CURANDERO_COSTO;
import static AlgoChess.engine.Constantes.CURANDERO_VIDA;

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
        if (sosAmigo(faccionJugador)) {arma.curar(getPosicion(), casilleroCurado, getFaccion());}

    }

    @Override
    public boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        if (sosAmigo(faccionJugador)) {return casillero.recibirEntidad(this, tablero);}
        return false;
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
        if (sosAmigo(faccionQueCura)) {getVida().aumentar(cantidad);}
    }
}
