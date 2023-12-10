package week_2;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SortAndCountInversions {
    public static void main(String[] args) throws IOException {
        // main() introduced to solve Programming Assignment #2
        Integer[] problemSet = readFileIntoArray();
        SortCountResult result = sortAndCountInversions(problemSet);
        System.out.println(result.getNumInversions());
    }
    private static Integer[] readFileIntoArray() throws IOException {
        Charset charset = StandardCharsets.ISO_8859_1;
        String filePathString = "";
        Path fp = Paths.get(filePathString).resolve("intArray.txt");
        List<String> result = Files.readAllLines(fp, charset);

        return result.stream().map(Integer::parseInt)
                .mapToInt(i->i)
                .boxed()
                .toArray(Integer[]::new);
    }
    public static SortCountResult sortAndCountInversions(Integer[] intArray) {
        int arrayLength = intArray.length;
        // Base case
        if (arrayLength == 0 || arrayLength == 1) {
            return new SortCountResult(intArray, BigInteger.ZERO);
        }

        Integer[] left = Arrays.copyOfRange(intArray, 0, arrayLength/2);
        Integer[] right = Arrays.copyOfRange(intArray, arrayLength/2, arrayLength);
        SortCountResult leftResult = sortAndCountInversions(left);
        SortCountResult rightResult = sortAndCountInversions(right);
        SortCountResult splitResult = mergeAndCountSplitInversions(leftResult.getArray(), rightResult.getArray());

        BigInteger totalInversions = leftResult.getNumInversions().add(rightResult.getNumInversions()).add(splitResult.getNumInversions());
        return new SortCountResult(splitResult.getArray(), totalInversions);
    }

    private static SortCountResult mergeAndCountSplitInversions(Integer[] a, Integer[] b) {
        int size = a.length + b.length;
        Integer[] result = new Integer[size];
        int i = 0;
        int j = 0;
        int l;
        int r;
        BigInteger numInv = BigInteger.ZERO;
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
                numInv = numInv.add(BigInteger.valueOf(size / 2 - i));
            } else {
                result[i+j] = l;
                i++;
            }
        }
        return new SortCountResult(result, numInv);
    }
}
