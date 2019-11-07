package fiuba.algo3.tp2;

public class CalculadorDanio {
  
  public static int danio(Soldado soldado,int distancia) {
  	if (distancia <= 1)
  		return 10;
  	else
  		return 0;
     }

  public static int danio(Jinete jinete,int distancia) {
    if(distancia == 1)
         return 5;
     else
         return 15;
  }

  public static int danio(Curandero curandero, int distancia) {
   return 0;
  }

  public static int danio(Catapulta catapulta, int distancia) {
     if(distancia == 1)
          return 0;
      else
          return 20;
  }
}
