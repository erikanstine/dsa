package week_2;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFindClosestPair {
    @Test
    public void testFindClosestPairBruteForce_1() {
        ArrayList<Point> testCase = new ArrayList<>(Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(10, 10)));
        ArrayList<Point> expected = new ArrayList<>(Arrays.asList(new Point(0, 0), new Point(1, 1)));
        ArrayList<Point> actual = FindClosestPair.findClosestPairBruteForce(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindClosestPairBruteForce_2() {
        ArrayList<Point> testCase = new ArrayList<>(Arrays.asList(
                new Point(1, 8),
                new Point(2, 5),
                new Point(4, 7),
                new Point(6, 3)));
        ArrayList<Point> expected = new ArrayList<>(Arrays.asList(new Point(2, 5), new Point(4, 7)));
        ArrayList<Point> actual = FindClosestPair.findClosestPairBruteForce(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindClosestPairDivideConquer_1() {
        ArrayList<Point> testCase = new ArrayList<>(Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(10, 10)));
        ArrayList<Point> expected = new ArrayList<>(Arrays.asList(new Point(0, 0), new Point(1, 1)));
        ArrayList<Point> actual = FindClosestPair.findClosestPairDivideConquer(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindClosestPairDivideConquer_2() {
        ArrayList<Point> testCase = new ArrayList<>(Arrays.asList(
                new Point(1, 8),
                new Point(2, 5),
                new Point(4, 7),
                new Point(6, 3)));
        ArrayList<Point> expected = new ArrayList<>(Arrays.asList(new Point(2, 5), new Point(4, 7)));
        ArrayList<Point> actual = FindClosestPair.findClosestPairDivideConquer(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testSortPoints() {
        ArrayList<Point> testCase = new ArrayList<>(Arrays.asList(
                new Point(1, 8),
                new Point(2, 5),
                new Point(4, 7),
                new Point(6, 3)));
        ArrayList<Point> expectedX = new ArrayList<>(Arrays.asList(
                new Point(1, 8),
                new Point(2, 5),
                new Point(4, 7),
                new Point(6, 3)));
        ArrayList<Point> expectedY = new ArrayList<>(Arrays.asList(
                new Point(6, 3),
                new Point(2, 5),
                new Point(4, 7),
                new Point(1, 8)));

        ArrayList<Point> actualX = FindClosestPair.mergeSortPointsX(testCase);
        ArrayList<Point> actualY = FindClosestPair.mergeSortPointsY(testCase);
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);
    }
}
