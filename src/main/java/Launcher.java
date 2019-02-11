import game.Deck;
import game.Game;
import tools.nfc.NfcReader;

public class Launcher {

    private void start() {
        System.out.println("BraiLearner ready !");

        final Game game = new Game();
        final NfcReader nfcReader = new NfcReader();
        final Deck deck = new Deck();

        game.play(deck, nfcReader);
    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
