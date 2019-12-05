package algochess.gui.controller;

import algochess.gui.vista.Musica;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class MusicaOverButtonHandler implements EventHandler<MouseEvent> {


     Musica mediaPlayer;


    public MusicaOverButtonHandler(Musica mediaPlayer){
        this.mediaPlayer = mediaPlayer;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {


    mediaPlayer.reproducirSonidoAlTocarBoton();


    }
}
