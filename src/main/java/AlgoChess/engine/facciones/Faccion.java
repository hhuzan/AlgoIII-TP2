package AlgoChess.engine.facciones;

// TODO: Hacer enumerativo

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
