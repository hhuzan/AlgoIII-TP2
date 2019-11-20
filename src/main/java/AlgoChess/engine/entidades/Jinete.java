package AlgoChess.engine.entidades;

import AlgoChess.engine.entidades.armas.Arco;
import AlgoChess.engine.entidades.armas.Daga;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaAtaca;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeAtacar;
import AlgoChess.engine.interfaces.entidades.PuedeMoverse;
import AlgoChess.engine.interfaces.entidades.PuedeSerCurada;
import AlgoChess.engine.interfaces.entidades.PuedeSerHerida;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.engine.jugador.Jugador;

import java.util.HashSet;

import static AlgoChess.engine.Constantes.*;

public class Jinete extends Entidad implements PuedeAtacar, PuedeMoverse, PuedeSerHerida, PuedeSerCurada {
    private ArmaAtaca arma;

    public Jinete() {
        super(JINETE_VIDA, JINETE_COSTO);
        arma = new Daga();
    }

    public Jinete(Jugador propietario, Faccion faccion) {
        super(JINETE_VIDA, JINETE_COSTO, propietario, faccion);
        arma = new Daga();
    }

    private void verificarMuerte(Tablero tablero, Jugador propietario) {
        if(estoyMuerto()) {
            tablero.colocarVacio(getPosicion());
            propietario.removerEntidad(this);
        }
    }

    @Override
    public Jinete clonar() {
        return new Jinete(getPropietario(), getFaccion());
    }

    @Override
    public void aumentarVida(int cantidad, Faccion faccionQueCura) {
        if (sosAmigo(faccionQueCura)) {getVida().aumentar(cantidad);}
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
    public void atacar(Recuadro casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion) {
        if (sosAmigo(ordenDeFaccion)) {
            definirArma(tablero);
            arma.atacar(getPosicion(), casilleroAtacado, getFaccion(), tablero);
        }
    }

    @Override
    public boolean moverA(Tablero tablero, Recuadro casillero, Faccion faccionJugador) {
        if (sosAmigo(faccionJugador)) {return casillero.recibirEntidad(this, tablero);}
        return false;
    }


    private void definirArma(Tablero tablero){
        HashSet<Posicion> amigosPotenciales = getPosicion().generarPosicionesEnAlcance(RANGO_CERCANO_MINIMO,RANGO_CERCANO_MAXIMO);
        for(Posicion potencialAmigo : amigosPotenciales){
            if(tablero.esSoldadoAmigo(getFaccion(), potencialAmigo)){
                arma = new Arco();
                return;
            }
        }
        arma = new Daga();
    }


}


