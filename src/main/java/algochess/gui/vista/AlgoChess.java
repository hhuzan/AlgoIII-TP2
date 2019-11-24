package algochess.gui.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Color;

import algochess.gui.Casillero;


public class AlgoChess extends Application  {
    private static final int TAMANIO_CASILLERO = 25;
    private static final int COLUMNAS = 20;
    private static final int FILAS = 20;

    public static void main(String[] args) {
        launch(args);
    }

    /*private BorderPane crearVentanaPrincipal(){
        BorderPane panel = new BorderPane();
        panel.setTop(new Label("Top"));
        panel.setBottom(new Label("Bottom"));
        panel.setLeft(new Label("Left"));
        panel.setRight(new Label("Right"));
        panel.setCenter(new Label("Center"));
        return panel;
    }*/

    private GridPane crearVentaDeEntidades(){

        GridPane ventas = new GridPane();
        ventas.setPadding(new Insets(10,10,10,10));
        ventas.setVgap(20);
        ventas.setHgap(20);

        Rectangle soldadoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle caballoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle curanderoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle catapultaContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);

        Image soldadoNeutroImg = new Image("images/SoldadoNeutro.png");
        Image caballoNeutroImg = new Image("images/CaballoNeutro.png");
        Image curanderoNeutroImg = new Image("images/CuranderoNeutro.png");
        Image catapultaNeutroImg = new Image("images/CatapultaNeutro.png");

        soldadoContainer.setFill(new ImagePattern(soldadoNeutroImg));
        caballoContainer.setFill(new ImagePattern(caballoNeutroImg));
        curanderoContainer.setFill(new ImagePattern(curanderoNeutroImg));
        catapultaContainer.setFill(new ImagePattern(catapultaNeutroImg));

        GridPane.setConstraints(soldadoContainer,0,0);
        GridPane.setConstraints(caballoContainer,0,1);
        GridPane.setConstraints(curanderoContainer,0,2);
        GridPane.setConstraints(catapultaContainer,0,3);

        ventas.getChildren().addAll(soldadoContainer,caballoContainer,curanderoContainer,catapultaContainer);

        return ventas;
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoChess - V 1.0");

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        escenaBienvenidos.setFill(Color.BLACK);

        stage.setScene(escenaBienvenidos);

        stage.show();
    }

}
