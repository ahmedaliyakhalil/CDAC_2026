package cdac;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decryption {

    private static final int KEY = 3;

    public void decrypt(String fileName) {

        try {
            FileReader reader = new FileReader(fileName);
            StringBuilder content = new StringBuilder();

            int ch;

            // Read complete file
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }

            reader.close();

            // Decrypt
            for (int i = 0; i < content.length(); i++) {
                content.setCharAt(i,
                        (char) (content.charAt(i) - KEY));
            }

            // Write back to same file
            FileWriter writer = new FileWriter(fileName);
            writer.write(content.toString());
            writer.close();

            System.out.println("File decrypted successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}