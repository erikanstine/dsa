package week_2;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

public class TestFindClosestPair {
    @Test
    public void testFindClosestPairBruteForce() {
        Point[] testCase = new Point[]{new Point(0, 0), new Point(1, 1), new Point(10, 10)};
        Point[] expected = new Point[]{new Point(0, 0), new Point(1, 1)};
        Point[] actual = FindClosestPair.findClosestPairBruteForce(testCase);
        assert Arrays.equals(expected, actual);
    }
}
