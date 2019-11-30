package algochess.gui.vista;

import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import algochess.engine.facciones.Faccion;

public class VistaJinete implements VistaEntidad {

	public VistaJinete(VistaCasillero vistaCasillero, Faccion faccion) {
		Map<Faccion, String> faccionImage = Map.of(
			Faccion.ALIADOS, 	"images/CaballoPink.png",
			Faccion.ENEMIGOS, 	"images/CaballoBlue.png"
		);
		Image image;
		image = new Image("images/CaballoPink.png");
		int tamanio= vistaCasillero.getTamanio();
		Rectangle rectangulo = new Rectangle(tamanio, tamanio);
		rectangulo.setFill(new ImagePattern(image));
		vistaCasillero.getChildren().add(rectangulo);
	}

}
