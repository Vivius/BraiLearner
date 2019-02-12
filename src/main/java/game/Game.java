package game;

import game.contracts.Listenable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tools.AudioPlayer;
import tools.nfc.CardReader;
import tools.nfc.NfcCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Listenable {

    private Deck defaultDeck;
    private List<Deck> decks;

    private List<NfcCard> nfcCards = new ArrayList<>();

    private CardReader cardReader;

    public Game(final CardReader cardReader) {

        this.cardReader = cardReader;

        // physical badges
        final NfcCard nfcCardLion = new NfcCard("04977D22665D80", "Lion");
        final NfcCard nfcCardGirafe = new NfcCard("04FC7D22665D80", "Girafe");
        final NfcCard nfcCardElephant = new NfcCard("04B97D22665D80", "Eléphant");
        final NfcCard nfcCardSinge = new NfcCard("04DB7D22665D80", "Singe");
        final NfcCard nfcCardTigre = new NfcCard("04DC7D22665D80", "Tigre");

        nfcCards.add(nfcCardLion);
        nfcCards.add(nfcCardGirafe);
        nfcCards.add(nfcCardElephant);
        nfcCards.add(nfcCardSinge);
        nfcCards.add(nfcCardTigre);

        // virtual badges
        final GameCard gameCardLion = new GameCard("lion", "decks/default/cards/lion.mp3", nfcCardLion);
        final GameCard gameCardGirafe = new GameCard("girafe", "decks/default/cards/girafe.mp3", nfcCardGirafe);
        final GameCard gameCardElephant = new GameCard("éléphant", "decks/default/cards/elephant.mp3", nfcCardElephant);
        final GameCard gameCardSinge = new GameCard("singe", "decks/default/cards/singe.mp3", nfcCardSinge);
        final GameCard gameCardTigre = new GameCard("tigre", "decks/default/cards/tigre.mp3", nfcCardTigre);

        final List<GameCard> defaultDeckCards = new ArrayList<>();
        defaultDeckCards.add(gameCardLion);
        defaultDeckCards.add(gameCardGirafe);
        defaultDeckCards.add(gameCardElephant);
        defaultDeckCards.add(gameCardSinge);
        defaultDeckCards.add(gameCardTigre);

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
        int nbErrors = 0, nbTotalErrors = 0;
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

                if (userCard != null) {

                    if (playedCards.contains(userCard)) {
                        System.out.println("Card already played");
                        listenCardAlreadyPlayed();
                    }
                    else {
                        cardFound = cardToFind.equals(userCard);

                        if (cardFound) {
                            System.out.println("Correct word :)");
                            nbErrors = 0;
                            playedCards.add(cardToFind);
                            listenCorrectWord();
                        }
                        else {
                            nbErrors++;
                            nbTotalErrors++;

                            System.out.println("Incorrect word " + userCard.getName() + " /= " + cardToFind.getName());
                            listenIncorrectWord();

                            if(nbTotalErrors == 2) {
                                listenAdviseUppercase();
                            }
                            else if (nbErrors % 2 == 0 && nbErrors / 2 < cardToFind.getName().length()) {
                                listenAdviseLetter(cardToFind.getName().toLowerCase().charAt(nbErrors / 2 - 1));
                            }
                        }
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
        listenGameFinished();
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
        AudioPlayer.play("commons/alphabet.mp3");
    }

    private void listenFindCard() {
        AudioPlayer.play("commons/find_card.mp3");
    }

    private void listenCorrectWord() {
        AudioPlayer.play("advises/correct_word.mp3");
    }

    private void listenIncorrectWord() {
        final Random randomGenerator = new Random();
        AudioPlayer.play("advises/incorrect_word_" + (randomGenerator.nextInt(3) + 1) +".mp3");
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

    private void listenCardAlreadyPlayed() {
        AudioPlayer.play("errors/already_played_card.mp3");
    }

    private void listenGameFinished() {
        AudioPlayer.play("commons/congratulations.mp3");
    }
}