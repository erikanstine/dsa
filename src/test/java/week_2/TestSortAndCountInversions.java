package week_2;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class TestSortAndCountInversions {
    @Test
    public void testSortAndCountInversions() {
        Integer[] testCase = {1, 3, 5, 2, 4, 6};
        BigInteger expected = BigInteger.valueOf(3);
        SortCountResult actual = SortAndCountInversions.sortAndCountInversions(testCase);
        assert actual.getNumInversions().equals(expected);
    }

    @Test
    public void testSortAndCountInversions_2() {
        Integer[] testCase = {6, 5, 4, 3, 2, 1};
        BigInteger expected = BigInteger.valueOf(15);
        SortCountResult actual = SortAndCountInversions.sortAndCountInversions(testCase);
        assert actual.getNumInversions().equals(expected);
    }

    @Test
    public void testLengthOne() {
        Integer[] testCase = {1};
        BigInteger expected = BigInteger.ZERO;
        SortCountResult actual = SortAndCountInversions.sortAndCountInversions(testCase);
        assert actual.getNumInversions().equals(expected);
    }
}
