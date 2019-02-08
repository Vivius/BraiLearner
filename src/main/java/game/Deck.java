package game;

import model.NfcCard;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private NfcCard liste[] = new NfcCard[2];

    NfcCard carte1 = new NfcCard("","","lion","","","","","","04787D22665D80");
    NfcCard carte2 = new NfcCard("","","girafe","","","","","","04DC7D22665D80");

    public Deck(){
        liste[0]= carte1;
        liste[1]= carte2;
    }

    public NfcCard choixAleatoire(){
        Random rnd = new Random();
        int nombre = rnd.nextInt(2);
        NfcCard card = liste[nombre-1];
        return card;
    }

    /*
    public NfcCard[] deck(){

        return deck;
    }*/

}
