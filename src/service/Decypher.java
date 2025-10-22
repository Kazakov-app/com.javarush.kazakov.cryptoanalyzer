package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Decypher {

    public void decrypt(String inputFile, String outputFile, int key) {
        processFile(inputFile, outputFile, -key);
    }

    private void processFile(String inputFile, String outputFile, int key) {
        try (BufferedReader reader = FileUtil.openReader(inputFile);
             BufferedWriter writer = FileUtil.openWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = TextProcessor.shiftText(line, key);
                writer.write(decryptedLine);
                writer.newLine();
            }
            System.out.println("Текст успешно расшифрован и сохранён в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}