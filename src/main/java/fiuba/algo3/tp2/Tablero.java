package fiuba.algo3.tp2;

public class Tablero {
	private final int tamanio = 20;
	private Casillero casilleros[][];

	public Tablero() {
		casilleros = new Casillero[tamanio][tamanio];

		// Arma sector aliado (parte superior)
		for (int fila = 0; fila < tamanio / 2; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Casillero(new SectorAliado());
			}
		}

		// Arma sector enemigo (parte inferior)
		for (int fila = tamanio / 2; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Casillero(new SectorEnemigo());
			}
		}
	}

	public void agregar(Entidad entidad, int fila, int columna) {
		entidad.colocarEn(casilleros[fila][columna]);
	}

	public void moverArriba(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila - 1][columna].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverAbajo(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila + 1][columna].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverIzquierda(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila][columna - 1].setEntidad(casilleros[fila][columna].sacar());
	}

	public void moverDerecha(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila][columna + 1].setEntidad(casilleros[fila][columna].sacar());
	}

	public boolean estaVacio(int fila, int columna) {
		return casilleros[fila][columna].estaVacio();
	}
}
