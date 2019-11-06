package fiuba.algo3.tp2;

public class Tablero {
	private final int tamanio = 20;
	private Casillero casilleros[][];

	private Entidad removerEntidadDeCasillero(int fila, int columna) {
		return casilleros[fila][columna].popEntidad();
	}

	private Entidad obtenerEntidadDeCasillero(Casillero casillero) {
		return casillero.getEntidad();
	}

	private int calcularDistancia(Casillero origen, Casillero destino) {
		// TODO: Hacer la logica
		/*
		Distancia Cercana: consta de una distancia de 1 a 2 casilleros (en cualquier dirección)
		Distancia Media: consta de una distancia de 3 a 5 (en cualquier dirección)
		Distancia Lejana: consta de una distancia de 6 a Infinito (en cualquier dirección)
		*/
		return 1;
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
		Entidad entidadOrigen = obtenerEntidadDeCasillero(origen);
		Entidad entidadDestino = obtenerEntidadDeCasillero(destino);
		int distancia = calcularDistancia(origen, destino);
		entidadOrigen.atacar(entidadDestino, distancia);
	}	
}
