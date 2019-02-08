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
            System.out.println(ClassLoader.getSystemResource("commons/intro.mp3").getFile());
            Player player = new Player(new FileInputStream(ClassLoader.getSystemResource("commons/intro.mp3").getFile()));
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
