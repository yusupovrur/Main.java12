
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> wordsFrequency = new TreeMap<>();

        try (FileReader fileReader = new FileReader("text.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                String[] words = s.split("[^A-Za-z]+");
                for (String word : words) {
                    if (!word.equals("")) {
                        if (wordsFrequency.get(word.toLowerCase()) == null) {
                            wordsFrequency.put(word.toLowerCase(), 1);
                        } else {
                            Integer oldFrequency = wordsFrequency.get(word.toLowerCase());
                            wordsFrequency.replace(word.toLowerCase(), oldFrequency + 1);
                        }
                    }

                }
                for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()) {
                    System.out.printf("Слово %s встречается %d раз\n", entry.getKey(), +entry.getValue());

                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("result.txt")) {
            for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()) {
                String s = String.format("Слово %s встречается %d раз\n", entry.getKey(), +entry.getValue());
                fileWriter.write(s);
            }
            String maxKey = "";
            int maxValue = 0;

            for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            String a = String.format("Слово \"%s\" чаще всего встречается в тексте (%d раз(а)) ", maxKey, maxValue);
            fileWriter.write(a);
//укцукцукцукцукцукцукцук

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}