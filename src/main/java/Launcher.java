import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import nfc.NfcReader;

import java.io.InputStream;

public class Launcher {

    public Launcher() {

    }

    public void start() {
        System.out.println("BraiLearner ready !");

        // NfcReader nfcReader = new NfcReader();
        // System.out.println(nfcReader.readCard());

         final InputStream audio = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("commons/sample.mp3");

        Player player = null;
        try {
            player = new Player(audio);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
