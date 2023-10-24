package week_2;

public class SortCountResult {
    private final Integer[] array;
    private final int numInversions;
    public SortCountResult(Integer[] intArray, int numInversions) {
        this.array = intArray;
        this.numInversions = numInversions;
    }

    public Integer[] getArray() {
        return array;
    }

    public int getNumInversions() {
        return numInversions;
    }
}
