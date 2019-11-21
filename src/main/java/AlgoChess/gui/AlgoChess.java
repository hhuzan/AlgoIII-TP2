import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class AlgoChess extends Application  {
    private static final int TAMANIO_CASILLERO = 25;
    private static final int COLUMNAS = 20;
    private static final int FILAS = 20;

    public static void main(String[] args) {
        launch(args);
    }

    /*private BorderPane crearVentanaPrincipal(){
        BorderPane panel = new BorderPane();
        /*panel.setTop(new Label("Top"));
        panel.setBottom(new Label("Bottom"));
        panel.setLeft(new Label("Left"));
        panel.setRight(new Label("Right"));
        panel.setCenter(new Label("Center"));
        return panel;
    }*/

    private GridPane crearVentaDeEntidades(){
        /*Se crea el panel de ventas y su configura el padding*/

        GridPane ventas = new GridPane();
        ventas.setPadding(new Insets(10,10,10,10));
        ventas.setVgap(20);
        ventas.setHgap(20);
        System.out.println("Venta entidades: Creamos GridPane");

        /*Se crean containers para los items*/

        Rectangle soldadoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle caballoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle curanderoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle catapultaContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        System.out.println("Venta entidades: Creamos containers p items");

        /* Se colocan las imagenes en los conteiners respectivos*/
        /* TODO: Esto no me corre
         Image soldadoNeutroImg = new Image("file:dog.jpg");
         Image caballoNeutroImg = new Image("file:dog.jpg");
         Image curanderoNeutroImg = new Image("file:dog.jpg");
         Image catapultaNeutroImg = new Image("file:dog.jpg");
         System.out.println("Venta entidades: Creamos imagenes p items");

         soldadoContainer.setFill(new ImagePattern(soldadoNeutroImg));
         caballoContainer.setFill(new ImagePattern(caballoNeutroImg));
         curanderoContainer.setFill(new ImagePattern(curanderoNeutroImg));
         catapultaContainer.setFill(new ImagePattern(catapultaNeutroImg));
         System.out.println("Venta entidades: fill imagepattern p items");
        */
        // /*Se agregan los containers al panel de ventas*/

         GridPane.setConstraints(soldadoContainer,0,0);
         GridPane.setConstraints(caballoContainer,0,1);
         GridPane.setConstraints(curanderoContainer,0,2);
         GridPane.setConstraints(catapultaContainer,0,3);
         System.out.println("Venta entidades: contraints");

         ventas.getChildren().addAll(soldadoContainer,caballoContainer,curanderoContainer,catapultaContainer);
         System.out.println("Venta entidades: adAll");

        return ventas;
    }

    private GridPane crearTablero(){
        GridPane tablero = new GridPane();
        tablero.setPadding(new Insets(10,10,10,10));
        tablero.setVgap(2);
        tablero.setHgap(2);

        /*faccion1*/
        for(int y=0;y<FILAS/2;y++){
            for(int x = 0; x<COLUMNAS;x++){
                Casillero casillero = new Casillero(y+1,x+1,TAMANIO_CASILLERO, Color.LIGHTPINK);
                GridPane.setConstraints(casillero,x,y);
                tablero.getChildren().add(casillero);
            }
        }

        /*faccion2*/
        for(int y=FILAS/2;y<FILAS;y++){
            for(int x = 0; x<COLUMNAS;x++){
                Casillero casillero = new Casillero(y+1,x+1,TAMANIO_CASILLERO, Color.AQUAMARINE);
                GridPane.setConstraints(casillero,x,y);
                tablero.getChildren().add(casillero);
            }
        }


        return tablero;
    }

    @Override
    public void start(Stage ventana) {

        /*Layout JUEGO*/
        BorderPane panel = new BorderPane();
        System.out.println("Creamos Panel");
        /*Layout TABLERO */
        GridPane tablero = crearTablero();
        System.out.println("Creamos Tablero");

        /*Layout VENTAS DE ENTIDADES*/
        GridPane ventas = crearVentaDeEntidades();
        System.out.println("Creamos Ventana");

        ventas.setAlignment(Pos.CENTER);
        panel.setLeft(ventas);
        panel.setCenter(tablero);
        System.out.println("Seteamos cosas");

        /*Escena */
        Scene escena = new Scene(panel, 1600,1000);
        System.out.println("Creamos escena");


        /* Ventana */
        ventana.setTitle("AlgoChess");
        ventana.setScene(escena);
        ventana.show();
        System.out.println("Mostramos");


    }

}
