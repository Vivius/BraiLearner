import javazoom.jl.player.Player;
import nfc.NfcReader;

import javax.swing.*;
import java.awt.*;
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

        Runnable main = () -> {
            new Launcher().start();
        };

        Thread thread = new Thread(main);
        thread.start();

        //1. Create the frame.
        JFrame frame = new JFrame("BraiLearner");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);

        // new Launcher().start();
    }
}
