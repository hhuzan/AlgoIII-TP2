package algochess.engine.entidades;

import algochess.engine.entidades.armas.Arco;
import algochess.engine.entidades.armas.Daga;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaAtaca;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.interfaces.entidades.PuedeAtacar;
import algochess.engine.interfaces.entidades.PuedeMoverse;
import algochess.engine.interfaces.entidades.PuedeSerCurada;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.engine.jugador.Jugador;
import java.util.HashSet;
import static algochess.engine.Constantes.*;

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


