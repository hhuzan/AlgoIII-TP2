package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;


public class BotonPlayMusicaHandler implements EventHandler<ActionEvent> {

    MediaPlayer musicPlayer;


    public BotonPlayMusicaHandler(MediaPlayer musicPlayer){


      this.musicPlayer = musicPlayer;

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        musicPlayer.play();

    }
}
