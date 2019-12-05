package algochess.gui.vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Musica {

    String mainTheme = "sounds/introSong.mp3";
    Media sound = new Media(getClass().getClassLoader().getResource(mainTheme).toString());

    String playTheme = "sounds/15_crytalscar_phase2_loop.wav";
    Media soundPlay = new Media(getClass().getClassLoader().getResource(playTheme).toString());

    String soundOnMouseEntered = "sounds/68_ui-generic_button_01.wav";
    Media soundPlayOnMouseEntered = new Media(getClass().getClassLoader().getResource(soundOnMouseEntered).toString());

    String endGameTheme = "sounds/endGameSong.mp3";
    Media soundFinale = new Media(getClass().getClassLoader().getResource(endGameTheme).toString());

    MediaPlayer mediaPlayerFinale = new MediaPlayer(soundFinale);

    MediaPlayer mediaPlayerOnButton = new MediaPlayer(soundPlayOnMouseEntered);

    MediaPlayer mediaPlayer2 = new MediaPlayer(soundPlay);

    MediaPlayer mediaPlayer = new MediaPlayer(sound);


    public Musica(){

        mediaPlayerFinale.setCycleCount(mediaPlayerFinale.INDEFINITE);
        mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
        mediaPlayer2.setCycleCount(mediaPlayer2.INDEFINITE);
        mediaPlayerOnButton.setCycleCount(mediaPlayerOnButton.INDEFINITE);

    }


    public void reproducirIntro(){

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

    }

    public void reproducirMusicaBatalla(){

        mediaPlayer2.setVolume(0.5);
        mediaPlayer2.play();


    }

    public void reproducirSonidoAlTocarBoton(){

        mediaPlayerOnButton.setVolume(0.5);
        mediaPlayerOnButton.play();

    }

    public void reproducirSonidoAlFinalizarPartida(){

        mediaPlayerFinale.setVolume(0.5);
        mediaPlayerFinale.setStartTime(new Duration(2500));
        mediaPlayerFinale.play();

    }


    public void pararIntro() {

        mediaPlayer.stop();

    }

    public void pausarIntro() {

        mediaPlayer.pause();

    }

    public void pararSonidoBoton() {

        mediaPlayerOnButton.stop();

    }

    public void pararMusicaBatalla() {

        mediaPlayer2.stop();

    }
}
