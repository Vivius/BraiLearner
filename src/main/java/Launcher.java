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

        try {
            InputStream audio = Thread.currentThread().getContextClassLoader().getResourceAsStream("commons/sample.mp3");
            System.out.println(audio);

            Player player = new Player(audio);
            player.play();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
