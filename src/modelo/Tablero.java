package modelo;

public class Tablero {
	private final int tamanio=20;
	private Casillero casilleros[][]; 
			
	public Tablero() {
		casilleros = new Casillero[tamanio][tamanio];
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {
				casilleros[i][j] = new Casillero();
			}
		}
	}
}
	
