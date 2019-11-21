package algoChess.engine.entidades;

import algoChess.engine.entidades.armas.Arco;
import algoChess.engine.entidades.armas.Daga;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.armas.ArmaAtaca;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.interfaces.entidades.PuedeAtacar;
import algoChess.engine.interfaces.entidades.PuedeMoverse;
import algoChess.engine.interfaces.entidades.PuedeSerCurada;
import algoChess.engine.interfaces.entidades.PuedeSerHerida;
import algoChess.engine.posicion.Posicion;
import algoChess.engine.tablero.Tablero;
import algoChess.excepciones.EntidadDeMismaFaccionException;
import algoChess.engine.jugador.Jugador;
import java.util.HashSet;
import static algoChess.engine.Constantes.*;

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


