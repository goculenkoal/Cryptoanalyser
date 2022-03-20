package ru.javarush.cryptoanalyser.iologic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileOutput {

    public static void writeInfoToFile(String text, Scanner scanner) {
        System.out.print("Enter path to \"output_file.txt\": ");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanner.nextLine()))){
            bufferedWriter.write(text);
            bufferedWriter.flush();

        } catch(IOException ex){
            System.out.println("Output Failed");
        }
    }

    public static void writeInfoListToFile(List<String> text, Scanner scanner) {
        System.out.print("Enter path to \"output_file.txt\": ");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanner.nextLine()))){
            for (String value : text) {
                bufferedWriter.write(value + "\n");
            }
            bufferedWriter.flush();

        } catch(IOException ex){
            System.out.println("Output Failed");
        }
    }
}

