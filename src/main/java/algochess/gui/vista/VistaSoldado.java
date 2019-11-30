package algochess.gui.vista;

import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import algochess.engine.facciones.Faccion;

public class VistaSoldado implements VistaEntidad {

	public VistaSoldado(VistaCasillero vistaCasillero, Faccion faccion) {
		Map<Faccion, String> faccionImage = Map.of(
			Faccion.ALIADOS, 	"images/SoldadoPink.png",
			Faccion.ENEMIGOS, 	"images/SoldadoBlue.png"
		);
		Image image;
		image = new Image(faccionImage.get(faccion));
		int tamanio= vistaCasillero.getTamanio();
		Rectangle rectangulo = new Rectangle(tamanio, tamanio);
		rectangulo.setFill(new ImagePattern(image));
		vistaCasillero.getChildren().add(rectangulo);
	}

}
