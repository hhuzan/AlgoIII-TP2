package algochess.gui.controller;

import algochess.gui.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;


public class BotonPlayMusicaHandler implements EventHandler<ActionEvent> {

    Musica musicPlayer;


    public BotonPlayMusicaHandler(Musica musicPlayer){


      this.musicPlayer = musicPlayer;

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        musicPlayer.reproducirIntro();

    }
}
