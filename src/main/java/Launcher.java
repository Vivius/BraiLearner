import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {

    private static String NFC_SOFT_NAME = "explorenfc-basic";

    public static void main(String[] args) {
        System.out.println("BraiLearner ready !");


        Process process= null;

        try {
            process = Runtime.getRuntime().exec(NFC_SOFT_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder output = new StringBuilder();


        if (process != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }
            } catch (IOException e) {}

            try {
                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.println("Success!");
                    System.out.println(output);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
