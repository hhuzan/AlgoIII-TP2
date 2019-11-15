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

import static AlgoChess.engine.Constantes.CURANDERO_COSTO;
import static AlgoChess.engine.Constantes.CURANDERO_VIDA;

public class Curandero extends Entidad implements PuedeCurar, PuedeMoverse, PuedeSerCurada, PuedeSerHerida {
    private ArmaCura arma;

    public Curandero() {
        super(CURANDERO_VIDA, CURANDERO_COSTO);
        arma = new Vaculo();
    }

    @Override
    public Curandero clonar() {
        return new Curandero();
    }

    @Override
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Tablero tablero) {
        if (sosEnemigo(faccionQueDania)) {
            getVida().disminuir(cantidad);
        }
        if (estoyMuerto()) tablero.colocarVacio(getPosicion());
    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Tablero tablero) {
        getVida().disminuir(cantidad);
        if (estoyMuerto()) tablero.colocarVacio(getPosicion());
    }


    @Override
    public void curar(Recuadro casilleroCurado, Faccion faccionJugador) {
        if (sosAmigo(faccionJugador)) {
            arma.curar(getPosicion(), casilleroCurado, getFaccion());
        }

    }

    @Override
    public boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        if (sosAmigo(faccionJugador)) {
            casillero.recibirEntidad(this, tablero);
            return true;
        }
        return false;
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
        if (sosAmigo(faccionQueCura)) {
            getVida().aumentar(cantidad);
        }
    }
}
