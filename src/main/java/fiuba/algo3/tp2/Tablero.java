package fiuba.algo3.tp2;

public class Tablero {
	private final int tamanio = 20;
	private Casillero casilleros[][];

//	private Entidad removerEntidadDeCasillero(int fila, int columna) {
//		return casilleros[fila][columna].popEntidad();
//	}

	private Entidad obtenerEntidadDeCasillero(Casillero casillero) {
		return casillero.getEntidad();
	}

	private int calcularDistancia(Casillero origen, Casillero destino) {
		if( (origen.getFila() - destino.getFila() != 0) && (origen.getColumna() - destino.getColumna() != 0) ) 
			return Math.min(Math.abs(origen.getFila() - destino.getFila()), Math.abs(origen.getColumna() - destino.getColumna()));
		else
			return Math.max(Math.abs(origen.getFila() - destino.getFila()), Math.abs(origen.getColumna() - destino.getColumna()));
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

	public Casillero obtenerCasilleroPorPosicion(int fila, int columna) {
		return casilleros[fila][columna];
	}

	public void colocar(Entidad entidad, int fila, int columna) {
		entidad.colocarEn(casilleros[fila][columna]);
	}

	public void moverArriba(int fila, int columna) { // TODO agregar execpcion limites
		obtenerCasilleroPorPosicion(fila-1, columna).moverDesde(casilleros[fila][columna]);
	}

	public void moverAbajo(int fila, int columna) { // TODO agregar execpcion limites
		obtenerCasilleroPorPosicion(fila+1, columna).moverDesde(casilleros[fila][columna]);
	}

	public void moverIzquierda(int fila, int columna) { // TODO agregar execpcion limites
		obtenerCasilleroPorPosicion(fila, columna-1).moverDesde(casilleros[fila][columna]);
	}

	public void moverDerecha(int fila, int columna) { // TODO agregar execpcion limites
		obtenerCasilleroPorPosicion(fila, columna+1).moverDesde(casilleros[fila][columna]);
	}

	public boolean estaVacio(int fila, int columna) {
		return casilleros[fila][columna].estaVacio();
	}

	public void atacar(Casillero origen, Casillero destino) {
//		Casillero origen = casilleros[filaOrigen][columnaOrigen];
//		Casillero destino = casilleros[filaDestino][columnaDestino];
		int distancia = calcularDistancia(origen, destino);
		origen.atacar(destino, distancia);
	}	
}
