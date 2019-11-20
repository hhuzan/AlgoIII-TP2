package AlgoChess.engine.entidades;

public class Vida {
    private double puntosdevida;
    double puntosdevidaAux;

    public Vida(double vida) {
        puntosdevida = vida;
        puntosdevidaAux = puntosdevida;
    }


   public void aumentar(double cantidad) {
        puntosdevida = puntosdevida + cantidad;
        if (puntosdevida >= puntosdevidaAux){
            puntosdevida = puntosdevidaAux;
        }
    }

   public void disminuir(double cantidad) {
        puntosdevida = puntosdevida - cantidad;
    }

   public boolean igualA(double vida) {
        return vida == puntosdevida;
    }

   public boolean fallecio() {
        return (puntosdevida <= 0);
    }

}
