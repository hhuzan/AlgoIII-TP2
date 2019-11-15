package AlgoChess.engine.entidades;

import AlgoChess.engine.entidades.armas.Daga;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaAtaca;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeAtacar;
import AlgoChess.engine.interfaces.entidades.PuedeMoverse;
import AlgoChess.engine.interfaces.entidades.PuedeSerCurada;
import AlgoChess.engine.interfaces.entidades.PuedeSerHerida;
import AlgoChess.engine.tablero.Tablero;

import static AlgoChess.engine.Constantes.JINETE_COSTO;
import static AlgoChess.engine.Constantes.JINETE_VIDA;

public class Jinete extends Entidad implements PuedeAtacar, PuedeMoverse, PuedeSerHerida, PuedeSerCurada {
    private ArmaAtaca arma;

    public Jinete() {
        super(JINETE_VIDA, JINETE_COSTO);
        arma = new Daga();
    }

    @Override
    public Jinete clonar() {
        return new Jinete();
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
        if (sosAmigo(faccionQueCura)) {
            getVida().aumentar(cantidad);
        }

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
    }

    @Override
    public void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion) {
        // TODO: Dado algun comportamiento cambiar su arma
        if (sosAmigo(ordenDeFaccion)) {
            arma.atacar(getPosicion(), casilleroAtacado, getFaccion(), tablero);
        }
    }

    @Override
    public boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        if (sosAmigo(faccionJugador)) {
            return casillero.recibirEntidad(this, tablero);

        }
        return false;
    }

     /*public void cambiarArma(Arma arma_){
         arma = arma_;
        //ver condiciones de cuando se cambia el arma
    }*/
}


