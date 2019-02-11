package game;

import game.contracts.Listenable;
import tools.AudioPlayer;
import tools.nfc.NfcCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck implements Listenable {

    private String name;
    private List<GameCard> cards = new ArrayList<>();

    public Deck() {
        initDefaultDeck();
    }

    private void initDefaultDeck() {
        this.name = "default";

        final NfcCard nfcCardLion = new NfcCard("04787D22665D80", "Lion");
        final NfcCard nfcCardGirafe = new NfcCard("04DC7D22665D80", "Girafe");

        final GameCard gameCardLion = new GameCard("Lion", "decks/default/cards/lion.mp3", nfcCardLion);
        final GameCard gameCardGirafe = new GameCard("Girafe", "decks/default/cards/girafe.mp3", nfcCardGirafe);

        cards.add(gameCardLion);
        cards.add(gameCardGirafe);
    }

    public GameCard getRandomCard() {
        final Random rnd = new Random();
        int randomIndex = rnd.nextInt(cards.size());
        return cards.get(randomIndex);
    }

    public int getSize(){
        return cards.size();
    }

    public void removeCard(GameCard card){
        cards.remove(card);
    }

    public GameCard findCardFromNfc(final NfcCard nfcCard) {
        List<GameCard> result = cards.stream()
                .filter(card -> card.getNfcCard().equals(nfcCard))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public void listen() {
        AudioPlayer.playSound("decks/default/intro.mp3");
    }

    @Override
    public String toString() {
        return "Deck{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
