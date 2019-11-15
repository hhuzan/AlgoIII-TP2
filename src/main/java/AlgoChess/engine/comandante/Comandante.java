package AlgoChess.engine.comandante;

import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeFormarBatallon;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;

import java.util.*;

import static AlgoChess.engine.Constantes.TAMANIO_BATALLON;

public class Comandante {
    private Queue<Posicion> cola;
    private HashSet<Posicion> visitados;
    private HashSet<PuedeFormarBatallon> batallon;
    private int tamanioBatallon;
    private Tablero tablero;
    private HashSet<PuedeFormarBatallon> batallonParaLoop;

    public Comandante(Tablero tablero_) {
        cola = new LinkedList<>();
        visitados = new HashSet<>();
        batallon = new HashSet<>();
        tamanioBatallon = TAMANIO_BATALLON;
        tablero = tablero_;
        batallonParaLoop = new HashSet<>();
    }

    private HashSet<Posicion> generarAdyacentes(Posicion posicion) {
        HashSet<Posicion> contiguos = new HashSet<>();

        int fila = posicion.getFila();
        int columna = posicion.getColumna();

        contiguos.add(new Posicion(fila - 1, columna)); //arriba
        contiguos.add(new Posicion(fila + 1, columna)); //abajo
        contiguos.add(new Posicion(fila, columna + 1)); //derecha
        contiguos.add(new Posicion(fila, columna - 1));//izquierda
        contiguos.add(new Posicion(fila - 1, columna + 1)); //arriba+derecha
        contiguos.add(new Posicion(fila - 1, columna - 1));//arriba+izquierda
        contiguos.add(new Posicion(fila + 1, columna + 1));//abajo+derecha
        contiguos.add(new Posicion(fila + 1, columna - 1));//abajo+izquierda

        return contiguos;

    }


    public void recluteMisCercanos(PuedeFormarBatallon entidad) {
        /*Añado la entidad que pide reclutar sus cercanos a Reclutados*/
        batallon.add(entidad);

        /*Añado la posicion de la entidad que pide reclutar sus cercanos a la Cola*/
        cola.add(entidad.getPosicion());


        // Mientras el tamaño de la cola sea distinto a cero y los reclutados sean menor al tamaño máximo del batallón
        while (cola.size() != 0 && batallon.size() < tamanioBatallon) {
            // Remuevo la posicion de la cola
            Posicion actualPosicion = cola.remove();


            //Genero las posiciones vecinas de la cola
            HashSet<Posicion> posiciones = generarAdyacentes(actualPosicion);
            //TODO borrar System.out.println("Generando adyacentes para: " + actualPosicion.getFila() + ", " + actualPosicion.getColumna());
            //Para cada posicion vecina de mi posicion actual
            for (Posicion posicion : posiciones) {
                //TODO borrar System.out.println("Analizando: " + posicion.getFila() + ", " + posicion.getColumna());
                //Si la posicion no fue visitada
                if (!visitados.contains(posicion)) {
                    //La agrego a visistados
                    visitados.add(posicion);
                    //Tablero recluta la posicion
                    tablero.reclutarEntidades(posicion, batallon, cola, entidad);
                }
            }
        }
    }

    private Posicion generarInstrucciones(Recuadro destino, Entidad entidad){
        int movimientoFila = destino.getPosicion().getFila() - entidad.getPosicion().getFila();
        int movimientoColumna = destino.getPosicion().getColumna() - entidad.getPosicion().getColumna();

        return new Posicion(movimientoFila,movimientoColumna);
    }

    private Posicion generarPosicionPotencial(PuedeFormarBatallon recluta, Posicion instrucciones){
        int movimientoColumna = instrucciones.getColumna();
        int movimientoFila = instrucciones.getFila();
        int posicionColumna = recluta.getPosicion().getColumna();
        int posicionFila = recluta.getPosicion().getFila();


        return new Posicion(posicionFila + movimientoFila, posicionColumna + movimientoColumna);
    }

    public boolean moverBatallon(Recuadro destino, Entidad entidad) {
        if(batallon.size() != TAMANIO_BATALLON) {return false;}

        HashSet<Posicion> posicionesReclutas = new HashSet<>();
        Posicion instrucciones = generarInstrucciones(destino, entidad);



        for(PuedeFormarBatallon unRecluta: batallon){
            batallonParaLoop.add(unRecluta);
            posicionesReclutas.add(unRecluta.getPosicion());
        }

        while(batallon.size()!=0){

            for(PuedeFormarBatallon recluta : batallonParaLoop){
                Posicion posicionPotencial = generarPosicionPotencial(recluta,instrucciones);

                //TODO borrar
                posicionPotencial.print();

                boolean estaEnPosicionesReclutas = false;

                for(Posicion posicion:posicionesReclutas){
                    if (posicionPotencial.esIgual(posicion)){
                        estaEnPosicionesReclutas = true;
                    }
                }

                if(!estaEnPosicionesReclutas){
                    batallon.remove(recluta);


                    Recuadro casillero = tablero.obtenerCasillero(posicionPotencial);
                    boolean seMovio = recluta.moverComoRecluta(tablero,casillero);

                    //TODO borrar
                    System.out.println("Se movio el recluta: " + seMovio);
                    System.out.println("A la posicion ");
                    posicionPotencial.print();

                    posicionesReclutas.remove(recluta.getPosicion());

                    if(seMovio){
                        tablero.colocarVacio(recluta.getPosicion());

                    }
                }

            }

        }
        return true;
    }

}
