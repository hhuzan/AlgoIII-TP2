package fiuba.algo3.tp2;

public class Tablero {
	private final int tamanio = 20;
	private Casillero casilleros[][];

//	private Entidad removerEntidadDeCasillero(int fila, int columna) {
//		return casilleros[fila][columna].popEntidad();
//	}

	private int calcularDistancia(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
		if ((filaOrigen - filaDestino != 0) && (columnaOrigen - columnaDestino != 0))
			return Math.min(Math.abs(filaOrigen - filaDestino), Math.abs(columnaOrigen - columnaDestino));
		else
			return Math.max(Math.abs(filaOrigen - filaDestino), Math.abs(columnaOrigen - columnaDestino));
	}

	public Tablero() {
		casilleros = new Casillero[tamanio][tamanio];

		// Arma sector aliado (parte superior)
		for (int fila = 0; fila < tamanio / 2; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new CasilleroAliado(fila, columna);
			}
		}

		// Arma sector enemigo (parte inferior)
		for (int fila = tamanio / 2; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new CasilleroEnemigo(fila, columna);
			}
		}
	}

	public void colocar(Entidad entidad, int fila, int columna) {
		entidad.colocarEn(casilleros[fila][columna]);
	}

	public void moverArriba(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila - 1][columna].moverDesde(casilleros[fila][columna]);
	}

	public void moverAbajo(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila + 1][columna].moverDesde(casilleros[fila][columna]);
	}

	public void moverIzquierda(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila][columna - 1].moverDesde(casilleros[fila][columna]);
	}

	public void moverDerecha(int fila, int columna) { // TODO agregar execpcion limites
		casilleros[fila][columna + 1].moverDesde(casilleros[fila][columna]);
	}

	public boolean estaVacio(int fila, int columna) {
		return casilleros[fila][columna].estaVacio();
	}

	public void atacar(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
		Entidad atacante = casilleros[filaOrigen][columnaOrigen].getEntidad();
		Entidad atacado = casilleros[filaDestino][columnaDestino].getEntidad();
		int distancia = calcularDistancia(filaOrigen, columnaOrigen, filaDestino, columnaDestino);
		atacante.atacar(atacado, distancia);
	}

	public void curar(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
		Entidad curador = casilleros[filaOrigen][columnaOrigen].getEntidad();
		Entidad curado = casilleros[filaDestino][columnaDestino].getEntidad();
		int distancia = calcularDistancia(filaOrigen, columnaOrigen, filaDestino, columnaDestino);
		curador.curar(curado, distancia);
	}
}
