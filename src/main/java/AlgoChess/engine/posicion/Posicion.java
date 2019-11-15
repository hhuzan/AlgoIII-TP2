package AlgoChess.engine.posicion;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int fila_, int columna_) {
        fila = fila_;
        columna = columna_;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public boolean esIgual(Posicion posicion) {
        return posicion.columna == columna && posicion.fila == fila;
    }

    //TODO borrar
    public void print(){
        System.out.println(fila+", "+columna);
    }

}
