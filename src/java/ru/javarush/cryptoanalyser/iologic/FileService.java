package ru.javarush.cryptoanalyser.iologic;
import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileService {

    public static char[] readInfoFromFile(Scanner scanner) {
        System.out.print("Enter path to \"input_file.txt\": ");
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()))) {
            while (reader.ready()) {
                String line = reader.readLine();
                result.append(line).append("\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.print("Try again: ");
            readInfoFromFile(scanner);
        } catch (IOException e) {
            System.out.println("Input Failed");
        }
        result = new StringBuilder(result.toString().toLowerCase(Locale.ROOT));
        return result.toString().toCharArray();
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
