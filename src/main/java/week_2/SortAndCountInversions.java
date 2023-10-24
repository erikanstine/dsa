package week_2;

import java.util.Arrays;

public class SortAndCountInversions {
    public static SortCountResult sortAndCountInversions(Integer[] intArray) {
        int arrayLength = intArray.length;
        // Base case
        if (arrayLength == 0 || arrayLength == 1) {
            return new SortCountResult(intArray, 0);
        }

        Integer[] left = Arrays.copyOfRange(intArray, 0, arrayLength/2);
        Integer[] right = Arrays.copyOfRange(intArray, arrayLength/2, arrayLength);;
        SortCountResult leftResult = sortAndCountInversions(left);
        SortCountResult rightResult = sortAndCountInversions(right);
        SortCountResult splitResult = mergeAndCountSplitInversions(leftResult.getArray(), rightResult.getArray());

        int totalInversions = leftResult.getNumInversions() + rightResult.getNumInversions() + splitResult.getNumInversions();
        return new SortCountResult(splitResult.getArray(), totalInversions);

    }

    private static SortCountResult mergeAndCountSplitInversions(Integer[] a, Integer[] b) {
        int size = a.length + b.length;
        Integer[] result = new Integer[size];
        int i = 0;
        int j = 0;
        int l;
        int r;
        int numInv = 0;
        while (i < a.length || j < b.length) {
            if (i == a.length) {
                l = Integer.MAX_VALUE;
            } else {
                l = a[i];
            }
            if (j == b.length) {
                r = Integer.MAX_VALUE;
            } else {
                r = b[j];
            }
            if (r <= l) {
                result[i+j] = r;
                j++;
                numInv += size / 2 - i;
            } else {
                result[i+j] = l;
                i++;
            }
        }
        return new SortCountResult(result, numInv);
    }
}
