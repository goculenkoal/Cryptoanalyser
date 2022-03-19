package ru.javarush.cryptoanalyser.cryptography;

import static ru.javarush.cryptoanalyser.globalconst.Alphabet.*;
import static ru.javarush.cryptoanalyser.globalconst.Alphabet.ALPHABET_STRING;

public class Logic {

    public static String encryptStringAlphabet(char[] inputText, int shift) {
        String stringAlfabet = new String(inputText);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringAlfabet.length(); i++) {
            char currentSymbol = stringAlfabet.charAt(i);
            if (ALPHABET_STRING.indexOf(currentSymbol) != -1) { // проверяем наличие символа в Алфавите строк
                int currentIndex = ALPHABET_STRING.indexOf(currentSymbol); // получаем индекс
                int newEncryptIndex = (currentIndex + shift + LENGTH_OF_ALPHABET) % LENGTH_OF_ALPHABET;
                char encryptSymbol = ALPHABET_STRING.charAt(newEncryptIndex); // получение символа после смещения
                result.append(encryptSymbol);
            } else {
                result.append(currentSymbol);
            }
        }
        return result.toString();
    }

    public static String decryptStringAlphabet(char[] inputText, int shift) {
        String stringAlfabet = new String(inputText);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringAlfabet.length(); i++) {
            char currentSymbol = stringAlfabet.charAt(i);
            if (ALPHABET_STRING.indexOf(currentSymbol) != -1) {
                int currentIndex = ALPHABET_STRING.indexOf(currentSymbol);
                int newEncryptIndex = (currentIndex - shift + LENGTH_OF_ALPHABET) % LENGTH_OF_ALPHABET;
                char encryptSymbol = ALPHABET_STRING.charAt(newEncryptIndex);
                result.append(encryptSymbol);
            } else {
                result.append(currentSymbol);
            }
        }
        return result.toString();
    }
}
