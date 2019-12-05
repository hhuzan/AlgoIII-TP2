package algochess;

import algochess.engine.comandante.Comandante;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.tablero.Casillero;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Tablero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComandanteTest {

	@Test
	public void test00constructorComandanteNoDevuelveNull() {
		Tablero tablero = new Tablero();
		Comandante comandante = new Comandante(tablero);
		assertNotNull(comandante);
	}

	@Test
	public void test01ComandanteNoMueveDosSoldados() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);

		Soldado soldado1 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado2 = new Soldado(jugador, Faccion.ALIADOS);
		Posicion posicion1 = new Posicion(1, 5);
		Posicion posicion2 = new Posicion(1, 6);

		Comandante comandante = new Comandante(tablero);

		tablero.colocarEntidad(soldado1, posicion1, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado2, posicion2, new Jugador(Faccion.ALIADOS, "Lucas"));

		comandante.recluteMisCercanos(soldado1);

		Casillero destino = tablero.obtenerCasillero(new Posicion(2, 5));

		assertFalse(comandante.moverBatallon(tablero, destino, soldado1));
	}

	@Test
	public void test02ComandanteMueveBatallon() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);

		Soldado soldado1 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado2 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
		Posicion posicion1 = new Posicion(1, 5);
		Posicion posicion2 = new Posicion(1, 6);
		Posicion posicion3 = new Posicion(1, 7);

		Comandante comandante = new Comandante(tablero);

		tablero.colocarEntidad(soldado1, posicion1, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado2, posicion2, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado3, posicion3, new Jugador(Faccion.ALIADOS, "Lucas"));

		comandante.recluteMisCercanos(soldado1);

		Casillero destino = tablero.obtenerCasillero(new Posicion(2, 5));

		assertTrue(comandante.moverBatallon(tablero, destino, soldado1));
	}

	@Test
	public void test03ComandanteMueveBatallonComprobacionCasillerosVacios() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);

		Soldado soldado1 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado2 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
		Posicion posicion1 = new Posicion(1, 5);
		Posicion posicion2 = new Posicion(1, 6);
		Posicion posicion3 = new Posicion(1, 7);

		Comandante comandante = new Comandante(tablero);

		tablero.colocarEntidad(soldado1, posicion1, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado2, posicion2, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado3, posicion3, new Jugador(Faccion.ALIADOS, "Lucas"));

		comandante.recluteMisCercanos(soldado1);

		Casillero destino = tablero.obtenerCasillero(new Posicion(2, 5));

		comandante.moverBatallon(tablero, destino, soldado1);
		
		assertFalse(tablero.obtenerCasillero(posicion1).isOcupado());
		assertFalse(tablero.obtenerCasillero(posicion1).isOcupado());
		assertFalse(tablero.obtenerCasillero(posicion1).isOcupado());
		// TODO: Verificar esto sin el tipo Vacio que no existe más
		// assertTrue(tablero.obtenerCasillero(posicion1) instanceof Vacio);
		// assertTrue(tablero.obtenerCasillero(posicion1) instanceof Vacio);
		// assertTrue(tablero.obtenerCasillero(posicion1) instanceof Vacio);
	}

	@Test
	public void test04ComandanteMueveBatallonComprobacionCasillerosOcupados() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);

		Soldado soldado1 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado2 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
		Posicion posicion1 = new Posicion(1, 5);
		Posicion posicion2 = new Posicion(1, 6);
		Posicion posicion3 = new Posicion(1, 7);

		Comandante comandante = new Comandante(tablero);

		tablero.colocarEntidad(soldado1, posicion1, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado2, posicion2, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado3, posicion3, new Jugador(Faccion.ALIADOS, "Lucas"));

		comandante.recluteMisCercanos(soldado1);

		Casillero destino = tablero.obtenerCasillero(new Posicion(2, 5));

		comandante.moverBatallon(tablero, destino, soldado1);

		// TODO: Idem test03 con ocupado
		assertTrue(tablero.obtenerCasillero(new Posicion(2, 5)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(2, 6)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(2, 7)).isOcupado());
		// assertTrue(tablero.obtenerCasillero(new Posicion(2,5)) instanceof Ocupado);
		// assertTrue(tablero.obtenerCasillero(new Posicion(2,6)) instanceof Ocupado);
		// assertTrue(tablero.obtenerCasillero(new Posicion(2,7)) instanceof Ocupado);
	}

	@Test
	public void test05ComandanteMueveBatallonConObstaculo() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);

		Soldado soldado1 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado2 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
		Posicion posicion1 = new Posicion(1, 5);
		Posicion posicion2 = new Posicion(1, 6);
		Posicion posicion3 = new Posicion(1, 7);

		Jinete obstaculo = new Jinete(jugador, Faccion.ALIADOS);
		Posicion pobstaculo = new Posicion(2, 6);

		Comandante comandante = new Comandante(tablero);

		tablero.colocarEntidad(soldado1, posicion1, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado2, posicion2, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado3, posicion3, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(obstaculo, pobstaculo, new Jugador(Faccion.ALIADOS, "Lucas"));

		comandante.recluteMisCercanos(soldado1);

		Casillero destino = tablero.obtenerCasillero(new Posicion(2, 5));

		comandante.moverBatallon(tablero, destino, soldado1);

		assertTrue(tablero.obtenerCasillero(new Posicion(2, 5)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(1, 6)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(2, 7)).isOcupado());

		// assertTrue(tablero.obtenerCasillero(new Posicion(2,5)) instanceof Ocupado);
		// assertTrue(tablero.obtenerCasillero(new Posicion(1,6)) instanceof Ocupado);
		// assertTrue(tablero.obtenerCasillero(new Posicion(2,7)) instanceof Ocupado);
	}

	@Test
	public void test06ComandanteMueveBatallonConObstaculoYSeDisuelve() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);

		Soldado soldado1 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado2 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
		Posicion posicion1 = new Posicion(1, 5);
		Posicion posicion2 = new Posicion(1, 6);
		Posicion posicion3 = new Posicion(1, 7);

		Jinete obstaculo = new Jinete(jugador, Faccion.ALIADOS);
		Posicion pobstaculo = new Posicion(2, 6);

		Comandante comandante = new Comandante(tablero);

		tablero.colocarEntidad(soldado1, posicion1, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado2, posicion2, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado3, posicion3, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(obstaculo, pobstaculo, new Jugador(Faccion.ALIADOS, "Lucas"));

		Casillero destino1 = tablero.obtenerCasillero(new Posicion(2, 5));
		comandante.recluteMisCercanos(soldado1);
		comandante.moverBatallon(tablero, destino1, soldado1);

		comandante.recluteMisCercanos(soldado1);
		Casillero destino2 = tablero.obtenerCasillero(new Posicion(2, 5));
		comandante.moverBatallon(tablero, destino2, soldado2);

		assertTrue(tablero.obtenerCasillero(new Posicion(1, 6)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(2, 5)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(2, 6)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(2, 7)).isOcupado());

		// TODO: ver tests anteriores
		// assertTrue(tablero.obtenerCasillero(new Posicion(1,6)) instanceof Ocupado);
		// assertTrue(tablero.obtenerCasillero(new Posicion(2,6)) instanceof Ocupado);
		// assertTrue(tablero.obtenerCasillero(new Posicion(2,5)) instanceof Ocupado);
		// assertTrue(tablero.obtenerCasillero(new Posicion(2,7)) instanceof Ocupado);
	}


	@Test
	public void test07ComandanteMueveBatallonConObstaculoYSeDisuelve() {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(Faccion.ALIADOS);

		Soldado soldado1 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado2 = new Soldado(jugador, Faccion.ALIADOS);
		Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
		Posicion posicion1 = new Posicion(1, 5);
		Posicion posicion2 = new Posicion(1, 6);
		Posicion posicion3 = new Posicion(1, 7);

		Jinete obstaculo = new Jinete(jugador, Faccion.ALIADOS);
		Posicion pobstaculo = new Posicion(2, 6);

		Comandante comandante = new Comandante(tablero);

		tablero.colocarEntidad(soldado1, posicion1, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado2, posicion2, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(soldado3, posicion3, new Jugador(Faccion.ALIADOS, "Lucas"));
		tablero.colocarEntidad(obstaculo, pobstaculo, new Jugador(Faccion.ALIADOS, "Lucas"));

		Casillero destino1 = tablero.obtenerCasillero(new Posicion(1, 4));
		comandante.recluteMisCercanos(soldado1);
		comandante.moverBatallon(tablero, destino1, soldado1);

		assertTrue(tablero.obtenerCasillero(new Posicion(1, 4)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(1, 5)).isOcupado());
		assertTrue(tablero.obtenerCasillero(new Posicion(1, 6)).isOcupado());
	}

}
