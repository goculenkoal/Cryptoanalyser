package ru.javarush.cryptoanalyser.cryptography;

import ru.javarush.cryptoanalyser.iologic.FileService;
import java.util.*;

import static ru.javarush.cryptoanalyser.globalconst.Alphabet.ALPHABET_STRING;
import static ru.javarush.cryptoanalyser.globalconst.Alphabet.LENGTH_OF_ALPHABET;

public class FreqAnalysis {

    private static double ALL_NUM = 0.0;

    public static void starting() {
        char[] standardChar        = {' ',   'о',   'е',  'а',  'и',  'н','т'};
        double[] standardFrequency = {13.0, 10.98, 8.48, 7.98, 7.36, 6.7, 6.3};
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map =COUNTOffrequentlyChar(FileService.readInfoFromFile(scanner));
        map = sortByValue(map);
        String[][] arrayAlphabet = new String[map.size()][2];
        int indexRow = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            arrayAlphabet[indexRow++] = new String[]{String.valueOf(entry.getKey()), entry.getValue().toString()};
        }

        double[] numArray = new double[LENGTH_OF_ALPHABET-2];
        for (int i = 0; i < arrayAlphabet.length; i++) {
            for (int k = 1; k < arrayAlphabet[i].length;k++) {
                numArray[i] = (Double.parseDouble(arrayAlphabet[i][k])/ALL_NUM)*100 ;
                double value = numArray[i];
                double scale = Math.pow(10,3);
                numArray[i] = Math.ceil(value * scale) / scale;
            }
        }

        reverse(numArray);
        System.out.println("шифрованный текст" + "\t\t\t\t" + "эталонный текст");
        System.out.println("символ" + "\t\t\t" +"частота" +"\t\t\t" + "символ" + "\t\t" +"частота" );
        for (int i = 0; i < 7; i++) {
            for (int j = 1; j >= 1 ; --j) {
                System.out.println("\t"+arrayAlphabet[arrayAlphabet.length-1 -i][0] + "\t\t\t" + numArray[i] +" %" + "\t\t\t" + standardChar[i] + "\t\t\t" + standardFrequency[i]+" %") ;
            }
            System.out.println();
        }
        System.out.println("Определите сдвиг исходя из статистики: " + ALPHABET_STRING + "'<--- пробел'");
    }

    public static Map<Character, Integer> COUNTOffrequentlyChar(char[] inputText) {
        String newText = new String(inputText);
        newText = newText.replaceAll("[^абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\":!? ]", "");
        ALL_NUM = newText.length();

        Map<Character, Integer> result = new TreeMap<>();

        for (int i = 0; i < newText.length(); i++) {
            char ch = newText.charAt(i);
            if (result.get(ch) != null) {
                result.put(ch, result.get(ch) + 1);
            } else {
                result.put(ch, 1);
            }
        }
        return result;
    }

    public static <Character, Integer extends Comparable<? super Integer>> Map<Character, Integer>
    sortByValue(Map<Character, Integer> map )
    {
        List<Map.Entry<Character, Integer>> list =
                new LinkedList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void reverse(double[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        double tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }
}
