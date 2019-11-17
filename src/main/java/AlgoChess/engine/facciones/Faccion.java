package AlgoChess.engine.facciones;

public enum Faccion {
	ALIADOS("Aliado"),
	ENEMIGOS("Enemigo");


	private String faccion;

	private Faccion(String str) {
		this.faccion = str;
	}

	public String getFaccion() {
		return faccion;
	}
}
