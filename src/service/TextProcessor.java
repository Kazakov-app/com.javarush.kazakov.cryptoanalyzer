package service;

public class TextProcessor {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя .,”’:-!?";

    public static String shiftText(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            result.append(shiftCharacter(ch, key));
        }
        return result.toString();
    }

    private static char shiftCharacter(char ch, int key) {
        int index = ALPHABET.indexOf(ch);
        if (index == -1) return ch;

        int newIndex = (index + key + ALPHABET.length()) % ALPHABET.length();
        return ALPHABET.charAt(newIndex);
    }

    public static int getAlphabetSize() {
        return ALPHABET.length();
    }
}

