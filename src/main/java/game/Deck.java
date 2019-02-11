package game;

import game.contracts.Listenable;
import tools.AudioPlayer;
import tools.nfc.NfcCard;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck implements Listenable {

    private String name;
    private List<GameCard> cards;

    public Deck(final String name, final List<GameCard> cards) {
        this.name = name;
        this.cards = cards;
    }

    /**
     * Gets a random card not in the given list of cards
     *
     * @param playedCards List of cards
     * @return A card from this deck
     */
    public GameCard getRandomCardNotIn(final List<GameCard> playedCards) {
        final Random randomGenerator = new Random();

        final List<GameCard> result = cards.stream()
                .filter(card -> !playedCards.contains(card))
                .collect(Collectors.toList());

        int randomIndex = randomGenerator.nextInt(result.size());
        return result.get(randomIndex);
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    /**
     * Returns a card of the deck depending on its physical bind badge
     *
     * @param nfcCard A card given by the nfc reader
     * @return The corresponding game card
     */
    public GameCard findCardFromNfc(final NfcCard nfcCard) {
        List<GameCard> result = cards.stream()
                .filter(card -> card.getNfcCard().equals(nfcCard))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public void listen() {
        AudioPlayer.play("decks/default/intro.mp3");
    }

    @Override
    public String toString() {
        return "Deck{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
