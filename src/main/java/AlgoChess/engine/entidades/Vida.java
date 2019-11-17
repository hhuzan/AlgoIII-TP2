package AlgoChess.engine.entidades;

public class Vida {
    private double puntosdevida;
    double puntosdevidaAux;

    public Vida(double vida) {
        puntosdevida = vida;
        puntosdevidaAux = puntosdevida;
    }


    void aumentar(double cantidad) {
        puntosdevida = puntosdevida + cantidad;
        if (puntosdevida >= puntosdevidaAux){
            puntosdevida = puntosdevidaAux;
        }
    }

    void disminuir(double cantidad) {
        puntosdevida = puntosdevida - cantidad;
    }

    boolean igualA(double vida) {
        return vida == puntosdevida;
    }

    boolean fallecio() {
        return (puntosdevida <= 0);
    }

}
