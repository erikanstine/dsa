package week_1;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    static Random rand = new Random();
    public static Integer[] mergeSort(Integer[] intArray) {
        // split in two, sort each half
        int arrayLength = intArray.length;
        if (arrayLength < 2) {
            return intArray;
        }
        Integer[] left = Arrays.copyOfRange(intArray, 0, arrayLength/2);
        Integer[] right = Arrays.copyOfRange(intArray, arrayLength/2, arrayLength);
        Integer[] sortedLeft = mergeSort(left);
        Integer[] sortedRight = mergeSort(right);

        return merge(sortedLeft, sortedRight);
    }

    private static Integer[] merge(Integer[] left, Integer[] right) {
        int size = left.length + right.length;
        Integer[] result = new Integer[size];
        int i = 0;
        int j = 0;
        int l;
        int r;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                l = Integer.MAX_VALUE;
            } else {
                l = left[i];
            }
            if (j == right.length) {
                r = Integer.MAX_VALUE;
            } else {
                r = right[j];
            }
            if (r <= l) {
                result[i+j] = r;
                j++;
            } else {
                result[i+j] = l;
                i++;
            }
        }
        return result;
    }

    private static Integer[] generateRandom(int x) {
        Integer[] res = new Integer[x];
        for (int i = 0; i < x; i++) {
            res[i] = rand.nextInt(x);
        }
        return res;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("Pass in one argument for size of array");
        }
        Integer[] x = generateRandom(Integer.parseInt(args[0]));
        System.out.println("Starting mergeSort");
        long start = System.currentTimeMillis();
        mergeSort(x);
        long end = System.currentTimeMillis();
        System.out.println(
                "Elapsed time for sort of size " + args[0] + ": " + (end-start));
    }
}
