package tools;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.InputStream;

public class AudioPlayer {

    public static void play(String filename) {

        final InputStream file = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filename);

        Player player;

        try {
            if (file != null) {
                player = new Player(file);
            }
            else {
                final InputStream error = Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream("errors/file_missing.mp3");
                player = new Player(error);
            }

            player.play();

        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
