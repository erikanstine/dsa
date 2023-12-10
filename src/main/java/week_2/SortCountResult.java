package week_2;

import java.math.BigInteger;

public class SortCountResult {
    private final Integer[] array;
    private final BigInteger numInversions;
    public SortCountResult(Integer[] intArray, BigInteger numInversions) {
        this.array = intArray;
        this.numInversions = numInversions;
    }

    public Integer[] getArray() {
        return array;
    }

    public BigInteger getNumInversions() {
        return numInversions;
    }
}
