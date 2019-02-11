import game.Game;
import tools.nfc.CardReader;
import tools.nfc.NfcReader;

public class Launcher {

    private void start() {
        System.out.println("BraiLearner ready !");

        final CardReader cardReader = new NfcReader();
        final Game game = new Game(cardReader);

        game.play(game.getDefaultDeck());
    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
