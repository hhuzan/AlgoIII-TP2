package fiuba.algo3.tp2;

public class Tablero {
	private final int tamanio = 20;
	private Casillero casilleros[][];

	public Tablero() {
		casilleros = new Casillero[tamanio][tamanio];
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {
				casilleros[i][j] = new Casillero();
			}
		}
	}

	public void agregarEntidadATablero(int fila, int columna, Entidad entidadAAgregar) {

		casilleros[fila][columna].colocar(entidadAAgregar);

	}

	public void moverArriba(int fila, int columna) {
		casilleros[fila - 1][columna].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverAbajo(int fila, int columna) {
		casilleros[fila + 1][columna].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverIzquierda(int fila, int columna) {
		casilleros[fila][columna - 1].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverDerecha(int fila, int columna) {
		casilleros[fila][columna + 1].setEntidad(casilleros[fila][columna].sacar());
	}

	public boolean estaVacio(int fila, int columna) {
		return casilleros[fila][columna].estaVacio();
	}
}
