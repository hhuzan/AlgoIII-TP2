package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;
import javafx.event.ActionEvent;
import algochess.gui.vista.VistaTablero;
import algochess.engine.juego.Juego;

public class ContenedorPrincipal extends HBox {

	Stage stage;
	int aceptados = 0;
	Juego juego;
	VBox columnaUno;
	VBox columnaDos;
	
	public ContenedorPrincipal(Stage stage, Juego juego) {
		super();

		this.stage = stage;
		this.juego = juego;
		setAlignment(Pos.CENTER);
		setSpacing(50);

		armarColumnaUno();
		columnaDos = new VBox(20);
		VistaTablero tableroVista = new VistaTablero(juego, this);



		columnaDos.setAlignment(Pos.CENTER_RIGHT);

		columnaDos.getChildren().addAll(new Button("Hola"), new Button("Chau"));

		this.getChildren().addAll(columnaUno, tableroVista.getPaneTablero(), columnaDos);
	}

	public void refrescar() {
		this.getChildren().clear();
		VistaTablero tableroVista = new VistaTablero(juego, this);
		this.getChildren().addAll(columnaUno, tableroVista.getPaneTablero(), columnaDos);
	}
	
	private void armarColumnaUno() {
		columnaUno = new VBox(20);
		columnaUno.setAlignment(Pos.CENTER_LEFT);

		String[] imagePaths = new String[] { "images/SHOP_ICON.png", "images/CaballoNeutro.png",
				"images/SoldadoNeutro.png", "images/CuranderoNeutro.png", "images/CatapultaNeutro.png" };

		for (String path : imagePaths) {
			Image image = new Image(path);
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setFitWidth(100);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
			ToggleButton toggleButton = new ToggleButton();
			toggleButton.setGraphic(imageView);
			toggleButton.setPadding(new Insets(-1, -1, -1, -1));
			toggleButton.setOnAction((ActionEvent e) -> {
				// TODO sacar if
				if (path == imagePaths[1]) { // jinete
					juego.seleccionarJinete();
				} else if (path == imagePaths[2]) { // soldado
					juego.seleccionarSodado();
				} else if (path == imagePaths[3]) { // curandero
					juego.seleccionarCurandero();
				} else if (path == imagePaths[4]) { // catapulta
					juego.seleccionarCatapulta();
				}

			});
			columnaUno.getChildren().add(toggleButton);
		}
		
	}

}