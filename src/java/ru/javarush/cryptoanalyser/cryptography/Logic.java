package ru.javarush.cryptoanalyser.cryptography;

import static ru.javarush.cryptoanalyser.Alphabet.ALPHABET_CHARS;
import static ru.javarush.cryptoanalyser.Alphabet.LENGTH_OF_ALPHABET;

public class Logic {

    public static char[] encryptedCharAlfabet(char[] text1,int shift){
        char[] encryptMessage = new char[text1.length];
        for (int i = 0; i < text1.length; i++) {
            for (int j = 0; j < ALPHABET_CHARS.length; j++) {
                if (text1[i] == ALPHABET_CHARS[j]) {
                    encryptMessage[i] = ALPHABET_CHARS[(j + shift + LENGTH_OF_ALPHABET)% LENGTH_OF_ALPHABET];
                }
            }
        }
        return encryptMessage;
    }

    public static char[] dencryptedCharAlfabet(char[] text1,int shift){
        char[] encryptMessage = new char[text1.length];
        for (int i = 0; i < text1.length; i++) {
            for (int j = 0; j < ALPHABET_CHARS.length; j++) {
                if (text1[i] == ALPHABET_CHARS[j]) {
                    encryptMessage[i] = ALPHABET_CHARS[(j - shift + LENGTH_OF_ALPHABET)% LENGTH_OF_ALPHABET];
                }
            }
        }
        return encryptMessage;
    }
}
