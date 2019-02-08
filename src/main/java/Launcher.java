import javazoom.jl.player.Player;
import nfc.NfcReader;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.InputStream;
import java.io.Reader;

public class Launcher {

    public Launcher() {

    }

    public void start() {
        System.out.println("BraiLearner ready !");

        // NfcReader nfcReader = new NfcReader();
        // System.out.println(nfcReader.readCard());

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("commons/music.wav"));

            Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

           /* InputStream audio = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("commons/music.wav");

            Player player = new Player(audio);
            player.play();*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(() -> new Launcher().start());
        thread.start();

        JFrame frame = new JFrame("BraiLearner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
