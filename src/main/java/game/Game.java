package game;

import tools.nfc.NfcCard;
import tools.nfc.NfcReader;

public class Game {

    public void play(Deck deck, NfcReader nfcReader) {
        System.out.println("Bonjour vous allez commencez le jeu");
        deck.listen();

        int nb = 1;
        NfcCard card;
        boolean found = false;

        do {
            final GameCard cardToFind = deck.getRandomCard();
            System.out.println("Le mot chercher est " + cardToFind.getName());
            cardToFind.listen();

            do {
                System.out.println("Présentez carte");

                card = nfcReader.readCard();
                found = cardToFind.getNfcCard().equals(card);

                if (found) {
                    System.out.println("Vous avez trouvé le bon mot");
                }
                else {
                    System.out.println("Faux ceci est le mot "+card.getTitle());
                }

            } while(!found);

            nb--;

        } while(nb > 0);

        System.out.println("Jeu finis");
    }

}