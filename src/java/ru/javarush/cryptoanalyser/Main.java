package ru.javarush.cryptoanalyser;

import ru.javarush.cryptoanalyser.cryptography.FileInput;

import static ru.javarush.cryptoanalyser.cryptography.Logic.dencryptedCharAlfabet;
import static ru.javarush.cryptoanalyser.cryptography.Logic.encryptedCharAlfabet;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting a new project");

        char[] text = "доброе утро мир!".toCharArray();

        System.out.println(encryptedCharAlfabet(text,3));
        FileInput input = new FileInput();
        System.out.println(encryptedCharAlfabet(FileInput.FileInput().toCharArray(), 3));
        System.out.println(dencryptedCharAlfabet(FileInput.FileInput().toCharArray(),3));

    }
}
