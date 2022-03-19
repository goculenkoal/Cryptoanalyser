package ru.javarush.cryptoanalyser;

import ru.javarush.cryptoanalyser.consoleui.StartUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting a new project");
        new StartUI().init(scanner);
    }
}



