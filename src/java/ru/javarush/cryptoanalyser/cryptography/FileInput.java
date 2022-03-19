package ru.javarush.cryptoanalyser.cryptography;

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class FileInput {
    public static String FileInput() {
        String result = "";
        //String outputLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/projects/Alex_Goculenko_JavaRush_Project_1/src/java/ru/javarush/cryptoanalyser/inputText.txt"))) {


            while (reader.ready()) {

                String line = reader.readLine();
                result += line.toLowerCase(Locale.ROOT);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        } catch (IOException e) {
            System.out.println("Input Failed");
        }
        return result;
    }
}
