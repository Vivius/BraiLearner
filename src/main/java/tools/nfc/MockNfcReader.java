package tools.nfc;

import game.Game;

import java.util.Random;

/**
 * Simulates badge scans
 */
public class MockNfcReader implements CardReader {

    private NfcCard fakeCard;
    private Game game;

    public MockNfcReader() {
        this.game = null;
        this.fakeCard = null;
    }

    public MockNfcReader(Game game) {
        this.game = game;
        this.fakeCard = null;
    }

    public MockNfcReader(NfcCard nfcCard) {
        this.game = null;
        this.fakeCard = nfcCard;
    }

    @Override
    public NfcCard readCard() {
        if (fakeCard != null) {
            return fakeCard;
        }
        else if (game != null) {
            final Random random = new Random();
            int randNumber = random.nextInt(game.getNfcCards().size());
            return game.getNfcCards().get(randNumber);
        }
        return null;
    }

    public void setFakeCard(NfcCard fakeCard) {
        this.fakeCard = fakeCard;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
