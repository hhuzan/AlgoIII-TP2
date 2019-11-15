package AlgoChess.engine.entidades;

class Vida {
    private double puntosdevida;

    Vida(double vida) {
        puntosdevida = vida;
    }

    void aumentar(double cantidad) {
        puntosdevida = puntosdevida + cantidad;
    }

    void disminuir(double cantidad) {
        puntosdevida = puntosdevida - cantidad;
    }

    boolean igualA(double vida) {
        System.out.println(puntosdevida);
        return vida == puntosdevida;
    }

    boolean fallecio() {
        return (puntosdevida <= 0);
    }

}
