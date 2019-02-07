import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import nfc.NfcReader;

import java.io.File;
import java.net.URI;

public class Launcher extends Application {

    public Launcher() {

    }

    public void start(Stage primaryStage) throws Exception {
        System.out.println("BraiLearner ready !");

        // NfcReader nfcReader = new NfcReader();
        // System.out.println(nfcReader.readCard());

        final File audioFile = new File(getClass().getResource("commons/intro.mp3").getFile());
        URI uri = audioFile.toURI();

        System.out.println(audioFile.getAbsolutePath());

        final Media media = new Media(uri.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> System.exit(0));

    }

    public static void main(String[] args) {
        Application.launch(Launcher.class);
    }
}
