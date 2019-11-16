package AlgoChess.engine.comandante;

import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeFormarBatallon;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Tablero;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static AlgoChess.engine.Constantes.TAMANIO_BATALLON;

public class Comandante {
    private Queue<Posicion> cola;
    private HashSet<Posicion> visitados;
    private HashSet<PuedeFormarBatallon> batallon;
    private int tamanioBatallon;
    private Tablero tablero;
    private HashSet<PuedeFormarBatallon> batallonParaLoop;
    private HashSet<Posicion> posicionesReclutas;
    private Posicion instrucciones;
    private HashSet<PuedeFormarBatallon> reclutasYaMovidos;

    public Comandante(Tablero tablero_) {
        cola = new LinkedList<>();
        visitados = new HashSet<>();
        batallon = new HashSet<>();
        tamanioBatallon = TAMANIO_BATALLON;
        tablero = tablero_;
        batallonParaLoop = new HashSet<>();
        posicionesReclutas = new HashSet<>();
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

        for(Posicion unaPosicion : contiguos){
            int fila_ = unaPosicion.getFila();
            int columna_ = unaPosicion.getColumna();
            if(fila_ < 0 || fila_ > 19) contiguos.remove(unaPosicion);
            if(columna_ < 0 || columna_ > 19) contiguos.remove(unaPosicion);
        }

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

    private void generarInstrucciones(Recuadro destino, Entidad entidad) {
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
            posicionesReclutas.add(unRecluta.getPosicion());
        }
        reclutasYaMovidos = new HashSet<>();

    }

    public boolean moverBatallon(Recuadro destino, Entidad entidad) {
        if (batallon.size() != TAMANIO_BATALLON) {
            return false;
        }

        moverSetup();
        generarInstrucciones(destino, entidad);


        while (batallon.size() != 0) {

            for (PuedeFormarBatallon recluta : batallonParaLoop) {
                if(reclutasYaMovidos.contains(recluta)) continue;

                Posicion posicionPotencial = generarPosicionPotencial(recluta, instrucciones);


                boolean estaEnPosicionesReclutas = false;

                for (Posicion posicion : posicionesReclutas) {
                    if (posicionPotencial.esIgual(posicion)) {
                        estaEnPosicionesReclutas = true;
                    }
                }

                if (!estaEnPosicionesReclutas ) {
                    Posicion antigua = recluta.getPosicion();

                    batallon.remove(recluta);
                    reclutasYaMovidos.add(recluta);

                    Recuadro casillero = tablero.obtenerCasillero(posicionPotencial);

                    posicionesReclutas.remove(antigua);
                    boolean seMovio = recluta.moverComoRecluta(tablero, casillero);


                    //TODO borrar
                    System.out.print("Se movio el recluta: " + seMovio + ' ');
                    System.out.print("Posicion: ");
                    posicionPotencial.print();



                    if (seMovio) {
                        tablero.colocarVacio(antigua);
                    }
                }

            }

        }
        return true;
    }

}
