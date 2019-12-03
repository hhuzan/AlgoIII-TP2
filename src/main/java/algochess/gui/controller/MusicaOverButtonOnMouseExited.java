package algochess.gui.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class MusicaOverButtonOnMouseExited implements EventHandler<MouseEvent> {


    MediaPlayer mediaPlayer;


    public MusicaOverButtonOnMouseExited(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {


        mediaPlayer.stop();


    }

}
