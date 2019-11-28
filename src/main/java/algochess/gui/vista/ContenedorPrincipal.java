package algochess.gui.vista;

//import java.util.Observer;
//import java.util.Observable;
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
import algochess.engine.tablero.Tablero;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.NulaEntidad;
import java.lang.reflect.Field;

//public class ContenedorPrincipal extends HBox implements Observer {
public class ContenedorPrincipal extends HBox {

	Stage stage;
	int aceptados = 0;
	Juego juego;
	VBox columnaUno;
	VBox columnaDos;
	
	public ContenedorPrincipal(Stage stage, Juego juego) {
		super();

		String[] imagePaths = new String[] { "images/SHOP_ICON.png", "images/CaballoNeutro.png",
				"images/SoldadoNeutro.png", "images/CuranderoNeutro.png", "images/CatapultaNeutro.png" };

		this.stage = stage;
		this.juego = juego;
		setAlignment(Pos.CENTER);
		setSpacing(50);

		columnaUno = new VBox(20);
		columnaDos = new VBox(20);
		VistaTablero tableroVista = new VistaTablero(juego, this);

		columnaUno.setAlignment(Pos.CENTER_LEFT);

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

		// TODO: Handlers para los casilleros con toggle selected + entidad

		columnaDos.setAlignment(Pos.CENTER_RIGHT);

		columnaDos.getChildren().addAll(new Button("Hola"), new Button("Chau"));

		this.getChildren().addAll(columnaUno, tableroVista.getPaneTablero(), columnaDos);
	}

	public void refrescar() {
		this.getChildren().clear();
		VistaTablero tableroVista = new VistaTablero(juego, this);
		this.getChildren().addAll(columnaUno, tableroVista.getPaneTablero(), columnaDos);
	}

}