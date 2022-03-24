package ru.javarush.cryptoanalyser.consoleui;
import ru.javarush.cryptoanalyser.iologic.FileService;


import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static ru.javarush.cryptoanalyser.cryptography.EncryptDescryptLogic.*;

public class StartUI {
    public void start() {
        System.out.println("Starting......");
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
                    String result = encryptStringAlphabet((FileService.readInfoFromFile(scanner)), selectShiftStep);
                    FileService.writeInfoListToFile(Collections.singletonList(result), scanner);
                    System.out.println("ready");

                } else if (selectMenuAction == 2) {
                    System.out.println("====== You choose Decrypt method =====");
                    System.out.print("Select shift step: ");
                    int selectShiftStep = Integer.parseInt(scanner.nextLine());
                    String result = (decryptStringAlphabet(FileService.readInfoFromFile(scanner), selectShiftStep));
                    FileService.writeInfoListToFile(Collections.singletonList(result), scanner);
                    System.out.println("ready");

                } else if (selectMenuAction == 3) {
                    System.out.println("====== You choose Decrypt by Brute force =====");
                    List<String> result = bruetforce((FileService.readInfoFromFile(scanner)));
                    FileService.writeInfoListToFile(result,scanner);
                    System.out.println("ready");

                } else if (selectMenuAction != 5) {
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
        for (int i = 1; i <= menu.length; i++) {
            System.out.println(i + "." + menu[i-1]);
        }
    }
}
