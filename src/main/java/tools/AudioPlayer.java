package tools;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.InputStream;

public class AudioPlayer {

    public static void playSound(String filename) {

        final InputStream file = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filename);

        Player player = null;
        try {
            player = new Player(file);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
