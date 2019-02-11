package game;

import game.contracts.Listenable;
import tools.AudioPlayer;
import tools.nfc.NfcReader;

public class Game implements Listenable {

    public void play(final Deck deck, final NfcReader nfcReader) {
        System.out.println("Game started with default deck");
        listen();

        deck.listen();

        int nb = 1;
        boolean cardFound = false;

        do {
            final GameCard cardToFind = deck.getRandomCard();
            System.out.println("Word to find : " + cardToFind.getName());

            listenFindCard();
            cardToFind.listen();

            do {
                System.out.println("Scan card when ready...");

                final GameCard userCard = deck.findCardFromNfc(nfcReader.readCard());

                cardFound = cardToFind.equals(userCard);

                if (cardFound) {
                    System.out.println("Correct word :)");
                    listenCorrectWord();
                }
                else {
                    System.out.println("Incorrect word " + cardToFind.getName() + " /= " + userCard.getName());
                    listenIncorrectWord();
                }

            } while(!cardFound);

            nb--;

        } while(nb > 0);

        System.out.println("Game finished");
    }

    @Override
    public void listen() {
        AudioPlayer.playSound("commons/intro.mp3");
        AudioPlayer.playSound("commons/consigne.mp3");
    }

    private void listenFindCard() {
        AudioPlayer.playSound("commons/find_card.mp3");
    }

    private void listenCorrectWord() {
        AudioPlayer.playSound("advises/correct_word.mp3");
    }

    private void listenIncorrectWord() {
        AudioPlayer.playSound("advises/incorrect_word.mp3");
    }
}