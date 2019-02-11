package tools.nfc;

import game.Deck;
import game.Game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Simulates badge scans
 */
public class MockNfcReader implements CardReader {

    private NfcCard fakeCard = null;
    private Game game = null;
    private Deck deck = null;

    public MockNfcReader() {

    }

    public MockNfcReader(Game game) {
        this.game = game;
    }

    public MockNfcReader(NfcCard nfcCard) {
        this.fakeCard = nfcCard;
    }

    public MockNfcReader(Deck deck) {
        this.deck = deck;
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
        else if (deck != null) {
            return deck.getRandomCardNotIn(new ArrayList<>()).getNfcCard();
        }
        return null;
    }

    public void setFakeCard(NfcCard fakeCard) {
        this.fakeCard = fakeCard;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
