package algochess.engine.entidades;

import algochess.engine.entidades.armas.Roca;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaAtaca;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.interfaces.entidades.PuedeAtacar;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.engine.jugador.Jugador;
import static algochess.engine.Constantes.CATAPULTA_COSTO;
import static algochess.engine.Constantes.CATAPULTA_VIDA;

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