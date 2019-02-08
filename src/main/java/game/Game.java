package game;

import model.NfcCard;
import nfc.NfcReader;

public class Game {

    private boolean check(String valeur, String carte) {
        return valeur.equals(carte);
    }

    public void game(){
        System.out.println("Bonjour vous allez commencez le jeu");
        int nb = 1;
        NfcCard card;
        boolean trouve = false;
        do{
            String valeur = "Groupe 5";
            System.out.println("Le mot chercher est 'Groupe 5'");

            do {
                System.out.println("Présentez carte");
                NfcReader nfcReader = new NfcReader();
                card = nfcReader.readCard();
                trouve = check(valeur, card.getTitle());
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