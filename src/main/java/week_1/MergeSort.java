package main.java.week_1;

import java.util.Arrays;

public class MergeSort {
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
            if (r < l) {
                result[i+j] = r;
                j++;
            } else {
                result[i+j] = l;
                i++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Integer[] x = {1, 4, 2, 7, 9, 3};
        System.out.println(Arrays.toString(mergeSort(x)));
    }
}
