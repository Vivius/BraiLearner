package game;

import game.contracts.Listenable;
import tools.AudioPlayer;
import tools.nfc.NfcCard;
import tools.nfc.NfcReader;

public class Game implements Listenable {

    public void play(Deck deck, NfcReader nfcReader) {
        System.out.println("Game started with default deck");
        listen();
        deck.listen();

        int nb = 1;
        NfcCard card;
        boolean found = false;

        do {
            final GameCard cardToFind = deck.getRandomCard();
            System.out.println("Word to find : " + cardToFind.getName());

            listenFindCard();
            cardToFind.listen();

            do {
                System.out.println("Scan card when ready...");

                card = nfcReader.readCard();
                found = cardToFind.getNfcCard().equals(card);

                if (found) {
                    System.out.println("Correct word :)");
                }
                else {
                    System.out.println("Incorrect word " + cardToFind.getName() + " /= " + card.getTitle());
                }

            } while(!found);

            nb--;

        } while(nb > 0);

        System.out.println("Game finished");
    }

    @Override
    public void listen() {
        AudioPlayer.playSound("commons/intro.mp3");
        AudioPlayer.playSound("commons/consigne.mp3");
    }

    public void listenFindCard() {
        AudioPlayer.playSound("commons/find_card.mp3");
    }
}