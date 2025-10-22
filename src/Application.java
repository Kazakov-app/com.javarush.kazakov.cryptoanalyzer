import service.BruteForceDecypher;
import service.Cypher;
import service.Decypher;
import service.Validator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        int choice;

        do {
            System.out.println("Выберите режим работы:");
            System.out.println("1. Шифрование текста");
            System.out.println("2. Расшифровка текста с помощью ключа");
            System.out.println("3. Расшифровка текста с помощью brute force");
            System.out.println("0. Выход");

            choice = validator.getValidMenuChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Введите путь к файлу с текстом:");
                    String inputFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи зашифрованного текста:");
                    String outputFile = scanner.next();
                    System.out.println("Введите ключ шифрования (число):");
                    int key = scanner.nextInt();

                    Cypher cypher = new Cypher();
                    cypher.encrypt(inputFile, outputFile, key);
                    break;

                case 2:
                    System.out.println("Введите путь к файлу с зашифрованным текстом:");
                    String encryptedFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи расшифрованного текста:");
                    String decryptedOutputFile = scanner.next();
                    System.out.println("Введите ключ расшифровки (число):");
                    int decryptKey = scanner.nextInt();

                    Decypher decypher = new Decypher();
                    decypher.decrypt(encryptedFile, decryptedOutputFile, decryptKey);
                    break;

                case 3:
                    System.out.println("Введите путь к файлу с зашифрованным текстом:");
                    String bruteFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи результатов brute force:");
                    String bruteOutputFile = scanner.next();

                    BruteForceDecypher bruteForceDecypher = new BruteForceDecypher();
                    bruteForceDecypher.decryptByBruteForce(bruteFile, bruteOutputFile);
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    break;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        } while (choice != 0);
    }
}