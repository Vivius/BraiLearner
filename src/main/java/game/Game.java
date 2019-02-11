package game;

import model.NfcCard;
import tools.NfcReader;

public class Game {

    private boolean check(String valeur, String carte) {
        return valeur.equals(carte);
    }

    public void game(){
        Deck deck = new Deck();
        System.out.println("Bonjour vous allez commencez le jeu");
        int nb = 1;
        NfcCard card;
        boolean trouve = false;
        do{
            NfcCard mot = deck.choixAleatoire();
            System.out.println("Le mot chercher est " + mot.getTitle());

            do {
                System.out.println("Présentez carte");
                NfcReader nfcReader = new NfcReader();
                card = nfcReader.readCard();
                trouve = check(mot.getTitle(), card.getTitle());
                if (trouve)
                    System.out.println("Vous avez trouvé le bon mot");
                else
                    System.out.println("Faux ceci est le mot "+card.getTitle());

            }while(! trouve);

            nb--;
        } while(nb>0);
        System.out.println("Jeu finis");
    }

}