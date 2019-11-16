package AlgoChess.engine.posicion;


import java.util.HashSet;

public class Posiciones {
    private HashSet<Posicion> conjunto;
    public Posiciones(){
        conjunto = new HashSet<>();
    }

    public void agregar(Posicion posicion){
        boolean estaDentroDelRango = true;

        int fila_ = posicion.getFila();
        int columna_ = posicion.getColumna();
        if(fila_ < 0 || fila_ > 19) estaDentroDelRango = false;
        if(columna_ < 0 || columna_ > 19) estaDentroDelRango = false;


        boolean estaContenida = false;
        for (Posicion unaPosicion : conjunto){
            if(unaPosicion.esIgual(posicion)){
                estaContenida = true;
                break;
            }
        }
        if(!estaContenida && estaDentroDelRango) conjunto.add(posicion);
    }

    public boolean contiene(Posicion posicion){
        for (Posicion unaPosicion : conjunto){
            if(unaPosicion.esIgual(posicion)){
                return true;
            }
        }
        return false;
    }
    void remover(Posicion posicion){
        conjunto.remove(posicion);
    }
    HashSet<Posicion> posiciones(){
        return conjunto;
    }
}
