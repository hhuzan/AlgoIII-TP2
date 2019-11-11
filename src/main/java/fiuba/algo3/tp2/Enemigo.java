package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.EntidadDelMismoEquipoException;

public class Enemigo extends Entidad {

	public Enemigo(Tipo tipo) {
		setTipo(tipo);
	}

	@Override
	public void colocarEn(Casillero casillero) {
		casillero.colocar(this);
	}

	/* ATAQUE */
	@Override 
	public void recibirAtaque(Entidad atacante, int danio) {
		atacante.verificarAtaque(this, danio);
	}

	@Override 
	public void recibirAtaque(Entidad atacante, int danio, boolean daniaTodo) {
		atacante.verificarAtaque(this, danio, daniaTodo);
	}

	@Override 
	public void ataque(Enemigo atacanteEnemigo, int danio) {
		throw new EntidadDelMismoEquipoException();
	}

	@Override 
	public void ataque(Enemigo atacanteEnemigo, int danio, boolean daniaTodo) {
		if(daniaTodo)
			tipo.recibirAtaque(this, danio);
		else
			throw new EntidadDelMismoEquipoException();
	}

	@Override 
	public void ataque(Aliado atacanteAliado, int danio) {
		tipo.recibirAtaque(this, danio);
	}

	@Override 
	public void ataque(Aliado atacanteAliado, int danio, boolean daniaTodo) {
		ataque(atacanteAliado, danio);
	}

	@Override 
	public void verificarAtaque(Entidad atacada, int danio) {
		atacada.ataque(this, danio);
	}

	@Override 
	public void verificarAtaque(Entidad atacada, int danio, boolean daniaTodo) {
		atacada.ataque(this, danio, daniaTodo);
	}

	/* CURACION */
	@Override 
	public void recibirCuracion(Entidad curador, int danio) {
		curador.verificarCuracion(this, danio);
	}

	@Override 
	public void curacion(Enemigo atacanteEnemigo, int danio) {
		tipo.recibirCuracion(danio);
	}

	@Override 
	public void curacion(Aliado atacanteAliado, int danio) {
		tipo.recibirCuracion(danio);
	}

	@Override 
	public void verificarCuracion(Entidad atacada, int danio) {
		atacada.curacion(this, danio);
	}
 }
