package game;

import game.contracts.Listenable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tools.AudioPlayer;
import tools.nfc.CardReader;
import tools.nfc.NfcCard;

import java.util.ArrayList;
import java.util.List;

public class Game implements Listenable {

    private Deck defaultDeck;
    private List<Deck> decks;

    private List<NfcCard> nfcCards = new ArrayList<>();

    private CardReader cardReader;

    public Game(final CardReader cardReader) {

        this.cardReader = cardReader;

        // physical badges
        final NfcCard nfcCardLion = new NfcCard("04787D22665D80", "Lion");
        final NfcCard nfcCardGirafe = new NfcCard("04DC7D22665D80", "Girafe");

        nfcCards.add(nfcCardLion);
        nfcCards.add(nfcCardGirafe);

        // virtual badges
        final GameCard gameCardLion = new GameCard("Lion", "decks/default/cards/lion.mp3", nfcCardLion);
        final GameCard gameCardGirafe = new GameCard("Girafe", "decks/default/cards/girafe.mp3", nfcCardGirafe);

        final List<GameCard> defaultDeckCards = new ArrayList<>();
        defaultDeckCards.add(gameCardLion);
        defaultDeckCards.add(gameCardGirafe);

        defaultDeck = new Deck("Default deck", defaultDeckCards);
        decks = new ArrayList<>();
    }

    public void deckSelection() {
        throw new NotImplementedException();
    }

    public void play(final Deck deck) {
        System.out.println("Game started");
        final List<GameCard> playedCards = new ArrayList<>();
        listen();

        System.out.println("Deck " + deck.getName() + " used");
        deck.listen();

        int nbRemainingCards = deck.getNumberOfCards();
        int nbErrors = 0;
        boolean cardFound;

        do {
            final GameCard cardToFind = deck.getRandomCardNotIn(playedCards);
            cardFound = false;

            System.out.println("Word to find : " + cardToFind.getName());
            listenFindCard();
            cardToFind.listen();

            do {
                System.out.println("Scan card when ready...");

                final GameCard userCard = deck.findCardFromNfc(cardReader.readCard());

                // TODO : manage null result
                if (userCard != null) {

                    cardFound = cardToFind.equals(userCard);

                    if (cardFound) {
                        System.out.println("Correct word :)");
                        playedCards.add(cardToFind);
                        listenCorrectWord();
                    }
                    else {
                        nbErrors++;

                        if(nbErrors == 2) {
                            listenAdviseUppercase();
                        }
                        else if (nbErrors % 3 == 0 && nbErrors / 3 < cardToFind.getName().length()) {
                            listenAdviseLetter(cardToFind.getName().toLowerCase().charAt(nbErrors / 3));
                        }

                        System.out.println("Incorrect word " + userCard.getName() + " /= " + cardToFind.getName());
                        listenIncorrectWord();
                    }
                }
                else {
                    System.out.println("Card not present in this deck");
                    listenCardNotInDeck();
                }

            } while(!cardFound);

            nbRemainingCards--;

        } while(nbRemainingCards > 0);

        System.out.println("Game finished");
    }

    public Deck getDefaultDeck() {
        return defaultDeck;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public List<NfcCard> getNfcCards() {
        return nfcCards;
    }

    @Override
    public void listen() {
        AudioPlayer.play("commons/intro.mp3");
        AudioPlayer.play("commons/consigne.mp3");
    }

    private void listenFindCard() {
        AudioPlayer.play("commons/find_card.mp3");
    }

    private void listenCorrectWord() {
        AudioPlayer.play("advises/correct_word.mp3");
    }

    private void listenIncorrectWord() {
        AudioPlayer.play("advises/incorrect_word.mp3");
    }

    private void listenCardNotInDeck() {
        AudioPlayer.play("errors/card_not_in_deck.mp3");
    }

    private void listenAdviseUppercase() {
        AudioPlayer.play("advises/uppercase.mp3");
    }

    private void listenAdviseLetter(char letter) {
        AudioPlayer.play("advises/letters/" + letter + ".mp3");
    }
}