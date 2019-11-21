package algochess;

import algochess.engine.comandante.Comandante;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.armas.rangos.Cercano;
import algochess.engine.entidades.armas.rangos.Rango;
import algochess.engine.facciones.Faccion;
import algochess.engine.interfaces.casillero.Recuadro;
import algochess.engine.jugador.Jugador;
import algochess.engine.posicion.Posicion;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Ocupado;

import algochess.engine.tablero.Tablero;
import algochess.engine.tablero.Vacio;
import org.junit.Test;


import static org.junit.Assert.*;

public class ComandanteTest {

    @Test
    public void test00constructorComandanteNoDevuelveNull(){
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Comandante comandante = new Comandante(tablero);
        assertNotNull(comandante);
    }

    @Test
    public void test01ComandanteNoMueveDosSoldados(){
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ALIADOS);

        Soldado soldado1 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado2 = new Soldado(jugador,Faccion.ALIADOS);
        Posicion posicion1 = new Posicion(1,5);
        Posicion posicion2 = new Posicion(1,6);

        Comandante comandante = new Comandante(tablero);

        tablero.colocarEntidad(soldado1,posicion1);
        tablero.colocarEntidad(soldado2,posicion2);

        comandante.recluteMisCercanos(soldado1);

        Recuadro destino = tablero.obtenerCasillero(new Posicion(2,5));

        assertFalse(comandante.moverBatallon(destino,soldado1));
    }

    @Test
    public void test02ComandanteMueveBatallon(){
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ALIADOS);

        Soldado soldado1 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado2 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
        Posicion posicion1 = new Posicion(1,5);
        Posicion posicion2 = new Posicion(1,6);
        Posicion posicion3 = new Posicion(1,7);


        Comandante comandante = new Comandante(tablero);

        tablero.colocarEntidad(soldado1,posicion1);
        tablero.colocarEntidad(soldado2,posicion2);
        tablero.colocarEntidad(soldado3,posicion3);

        comandante.recluteMisCercanos(soldado1);

        Recuadro destino = tablero.obtenerCasillero(new Posicion(2,5));

        assertTrue(comandante.moverBatallon(destino,soldado1));
    }

    @Test
    public void test03ComandanteMueveBatallonComprobacionCasillerosVacios(){
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ALIADOS);

        Soldado soldado1 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado2 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
        Posicion posicion1 = new Posicion(1,5);
        Posicion posicion2 = new Posicion(1,6);
        Posicion posicion3 = new Posicion(1,7);


        Comandante comandante = new Comandante(tablero);

        tablero.colocarEntidad(soldado1,posicion1);
        tablero.colocarEntidad(soldado2,posicion2);
        tablero.colocarEntidad(soldado3,posicion3);

        comandante.recluteMisCercanos(soldado1);

        Recuadro destino = tablero.obtenerCasillero(new Posicion(2,5));

        comandante.moverBatallon(destino,soldado1);

        assertTrue(tablero.obtenerCasillero(posicion1) instanceof Vacio);
        assertTrue(tablero.obtenerCasillero(posicion1) instanceof Vacio);
        assertTrue(tablero.obtenerCasillero(posicion1) instanceof Vacio);
    }

    @Test
    public void test04ComandanteMueveBatallonComprobacionCasillerosOcupados(){
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ALIADOS);

        Soldado soldado1 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado2 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
        Posicion posicion1 = new Posicion(1,5);
        Posicion posicion2 = new Posicion(1,6);
        Posicion posicion3 = new Posicion(1,7);


        Comandante comandante = new Comandante(tablero);

        tablero.colocarEntidad(soldado1,posicion1);
        tablero.colocarEntidad(soldado2,posicion2);
        tablero.colocarEntidad(soldado3,posicion3);

        comandante.recluteMisCercanos(soldado1);

        Recuadro destino = tablero.obtenerCasillero(new Posicion(2,5));

        comandante.moverBatallon(destino,soldado1);

        assertTrue(tablero.obtenerCasillero(new Posicion(2,5)) instanceof Ocupado);
        assertTrue(tablero.obtenerCasillero(new Posicion(2,6)) instanceof Ocupado);
        assertTrue(tablero.obtenerCasillero(new Posicion(2,7)) instanceof Ocupado);
    }

    @Test
    public void test05ComandanteMueveBatallonConObstaculo(){
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ALIADOS);

        Soldado soldado1 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado2 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
        Posicion posicion1 = new Posicion(1,5);
        Posicion posicion2 = new Posicion(1,6);
        Posicion posicion3 = new Posicion(1,7);

        Jinete obstaculo = new Jinete(jugador, Faccion.ALIADOS);
        Posicion pobstaculo = new Posicion(2,6);

        Comandante comandante = new Comandante(tablero);

        tablero.colocarEntidad(soldado1,posicion1);
        tablero.colocarEntidad(soldado2,posicion2);
        tablero.colocarEntidad(soldado3,posicion3);
        tablero.colocarEntidad(obstaculo,pobstaculo);

        comandante.recluteMisCercanos(soldado1);

        Recuadro destino = tablero.obtenerCasillero(new Posicion(2,5));

        comandante.moverBatallon(destino,soldado1);

        assertTrue(tablero.obtenerCasillero(new Posicion(2,5)) instanceof Ocupado);
        assertTrue(tablero.obtenerCasillero(new Posicion(1,6)) instanceof Ocupado);
        assertTrue(tablero.obtenerCasillero(new Posicion(2,7)) instanceof Ocupado);
    }

    @Test
    public void test06ComandanteMueveBatallonConObstaculoYSeDisuelve(){
        Tablero tablero = new Tablero(Faccion.ALIADOS,Faccion.ENEMIGOS);
        Jugador jugador = new Jugador(Faccion.ALIADOS);

        Soldado soldado1 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado2 = new Soldado(jugador,Faccion.ALIADOS);
        Soldado soldado3 = new Soldado(jugador, Faccion.ALIADOS);
        Posicion posicion1 = new Posicion(1,5);
        Posicion posicion2 = new Posicion(1,6);
        Posicion posicion3 = new Posicion(1,7);

        Jinete obstaculo = new Jinete(jugador, Faccion.ALIADOS);
        Posicion pobstaculo = new Posicion(2,6);

        Comandante comandante = new Comandante(tablero);

        tablero.colocarEntidad(soldado1,posicion1);
        tablero.colocarEntidad(soldado2,posicion2);
        tablero.colocarEntidad(soldado3,posicion3);
        tablero.colocarEntidad(obstaculo,pobstaculo);

        Recuadro destino1 = tablero.obtenerCasillero(new Posicion(2,5));
        comandante.recluteMisCercanos(soldado1);
        comandante.moverBatallon(destino1,soldado1);

        comandante.recluteMisCercanos(soldado1);
        Recuadro destino2 = tablero.obtenerCasillero(new Posicion(2,5));
        comandante.moverBatallon(destino2,soldado2);

        assertTrue(tablero.obtenerCasillero(new Posicion(1,6)) instanceof Ocupado);
        assertTrue(tablero.obtenerCasillero(new Posicion(2,6)) instanceof Ocupado);
        assertTrue(tablero.obtenerCasillero(new Posicion(2,5)) instanceof Ocupado);
        assertTrue(tablero.obtenerCasillero(new Posicion(2,7)) instanceof Ocupado);
    }

}
