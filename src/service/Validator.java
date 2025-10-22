package service;

import java.io.File;
import java.util.Scanner;

public class Validator {

    public boolean isValidFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public int getValidIntegerInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
    }

    public int getValidMenuChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Некорректный выбор. Пожалуйста, выберите число от 0 до 3.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, выберите число от 0 до 3.");
                scanner.next();
            }
        }
    }
}

