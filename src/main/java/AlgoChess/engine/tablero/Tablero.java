package AlgoChess.engine.tablero;

import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.interfaces.casillero.Recuadro;
import AlgoChess.engine.interfaces.entidades.PuedeFormarBatallon;
import AlgoChess.engine.matematica.Calculadora;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.posicion.Posiciones;
import AlgoChess.excepciones.CasilleroOcupadoException;
import AlgoChess.excepciones.CasilleroVacioException;

import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

import static AlgoChess.engine.Constantes.MAXIMA_DISTANCIA_POR_MOVIMIENTO;
import static AlgoChess.engine.Constantes.TAMANIO_TABLERO;

public class Tablero {
	private Recuadro[][] casilleros;

	public Tablero(Faccion aliados, Faccion enemigos) {
		int tamanio = TAMANIO_TABLERO;
		casilleros = new Casillero[tamanio][tamanio];

		// Arma sector aliado (parte superior)
		for (int fila = 0; fila < tamanio / 2; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Vacio(new Posicion(fila, columna), aliados);
			}
		}

		// Arma sector enemigo (parte inferior)
		for (int fila = tamanio / 2; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Vacio(new Posicion(fila, columna), enemigos);
			}
		}
	}

	public Recuadro obtenerCasillero(Posicion posicion) {
		return casilleros[posicion.getFila()][posicion.getColumna()];
	}

	void cambiarCasillero(Recuadro casillero) {
		Posicion posicion = casillero.getPosicion();
		casilleros[posicion.getFila()][posicion.getColumna()] = casillero;
	}

	public void colocarVacio(Posicion posicion) {
		Recuadro casillero = obtenerCasillero(posicion);
		Recuadro vacio = new Vacio(casillero);
		cambiarCasillero(vacio);
	}

	public void colocarEntidad(Entidad entidad, Posicion posicion) {
		Recuadro casillero = casilleros[posicion.getFila()][posicion.getColumna()];
		casillero.colocarEntidad(entidad, this);
	}

	private boolean esMovimientoValido(Posicion origen, Posicion destino) {
		Calculadora calculadora = new Calculadora();
		int x1, y1, x2, y2, distancia;
		x1 = origen.getColumna();
		y1 = origen.getFila();
		x2 = destino.getColumna();
		y2 = destino.getFila();
		distancia = MAXIMA_DISTANCIA_POR_MOVIMIENTO;

		return calculadora.distanciaValidaEntreDosPosiciones(x1, y1, x2, y2, distancia, distancia);
	}


	public void atacarCasillero(Posicion atacante_, Posicion atacado_, Faccion faccionJugador) throws CasilleroVacioException {
		Recuadro casilleroAtacante = casilleros[atacante_.getFila()][atacante_.getColumna()];
		Recuadro casilleroAtacado = casilleros[atacado_.getFila()][atacado_.getColumna()];

		casilleroAtacante.atacar(casilleroAtacado, this, faccionJugador);
	}


	public void curarCasillero(Posicion curador_, Posicion curado_, Faccion faccionJugador) throws CasilleroVacioException {
		Recuadro casilleroCurador = casilleros[curador_.getFila()][curador_.getColumna()];
		Recuadro casilleroCurado = casilleros[curado_.getFila()][curado_.getColumna()];

		casilleroCurador.curar(casilleroCurado, this, faccionJugador);
	}


	public void moverEntidad(Posicion origenP, Posicion destinoP, Faccion faccionJugador) throws CasilleroVacioException, CasilleroOcupadoException {
		Recuadro origen = obtenerCasillero(origenP);
		Recuadro destino = obtenerCasillero(destinoP);

		origen.moverEntidad(this, destino, faccionJugador);
	}

	public void reclutarEntidades(Posicion posicion, HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola, PuedeFormarBatallon entidad) {
		Recuadro casillero = obtenerCasillero(posicion);
		casillero.reclutarEntidad(reclutados, cola, entidad);
	}

	public boolean esSoldadoAmigo(Faccion faccion, Posicion posicion){
		Recuadro casillero = obtenerCasillero(posicion);
		return casillero.esSoldadoAmigo(faccion);
	}

	private boolean enElCasilleroHayUnidad(Posicion unaPosicion){
		return obtenerCasillero(unaPosicion).poseesUnidad();

	}

	/*DFS*/
	public void colectaUnidadesContiguas(Posicion primero, HashSet<Recuadro> atacados){
		Recuadro primeroAtacado = obtenerCasillero(primero);

		Stack<Posicion> stack = new Stack<>();
		Posiciones visitados = new Posiciones();
		HashSet<Posicion> posicionesPotenciales;
		stack.add(primero);

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
