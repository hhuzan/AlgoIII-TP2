package algochess.gui.controller;

import algochess.gui.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;


public class BotonStopMusicaHandler implements EventHandler<ActionEvent> {

    Musica musicPlayer;


    public BotonStopMusicaHandler(Musica musicPlayer){

        this.musicPlayer = musicPlayer;

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        musicPlayer.pararIntro();


    }
}