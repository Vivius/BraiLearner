import nfc.NfcReader;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("BraiLearner ready !");

        NfcReader nfcReader = new NfcReader();

        System.out.println(nfcReader.readCard());

    }
}
