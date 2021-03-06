package game;

import game.contracts.Listenable;
import tools.AudioPlayer;
import tools.nfc.NfcCard;

/**
 * A card uses in the game and linked to a physical badge
 */
public class GameCard implements Listenable {

    private String name;
    private String audioFilePath;
    private NfcCard nfcCard;

    public GameCard(String name, String audioFilePath, NfcCard nfcCard) {
        this.name = name;
        this.audioFilePath = audioFilePath;
        this.nfcCard = nfcCard;
    }

    public String getName() {
        return name;
    }

    public NfcCard getNfcCard() {
        return nfcCard;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getNfcCard().equals(((GameCard) obj).getNfcCard());
    }

    @Override
    public String toString() {
        return "GameCard{" +
                "name='" + name + '\'' +
                ", audioFilePath='" + audioFilePath + '\'' +
                ", nfcCard=" + nfcCard +
                '}';
    }

    @Override
    public void listen() {
        AudioPlayer.play(audioFilePath);
    }
}
