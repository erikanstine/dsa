package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readTxtFileInput {
    public static Integer[] readTxtFile(String filename) {
        String filePath = "resources/" + filename;

        return readLinesAsIntArray(filePath);
    }

    private static Integer[] readLinesAsIntArray(String filePath) {
        List<Integer> integerList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert each line to an integer and add it to the list
                int num = Integer.parseInt(line);
                integerList.add(num);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Convert the list to an array
        Integer[] arrayOfIntegers = new Integer[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            arrayOfIntegers[i] = integerList.get(i);
        }

        return arrayOfIntegers;
    }
}
