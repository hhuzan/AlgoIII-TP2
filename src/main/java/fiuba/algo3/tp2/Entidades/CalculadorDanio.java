package fiuba.algo3.tp2;

public class CalculadorDanio {

  private static int danioCuerpoSoldado = 10;
  private static int danioLejanoSoldado = 0;
  private static int danioCuerpoJinete = 5;
  private static int danioLejanoJinete = 15;
  private static int danioCuerpoCatapulta = 0;
  private static int danioLejanoCatapulta = 20;
  
  public static int danio(Soldado soldado, int distancia) {
    if (distancia == 1)
  		return danioCuerpoSoldado;
  	else
  		return danioLejanoSoldado;
    }

  public static int danio(Jinete jinete, int distancia) {
    if(distancia == 1)
      return danioCuerpoJinete;
    else
      return danioLejanoJinete;
  }

  public static int danio(Catapulta catapulta, int distancia) {
    if(distancia == 1)
      return danioCuerpoCatapulta;
    else
      return danioLejanoCatapulta;
  }
}
