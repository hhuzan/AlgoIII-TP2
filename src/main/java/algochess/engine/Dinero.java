package algochess.engine;

public class Dinero {
    private int monto;

    public Dinero(int monto_) {
        monto = monto_;
    }

    public Dinero restarDinero(Dinero costo) {
        int nuevo_monto = monto - costo.monto;
        if (nuevo_monto < 0) {
            return new Dinero(0);
        }
        monto = nuevo_monto;
        return new Dinero(costo.monto);
    }

    public boolean sonIguales(Dinero dinero) {
        return monto == dinero.monto;
    }

    public int getMonto() {
        return monto;
    }
    
    public String toString() {
    	return Integer.toString(monto);
    }

    public boolean superoMinimo(int minimo) {
        System.out.println("Viendo si supera el minimo...");
        System.out.println(monto >= minimo);
        return monto >= minimo;
    }

    public void set(int monto) {
        this.monto += monto;
    }
}
