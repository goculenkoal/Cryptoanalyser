package ru.javarush.cryptoanalyser.consoleui;
import ru.javarush.cryptoanalyser.iologic.FileInput;
import ru.javarush.cryptoanalyser.iologic.FileOutput;
import java.util.Scanner;
import static ru.javarush.cryptoanalyser.cryptography.Logic.*;

public class StartUI {
    public void start() {
        System.out.println("This is utility of cryptoanalyser using Caesar cipher algorythm");
    }

    public void init(Scanner scanner) {
        start();
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int selectMenuAction = Integer.parseInt(scanner.nextLine());
                if (selectMenuAction == 1) {
                    System.out.println("====== You choose Encrypt method =====");
                    System.out.print("Select shift step: ");
                    int selectShiftStep = Integer.parseInt(scanner.nextLine());
                    String result = encryptStringAlphabet((FileInput.readInfoFromFile(scanner)), selectShiftStep);
                    FileOutput.writeInfoToFile(result, scanner);
                    System.out.println("ready");

                } else if (selectMenuAction == 2) {
                    System.out.println("====== You choose Decrypt method =====");
                    System.out.print("Select shift step: ");
                    int selectShiftStep = Integer.parseInt(scanner.nextLine());
                    String result = (decryptStringAlphabet(FileInput.readInfoFromFile(scanner), selectShiftStep));
                    FileOutput.writeInfoToFile(result, scanner);
                    System.out.println("ready");

                }
                else if (selectMenuAction != 5) {
                    System.out.println("====== You choose Exit =====");
                    System.out.println("====== Bye =====");
                    System.out.println("User choose: " + selectMenuAction);
                } else {
                    run = false;
                }
        }
    }


    private void showMenu() {
        String[] menu = {"Encrypt text", "Descrypt text", "Descrypt text using Brute force", "Descrypt text using statistical analysis", "Exit"};
        System.out.println("Menu: ");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + 1 + "." + menu[i]);
        }
    }
}

