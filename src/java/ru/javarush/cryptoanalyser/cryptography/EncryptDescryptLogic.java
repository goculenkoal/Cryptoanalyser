package ru.javarush.cryptoanalyser.cryptography;

import java.util.ArrayList;
import java.util.List;
import static ru.javarush.cryptoanalyser.globalconst.Alphabet.*;
import static ru.javarush.cryptoanalyser.globalconst.Alphabet.ALPHABET_STRING;

public class EncryptDescryptLogic {

    public static String encryptStringAlphabet(char[] inputText, int shift) {
        String stringAlfabet = new String(inputText);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringAlfabet.length(); i++) {
            char currentSymbol = stringAlfabet.charAt(i);
            if (checkCurrentSymbolInAlphabet(currentSymbol)) {
                int currentIndex = ALPHABET_STRING.indexOf(currentSymbol);
                int newEncryptIndex = (currentIndex + shift + LENGTH_OF_ALPHABET) % LENGTH_OF_ALPHABET;
                char encryptSymbol = ALPHABET_STRING.charAt(newEncryptIndex);
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
            if (checkCurrentSymbolInAlphabet(currentSymbol)) {
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

    public static List<String> bruetforce(char[] text) {
        List<String> list = new ArrayList<>();
        int shiftLength = LENGTH_OF_ALPHABET;
        int shift = 0;
        while (shiftLength != 0) {
            list.add(encryptStringAlphabet(text, shift));
            shiftLength--;
            shift++;
        }
        return list;
    }

    public static boolean checkCurrentSymbolInAlphabet(char currentSymbol) {
        return ALPHABET_STRING.indexOf(currentSymbol) != -1;

    }
}
