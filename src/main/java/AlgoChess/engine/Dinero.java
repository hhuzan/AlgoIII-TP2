package AlgoChess.engine;

public class Dinero {
    private int monto;

    public Dinero(int monto_) {
        monto = monto_;
    }

    public Dinero restarDinero(Dinero costo) {
        int nuevo_monto = monto - costo.monto;
        if (nuevo_monto <= 0) {
            return new Dinero(0);
        }
        monto = nuevo_monto;
        return new Dinero(costo.monto);
    }

    public boolean sonIguales(Dinero dinero) {
        return monto == dinero.monto;
    }
}
