package game;

import game.contracts.Listenable;
import tools.AudioPlayer;
import tools.nfc.NfcCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck implements Listenable {

    private String name = "default";
    private List<GameCard> cards = new ArrayList<>();

    public Deck() {
        final NfcCard nfcCard_1 = new NfcCard("04DC7D22665D80");
        final GameCard gameCard_1 = new GameCard("Lion", "decks/default/cards/lion.mp3", nfcCard_1);

        final NfcCard nfcCard_2 = new NfcCard("04DC7D22665D80", "Girafe");
        final GameCard gameCard_2 = new GameCard("Girafe", "decks/default/cards/girafe.mp3", nfcCard_2);

        cards.add(gameCard_1);
        cards.add(gameCard_2);
    }

    public GameCard getRandomCard() {
        final Random rnd = new Random();
        int randomIndex = rnd.nextInt(cards.size());
        return cards.get(randomIndex);
    }

    @Override
    public void listen() {
        AudioPlayer.playSound("decks/default/intro.mp3");
    }
}
