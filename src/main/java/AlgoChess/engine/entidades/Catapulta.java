package AlgoChess.engine.entidades;

import AlgoChess.engine.entidades.armas.Roca;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.armas.ArmaAtaca;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeAtacar;
import AlgoChess.engine.interfaces.entidades.PuedeSerHerida;
import AlgoChess.engine.tablero.Tablero;
import AlgoChess.excepciones.EntidadDeMismaFaccionException;
import AlgoChess.engine.jugador.Jugador;

import static AlgoChess.engine.Constantes.CATAPULTA_COSTO;
import static AlgoChess.engine.Constantes.CATAPULTA_VIDA;

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