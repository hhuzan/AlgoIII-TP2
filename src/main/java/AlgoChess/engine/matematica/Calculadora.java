package AlgoChess.engine.matematica;

public class Calculadora {
    public boolean distanciaValidaEntreDosPosiciones(int x1, int y1, int x2, int y2, int min, int max) {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
        int low = Math.min(dx, dy);
        int high = Math.max(dx, dy);
        if (high < min || high > max) 
        	return false;
        
        return low * high == 0 || low == high;

    }
}
