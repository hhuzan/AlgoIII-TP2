package algochess.engine.entidades;

import algochess.engine.entidades.armas.Roca;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.armas.ArmaAtaca;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.entidades.PuedeAtacar;
import algochess.engine.interfaces.entidades.PuedeSerHerida;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Vacio;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.engine.jugador.Jugador;
import static algochess.engine.ConstantesUtils.CATAPULTA_COSTO;
import static algochess.engine.ConstantesUtils.CATAPULTA_VIDA;

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

    private void verificarMuerte(Casillero casillero, Jugador propietario) {
        if(estoyMuerto()) {
            casillero.cambiarEstado(new Vacio());
            propietario.removerEntidad(this);
        }
    }
    
    @Override
    public Catapulta clonar() {
        return new Catapulta();
    }

    @Override
    public void disminuirVida(double cantidad, Faccion faccionQueDania, Casillero casillero) {
        if (sosEnemigo(faccionQueDania)) 
            getVida().disminuir(cantidad);
        else 
            throw new EntidadDeMismaFaccionException();
        
        verificarMuerte(casillero, getPropietario());
    }

    @Override
    public void disminuirVidaIgnorandoFaccionAtacante(double cantidad, Casillero casillero) {
        getVida().disminuir(cantidad);
        verificarMuerte(casillero, getPropietario());
    }


    @Override
    public void atacar(Casillero casilleroAtacado, Tablero tablero, Faccion ordenDeFaccion) {
        arma.atacar(getPosicion(), casilleroAtacado, getFaccion(), tablero);
    }
}