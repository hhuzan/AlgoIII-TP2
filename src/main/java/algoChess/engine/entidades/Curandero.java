package algoChess.engine.entidades;

import algoChess.engine.entidades.armas.Vaculo;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.armas.ArmaCura;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.interfaces.entidades.PuedeCurar;
import algoChess.engine.interfaces.entidades.PuedeMoverse;
import algoChess.engine.interfaces.entidades.PuedeSerCurada;
import algoChess.engine.interfaces.entidades.PuedeSerHerida;
import algoChess.engine.tablero.Tablero;
import algoChess.excepciones.EntidadDeMismaFaccionException;
import algoChess.engine.jugador.Jugador;
import static algoChess.engine.Constantes.CURANDERO_COSTO;
import static algoChess.engine.Constantes.CURANDERO_VIDA;

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
