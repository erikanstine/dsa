package test.java.week_1;

import main.java.week_1.MergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMergeSort {
    @Test
    public void testMergeSort1() {
        Integer[] testCase = {3, 2, 1};
        Integer[] expected = {1, 2, 3};
        Integer[] actual = MergeSort.mergeSort(testCase);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testMergeSortLengthOne() {
        Integer[] testCase = {1};
        Integer[] expected = {1};
        Integer[] actual = MergeSort.mergeSort(testCase);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testBadTest() {
        assert 1 == 2;
    }
}
