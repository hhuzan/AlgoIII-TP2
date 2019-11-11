package fiuba.algo3.tp2;

public class Tablero {
	private final int tamanio = 20;
	private Casillero casilleros[][];

	private Distancia calcularDistancia(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {

		int distancia;
		
		if ((filaOrigen - filaDestino != 0) && (columnaOrigen - columnaDestino != 0))
			distancia = Math.min(Math.abs(filaOrigen - filaDestino), Math.abs(columnaOrigen - columnaDestino));
		else
			distancia = Math.max(Math.abs(filaOrigen - filaDestino), Math.abs(columnaOrigen - columnaDestino));		

		if(distancia < 3)
			return new DistanciaCercana(distancia);
		else if(distancia  < 6)
			return new DistanciaMedia(distancia);
		else 
			return new DistanciaLejana(distancia);

	}

	public Tablero() {
		casilleros = new Casillero[tamanio][tamanio];

		// Arma sector aliado (parte superior)
		for (int fila = 0; fila < tamanio / 2; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new CasilleroAliado();
			}
		}

		// Arma sector enemigo (parte inferior)
		for (int fila = tamanio / 2; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new CasilleroEnemigo();
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

	public void atacar(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
		Casillero casilleroOrigen = casilleros[filaOrigen][columnaOrigen];
		Casillero casilleroDestino = casilleros[filaDestino][columnaDestino];
		Distancia distancia = calcularDistancia(filaOrigen, columnaOrigen, filaDestino, columnaDestino);
		casilleroOrigen.atacar(casilleroDestino, distancia);
	}

	public void curar(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
		Casillero casilleroOrigen = casilleros[filaOrigen][columnaOrigen];
		Casillero casilleroDestino = casilleros[filaDestino][columnaDestino];
		Distancia distancia = calcularDistancia(filaOrigen, columnaOrigen, filaDestino, columnaDestino);
		casilleroOrigen.curar(casilleroDestino, distancia);
	}

}
