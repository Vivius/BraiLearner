import javazoom.jl.player.Player;
import nfc.NfcReader;

import java.io.FileInputStream;

public class Launcher {

    public Launcher() {

    }

    public void start() {
        System.out.println("BraiLearner ready !");

        // NfcReader nfcReader = new NfcReader();
        // System.out.println(nfcReader.readCard());

        try {
            System.out.println(getClass().getResourceAsStream("commons/intro.mp3"));
            Player player = new Player(getClass().getResourceAsStream("commons/intro.mp3"));
            player.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
