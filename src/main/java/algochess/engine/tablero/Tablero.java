package algochess.engine.tablero;

import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.interfaces.entidades.PuedeFormarBatallon;
import algochess.engine.posicion.Posicion;
import algochess.engine.posicion.Posiciones;
import algochess.engine.juego.Juego;
import algochess.excepciones.CasilleroOcupadoException;
import algochess.excepciones.CasilleroVacioException;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;
import static algochess.engine.ConstantesUtils.TAMANIO_TABLERO;

public class Tablero {
	private Casillero[][] casilleros;

	public Tablero() {
		int tamanio = TAMANIO_TABLERO;
		casilleros = new Casillero[tamanio][tamanio];

		// Arma sector aliado (parte superior)
		for (int fila = 0; fila < tamanio / 2; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Casillero(new Posicion(fila, columna), Faccion.ALIADOS);
			}
		}

		// Arma sector enemigo (parte inferior)
		for (int fila = tamanio / 2; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				casilleros[fila][columna] = new Casillero(new Posicion(fila, columna), Faccion.ENEMIGOS);
			}
		}
	}

	public Casillero[][] getCasilleros() {
		return casilleros;
	}

	public Casillero obtenerCasillero(Posicion posicion) {
		return casilleros[posicion.getFila()][posicion.getColumna()];
	}

	public void colocarEntidad(Entidad entidad, Posicion posicion, Jugador jugador) {
		Casillero casillero = casilleros[posicion.getFila()][posicion.getColumna()];
		casillero.colocarEntidad(entidad);
	}

	public void atacarCasillero(Posicion atacante_, Posicion atacado_, Faccion faccionJugador)
			throws CasilleroVacioException {
		Casillero casilleroAtacante = casilleros[atacante_.getFila()][atacante_.getColumna()];
		Casillero casilleroAtacado = casilleros[atacado_.getFila()][atacado_.getColumna()];

		casilleroAtacante.atacar(casilleroAtacado, this, faccionJugador);

	}

	public void curarCasillero(Posicion curador_, Posicion curado_, Faccion faccionJugador)
			throws CasilleroVacioException {
		Casillero casilleroCurador = casilleros[curador_.getFila()][curador_.getColumna()];
		Casillero casilleroCurado = casilleros[curado_.getFila()][curado_.getColumna()];

		casilleroCurador.curar(casilleroCurado, this, faccionJugador);
	}

	public void moverEntidad(Posicion origenP, Posicion destinoP, Faccion faccionJugador)
			throws CasilleroVacioException, CasilleroOcupadoException {
		Casillero origen = obtenerCasillero(origenP);
		Casillero destino = obtenerCasillero(destinoP);
		System.out.println("Tablero mover entidad");
		origen.moverEntidad(this, origen, destino, faccionJugador);
	}

	public void reclutarEntidades(Posicion posicion, HashSet<PuedeFormarBatallon> reclutados, Queue<Posicion> cola,
			PuedeFormarBatallon entidad) {
		Casillero casillero = obtenerCasillero(posicion);
		casillero.reclutarEntidad(reclutados, cola, entidad);
	}

	public boolean esSoldadoAmigo(Faccion faccion, Posicion posicion) {
		Casillero casillero = obtenerCasillero(posicion);
		return casillero.esSoldadoAmigo(faccion);
	}

	private boolean enElCasilleroHayUnidad(Posicion unaPosicion) {
		return obtenerCasillero(unaPosicion).poseesUnidad();

	}

	public Entidad seleccionarEntidad(int fila, int columna, Juego juego) {
		Posicion posicion = new Posicion(fila, columna);
		Casillero casillero = obtenerCasillero(posicion);
		return casillero.seleccionarEntidad(juego);
	}

	/* DFS */
	public void colectaUnidadesContiguas(Posicion origen, HashSet<Casillero> atacados) {
		Stack<Posicion> stack = new Stack<>();
		Posiciones visitados = new Posiciones();
		HashSet<Posicion> posicionesPotenciales;
		stack.add(origen);

		while (stack.size() != 0) {
			Posicion posicionActual = stack.pop();
			posicionesPotenciales = posicionActual.generarPosicionesEnAlcance(1, 1);
			for (Posicion unaPosicion : posicionesPotenciales) {
				if (!visitados.contiene(unaPosicion)) {
					visitados.agregar(unaPosicion);
					if (enElCasilleroHayUnidad(unaPosicion)) {
						stack.push(unaPosicion);
						atacados.add(obtenerCasillero(unaPosicion));
					}
				}
			}
		}
	}
}