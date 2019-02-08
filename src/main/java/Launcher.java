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
            Player player = new Player(new FileInputStream("commons/intro.mp3"));
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
