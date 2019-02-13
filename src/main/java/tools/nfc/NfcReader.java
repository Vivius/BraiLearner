package tools.nfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Manages the tools reader data
 */
public class NfcReader implements CardReader {

    private static String NFC_SOFTWARE_NAME = "explorenfc-basic";

    /**
     * Generates a String given by the Nfc card software when the card touch the reader
     * This is is a thread blocking method
     *
     * @return StringBuilder
     */
    private StringBuilder waitForNfcData() {

        Process exploreNfcProcess = null;
        try {
            exploreNfcProcess = Runtime.getRuntime().exec(NFC_SOFTWARE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (exploreNfcProcess != null) {

            final StringBuilder output = new StringBuilder();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(exploreNfcProcess.getInputStream()));

            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                int exitVal = exploreNfcProcess.waitFor();
                if (exitVal == 0) {
                    return output;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Wait until an NFC card is read by the device
     *
     * @return NfcCard
     */
    @Override
    public NfcCard readCard() {
        final StringBuilder reader = waitForNfcData();
        final String data = reader.toString();

        // return null if error during nfc reading
        if (data.contains("Abandon") || data.contains("corrupted")) {
            return null;
        }

        final Scanner scanner = new Scanner(data);
        final NfcCard card = new NfcCard();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains(":")) {
                String[] vars = line.split(":");
                // remove spaces
                vars[0] = vars[0].trim();
                vars[1] = vars[1].trim();

                if (vars.length == 2) {
                    if (vars[0].equals("Record type")) {
                        card.setRecordType(vars[1]);
                    }
                    else if (vars[0].equals("URI")) {
                        card.setUri(vars[1]);
                    }
                    else if (vars[0].equals("Title")) {
                        card.setTitle(vars[1]);
                    }
                    else if (vars[0].equals("Action")) {
                        card.setAction(vars[1]);
                    }
                    else if (vars[0].equals("Language")) {
                        card.setLanguage(vars[1]);
                    }
                    else if (vars[0].equals("Encoding")) {
                        card.setEncoding(vars[1]);
                    }
                    else if (vars[0].equals("ISO14443A ATQA")) {
                        card.setATQA(vars[1]);
                    }
                    else if (vars[0].equals("ISO14443A SAK")) {
                        card.setSAK(vars[1]);
                    }
                    else if (vars[0].equals("ISO14443A UID")) {
                        card.setUID(vars[1]);
                    }
                }
            }
         }

        return card;
    }
}
