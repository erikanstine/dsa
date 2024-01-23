package week_4;

import week_3.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class RSelect {
    QuickSort qs = new QuickSort();
    public Integer randomSelect(Integer[] intArray, Integer i) {
        int lenArray = intArray.length;
        if (lenArray == 1) {
            return intArray[0];
        }
        int partitionIndex = partition(intArray);
        int result = 0;
        // We guessed the ith order statistic
        if (partitionIndex == i) {
            result = intArray[i];
        } else if (partitionIndex < i) {
            // Partition index is lower than i, recurse on the '2nd' portion
            Integer[] newArray = Arrays.copyOfRange(intArray, partitionIndex+1, lenArray);
            result = randomSelect(newArray, i-partitionIndex-1);
        } else {
            // Partition index is higher than i, recurse on '1st' portion
            Integer[] newArray = Arrays.copyOfRange(intArray, 0, partitionIndex);
            result = randomSelect(newArray,  i);
        }
        return result;
    }

    private int partition(Integer[] intArray) {
        int pivotIndex = selectPivot(intArray);
        qs.swap(intArray, 0, pivotIndex);
        int pivot = intArray[0];
        int i = 1;
        int j = 1;
        while (j < intArray.length) {
            if (intArray[j] < pivot) {
                qs.swap(intArray, j, i);
                i++;
            }
            j++;
        }
        qs.swap(intArray, 0, i-1);
        return i-1;
    }


    private int selectPivot(Integer[] intArray) {
        Random rand = new Random();
        return rand.nextInt(intArray.length);
    }
}
