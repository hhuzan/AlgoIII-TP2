package algoChess.engine.entidades;

import algoChess.engine.entidades.armas.Roca;
import algoChess.engine.facciones.Faccion;
import algoChess.engine.interfaces.armas.ArmaAtaca;
import algoChess.engine.interfaces.casillero.Recuadro;
import algoChess.engine.interfaces.entidades.PuedeAtacar;
import algoChess.engine.interfaces.entidades.PuedeSerHerida;
import algoChess.engine.tablero.Tablero;
import algoChess.excepciones.EntidadDeMismaFaccionException;
import algoChess.engine.jugador.Jugador;
import static algoChess.engine.Constantes.CATAPULTA_COSTO;
import static algoChess.engine.Constantes.CATAPULTA_VIDA;

public class Catapulta extends Entidad implements PuedeAtacar, PuedeSerHerida {
    private ArmaAtaca arma;

    public Catapulta() {
        super(CATAPULTA_VIDA, CATAPULTA_COSTO);
        arma = new Roca();
    }

    public Catapulta(Jugador propietario, Faccion faccion) {
        super(CATAPULTA_VIDA, CATAPULTA_COSTO, propietario, faccion);
        arma = new Roca();
    }

    private void verificarMuerte(Tablero tablero, Jugador propietario) {
        if(estoyMuerto()) {
            tablero.colocarVacio(getPosicion());
            propietario.removerEntidad(this);
        }
    }
    
    @Override
    public Catapulta clonar() {
        return new Catapulta();
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
        if (sosAmigo(ordenDeFaccion)) {arma.atacar(getPosicion(), casilleroAtacado, getFaccion(), tablero);}
    }
}