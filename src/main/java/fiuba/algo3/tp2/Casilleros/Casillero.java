<<<<<<< HEAD:src/main/java/fiuba/algo3/tp2/Casilleros/Casillero.java
package fiuba.algo3.tp2;

public abstract class Casillero {

	private Entidad entidad;
	private Estado estado;
	protected int fila;
	protected int columna;

	public Casillero() {
		estado = new Vacio(this);
	}
	
	public Casillero(int fila, int columna) {
		estado = new Vacio(this);
		this.fila = fila;
		this.columna = columna;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
		estado = new Ocupado(this);
	}
	
	public Estado getEstado() {
		return estado;
	}

	public boolean estaVacio() {
		return estado.estaVacio();
	}

	public Entidad popEntidad() {
		Entidad respuesta = entidad;
		entidad = null;
		estado = new Vacio(this);
		return respuesta;
	}

	public void atacar(Casillero destino, int distancia) {
		estado.atacar(destino, distancia);
	}

	public void recibirAtaque(int danio, int distancia) {
		estado.recibirAtaque(danio, distancia);
	}

	public abstract void colocar(Aliado aliado);

	public abstract void colocar(Enemigo enemigo);

	public abstract int getFila();

	public abstract int getColumna();



	public void moverDesde(Casillero casillero) {
		estado = estado.moverDesde(casillero);
	}

}
=======
package fiuba.algo3.tp2;

public abstract class Casillero {

	private Entidad entidad;
	private Estado estado;
	protected int fila;
	protected int columna;

	public Casillero() {
		estado = new Vacio(this);
	}
	
	public Casillero(int fila, int columna) {
		estado = new Vacio(this);
		this.fila = fila;
		this.columna = columna;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
		estado = new Ocupado(this);
	}
	
	public Estado getEstado() {
		return estado;
	}

	public boolean estaVacio() {
		return estado.estaVacio();
	}

	public Entidad popEntidad() {
		Entidad respuesta = entidad;
		entidad = null;
		estado = new Vacio(this);
		return respuesta;
	}

	public void atacar(Casillero destino, int distancia) {
		estado.atacar(destino, distancia);
	}

	public void curar(Casillero destino, int distancia) {
		estado.curar(destino, distancia);
	}

	public void recibirAtaque(int danio, int distancia) {
		estado.recibirAtaque(danio, distancia);
	}

	public void recibirCuracion(int curacion, int distancia) {
		estado.recibirCuracion(curacion, distancia);
	}
	public abstract void colocar(Aliado aliado);

	public abstract void colocar(Enemigo enemigo);

	public abstract int getFila();

	public abstract int getColumna();



	public void moverDesde(Casillero casillero) {
		estado = estado.moverDesde(casillero);
	}

}
>>>>>>> master:src/main/java/fiuba/algo3/tp2/Casillero.java
