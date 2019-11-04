package fiuba.algo3.tp2;

public class Tablero {
	private final int tamanio = 20;
	private Casillero casilleros[][];

	public Tablero() {
		casilleros = new Casillero[tamanio][tamanio];
		for (int fila = 0; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Casillero();
			}
		}
	}

	public void agregar(int fila, int columna, Entidad entidad) {
		casilleros[fila][columna].colocar(entidad);
	}

	public void moverArriba(int fila, int columna) { //TODO agregar execpcion limites
		casilleros[fila - 1][columna].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverAbajo(int fila, int columna) { //TODO agregar execpcion limites
		casilleros[fila + 1][columna].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverIzquierda(int fila, int columna) { //TODO agregar execpcion limites
		casilleros[fila][columna - 1].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverDerecha(int fila, int columna) { //TODO agregar execpcion limites
		casilleros[fila][columna + 1].setEntidad(casilleros[fila][columna].sacar());
	}

	public boolean estaVacio(int fila, int columna) {
		return casilleros[fila][columna].estaVacio();
	}
}
