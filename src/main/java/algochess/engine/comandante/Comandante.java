package algochess.engine.comandante;

import algochess.engine.entidades.Entidad;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.posicion.Posicion;
import algochess.engine.posicion.Posiciones;
import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Vacio;

import algochess.excepciones.CasilleroOcupadoException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import static algochess.engine.ConstantesUtils.TAMANIO_BATALLON;

public class Comandante {
    private Queue<Posicion> cola;
    private Posiciones visitados;
    private HashSet<PuedeFormarBatallon> batallon;
    private int tamanioBatallon;
    private Tablero tablero;
    private HashSet<PuedeFormarBatallon> batallonParaLoop;
    private Posiciones posicionesReclutas;
    private Posicion instrucciones;
    private HashSet<PuedeFormarBatallon> reclutasYaMovidos;

    public Comandante(Tablero tablero_) {
        cola = new LinkedList<>();
        visitados = new Posiciones();
        batallon = new HashSet<>();
        tamanioBatallon = TAMANIO_BATALLON;
        tablero = tablero_;
        batallonParaLoop = new HashSet<>();
        posicionesReclutas = new Posiciones();
    }

    private HashSet<Posicion> generarAdyacentes(Posicion posicion) {
        return posicion.generarPosicionesEnAlcance(1,1);
    }

    /*BFS*/
    public void recluteMisCercanos(PuedeFormarBatallon entidad) {
        batallon.add(entidad);
        cola.add(entidad.getPosicion());

        while (cola.size() != 0 && batallon.size() < tamanioBatallon) {
            Posicion actualPosicion = cola.remove();
            HashSet<Posicion> posiciones = generarAdyacentes(actualPosicion);
            for (Posicion posicion : posiciones) {
                if (!visitados.contiene(posicion)) {
                    visitados.agregar(posicion);
                    tablero.reclutarEntidades(posicion, batallon, cola, entidad);
                }
            }
        }
    }

    private void generarInstrucciones(Casillero destino, Entidad entidad) {
        int movimientoFila = destino.getPosicion().getFila() - entidad.getPosicion().getFila();
        int movimientoColumna = destino.getPosicion().getColumna() - entidad.getPosicion().getColumna();

        instrucciones = new Posicion(movimientoFila, movimientoColumna);
    }

    private Posicion generarPosicionPotencial(PuedeFormarBatallon recluta, Posicion instrucciones) {
        int movimientoColumna = instrucciones.getColumna();
        int movimientoFila = instrucciones.getFila();
        int posicionColumna = recluta.getPosicion().getColumna();
        int posicionFila = recluta.getPosicion().getFila();


        return new Posicion(posicionFila + movimientoFila, posicionColumna + movimientoColumna);
    }

    private void moverSetup(){
        for (PuedeFormarBatallon unRecluta : batallon) {
            batallonParaLoop.add(unRecluta);
            posicionesReclutas.agregar(unRecluta.getPosicion());
        }
        reclutasYaMovidos = new HashSet<>();

    }


    public boolean moverBatallon(Tablero tablero, Casillero destino, Entidad entidad) {
        if (batallon.size() != TAMANIO_BATALLON) {return false;}

        moverSetup();
        generarInstrucciones(destino, entidad);

        while (batallon.size() != 0) {
            for (PuedeFormarBatallon recluta : batallonParaLoop) {
                if(reclutasYaMovidos.contains(recluta)) continue;
                Posicion posicionPotencial = generarPosicionPotencial(recluta, instrucciones);
                if (!posicionesReclutas.contiene(posicionPotencial) ) {
                    Posicion antigua = recluta.getPosicion();
                    Casillero origen = tablero.obtenerCasillero(antigua);
                    posicionesReclutas.remover(antigua);
                    batallon.remove(recluta);
                    reclutasYaMovidos.add(recluta);
                    Casillero casillero = tablero.obtenerCasillero(posicionPotencial);
                    boolean seMovio = false;
                    try {
                        seMovio = recluta.moverComoRecluta(tablero, casillero);
                    } 
                    catch (CasilleroOcupadoException ignored){};

                    if (seMovio)
                        origen.cambiarEstado(new Vacio());
                }
            }
        }
        return true;
    }

}
