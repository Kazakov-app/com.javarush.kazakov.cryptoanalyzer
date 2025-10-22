package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static service.TextProcessor.getAlphabetSize;

public class BruteForceDecypher {

    public void decryptByBruteForce(String inputFile, String outputFile) {
        try (BufferedReader reader = FileUtil.openReader(inputFile);
             BufferedWriter writer = FileUtil.openWriter(outputFile)) {

            String encryptedText = reader.readLine();

            for (int key = 1; key <= getAlphabetSize(); key++) {
                String decryptedText = TextProcessor.shiftText(encryptedText, -key);
                writer.write("Ключ " + key + ":\n" + decryptedText + "\n");
                writer.newLine();
            }
            System.out.println("Результаты brute force сохранены в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}

