package week_3;

import org.junit.jupiter.api.Test;
import utils.readTxtFileInput;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestQuickSort {
    @Test
    public void testQuickSort() {
        QuickSort qs = new QuickSort();
        Integer[] testCase = {3, 2, 5, 1, 7, 8, 4, 6};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] actual = qs.quickSort(testCase);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testTxtFileQuickSort() {
        QuickSort qs = new QuickSort();
        Integer[] testCase = readTxtFileInput.readTxtFile("ints.txt");
        Integer[] actual = qs.quickSort(testCase);
    }
}
