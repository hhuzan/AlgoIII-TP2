package algochess.engine.tablero;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.posicion.Posicion;
import algochess.engine.posicion.Posiciones;
import algochess.excepciones.CasilleroOcupadoException;
import algochess.excepciones.CasilleroVacioException;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;
import static algochess.engine.ConstantesUtils.TAMANIO_TABLERO;
import java.util.Observable;
import java.util.Observer;

public class Tablero extends Observable {
	private Casillero[][] casilleros;

	public Tablero(Faccion aliados, Faccion enemigos) {
		int tamanio = TAMANIO_TABLERO;
		casilleros = new Casillero[tamanio][tamanio];

		// Arma sector aliado (parte superior)
		for (int fila = 0; fila < tamanio / 2; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Casillero(new Posicion(fila, columna), aliados);
			}
		}

		// Arma sector enemigo (parte inferior)
		for (int fila = tamanio / 2; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Casillero(new Posicion(fila, columna), enemigos);
			}
		}
	}

	public Casillero obtenerCasillero(Posicion posicion) {
		return casilleros[posicion.getFila()][posicion.getColumna()];
	}

	public void colocarEntidad(Entidad entidad, Posicion posicion) {
		Casillero casillero = casilleros[posicion.getFila()][posicion.getColumna()];
		casillero.colocarEntidad(entidad);
	}

	public void atacarCasillero(Posicion atacante_, Posicion atacado_, Faccion faccionJugador) throws CasilleroVacioException {
		Casillero casilleroAtacante = casilleros[atacante_.getFila()][atacante_.getColumna()];
		Casillero casilleroAtacado = casilleros[atacado_.getFila()][atacado_.getColumna()];

		casilleroAtacante.atacar(casilleroAtacado, this, faccionJugador);
	}

	public void curarCasillero(Posicion curador_, Posicion curado_, Faccion faccionJugador) throws CasilleroVacioException {
		Casillero casilleroCurador = casilleros[curador_.getFila()][curador_.getColumna()];
		Casillero casilleroCurado = casilleros[curado_.getFila()][curado_.getColumna()];

		casilleroCurador.curar(casilleroCurado, this, faccionJugador);
	}

	public void moverEntidad(Posicion origenP, Posicion destinoP, Faccion faccionJugador) throws CasilleroVacioException, CasilleroOcupadoException {
		Casillero origen = obtenerCasillero(origenP);
		Casillero destino = obtenerCasillero(destinoP);

		origen.moverEntidad(this, origen, destino, faccionJugador);
	}

	public void reclutarEntidades(Posicion posicion, HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {
		Casillero casillero = obtenerCasillero(posicion);
		casillero.reclutarEntidad(reclutados, cola, entidad);
	}

	public boolean esSoldadoAmigo(Faccion faccion, Posicion posicion){
		Casillero casillero = obtenerCasillero(posicion);
		return casillero.esSoldadoAmigo(faccion);
	}

	private boolean enElCasilleroHayUnidad(Posicion unaPosicion){
		return obtenerCasillero(unaPosicion).poseesUnidad();

	}

	/*DFS*/
	public void colectaUnidadesContiguas(Posicion origen, HashSet<Casillero> atacados){
		Stack<Posicion> stack = new Stack<>();
		Posiciones visitados = new Posiciones();
		HashSet<Posicion> posicionesPotenciales;
		stack.add(origen);

		while(stack.size() != 0){
			Posicion posicionActual = stack.pop();
			posicionesPotenciales = posicionActual.generarPosicionesEnAlcance(1,1);
			for(Posicion unaPosicion : posicionesPotenciales){
				if(!visitados.contiene(unaPosicion)){
					visitados.agregar(unaPosicion);
					if(enElCasilleroHayUnidad(unaPosicion)){
						stack.push(unaPosicion);
						atacados.add(obtenerCasillero(unaPosicion));
					}
				}
			}
		}
	}
}


//	private boolean esMovimientoValido(Posicion origen, Posicion destino) {
//		Calculadora calculadora = new Calculadora();
//		int x1, y1, x2, y2, distancia;
//		x1 = origen.getColumna();
//		y1 = origen.getFila();
//		x2 = destino.getColumna();
//		y2 = destino.getFila();
//		distancia = MAXIMA_DISTANCIA_POR_MOVIMIENTO;
//
//		return calculadora.distanciaValidaEntreDosPosiciones(x1, y1, x2, y2, distancia, distancia);
//	}