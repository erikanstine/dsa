package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class readTxtFileInput {
    public static Integer[] readTxtFile(String filename) {
        String filePath = "resources/" + filename;

        return readLinesAsIntArray(filePath);
    }

    public static Map<Integer, List<Integer>> readTxtFileIntoGraph(String filename) {
        String filePath = "resources/" + filename;
        Map<Integer, List<Integer>> graphMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert each line into map
                String[] strings = line.split("\\s+");
                List<Integer> nums = Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
                graphMap.put(nums.get(0), nums.subList(1, nums.size()));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return graphMap;
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
