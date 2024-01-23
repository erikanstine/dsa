package week_3;

import java.util.Arrays;

public class QuickSort {
    int numComparisons = 0;
    public Integer[] quickSort(Integer[] intArray) {
        innerQuickSort(intArray, 0, intArray.length);
        return intArray;
    }

    private  void innerQuickSort(Integer[] intArray, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(intArray, begin, end);
            innerQuickSort(intArray, begin, partitionIndex);
            innerQuickSort(intArray, partitionIndex+1, end);
        }
    }

    private int partition(Integer[] intArray, int l, int r) {
        // choose pivot
        selectPivot(intArray, l, r);
        int pivot = intArray[l];
//        int pivot = intArray[r-1];
        int i = l + 1; // separates lower than and higher than
        int j = l + 1; // viewed/unviewed
        while (j < r) {
            if (intArray[j] < pivot) {
                swap(intArray, j, i);
                i++;
            }
            j++;
        }
        swap(intArray, l, i-1);
        addComparisons(r - l - 1);
        return i-1;
    }

    private void addComparisons(int i) {
        numComparisons += i;
    }

    private void swap(Integer[] intArray, int j, int i) {
        int temp = intArray[j];
        intArray[j] = intArray[i];
        intArray[i] = temp;
    }


    private void selectPivot(Integer[] intArray, int start, int end) {
//        Random rand = new Random();
//        int pIndex = rand.nextInt(end-start);
//        swap(intArray, pIndex+start, start);
//        swap(intArray, start, end-1);
        // Median-of-three
        int f = intArray[start];
        int l = intArray[end-1];
        int m = getMedian(intArray, start, end);
        int[] unsorted = {f, l, m};
        Arrays.sort(unsorted);
        int partitionLength = end - start;
        if (unsorted[1] == l) {
            swap(intArray, start, end-1);
        } else if (unsorted[1] == m) {
            if (partitionLength % 2 == 0) {
                swap(intArray, start, partitionLength / 2 - 1 + start);
            } else {
                swap(intArray, start, partitionLength / 2 + start);
            }
        }
    }

    private int getMedian(Integer[] intArray, int begin, int end) {
        int idx;
        int l = end - begin;
        if (l % 2 == 0) {
            idx = l / 2 - 1 + begin;
        } else {
            idx = l / 2 + begin;
        }
        return intArray[idx];
    }
}
