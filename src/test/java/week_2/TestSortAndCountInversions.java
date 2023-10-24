package week_2;

import org.junit.jupiter.api.Test;

public class TestSortAndCountInversions {
    @Test
    public void testSortAndCountInversions() {
        Integer[] testCase = {1, 3, 5, 2, 4, 6};
        int expected = 3;
        SortCountResult actual = SortAndCountInversions.sortAndCountInversions(testCase);
        assert actual.getNumInversions() == expected;
    }

    @Test
    public void testSortAndCountInversions_2() {
        Integer[] testCase = {6, 5, 4, 3, 2, 1};
        int expected = 15;
        SortCountResult actual = SortAndCountInversions.sortAndCountInversions(testCase);
        assert actual.getNumInversions() == expected;
    }

    @Test
    public void testLengthOne() {
        Integer[] testCase = {1};
        int expected = 0;
        SortCountResult actual = SortAndCountInversions.sortAndCountInversions(testCase);
        assert actual.getNumInversions() == expected;
    }
}
