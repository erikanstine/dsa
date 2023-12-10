package week_2;

import java.awt.*;

/**
 * This class takes in a list of n points and returns the pair of points which is
 * closest by Euclidean distance.
 */
public class FindClosestPair {
    public static Point[] findClosestPairBruteForce(Point[] points) {
        double minDistance = Integer.MAX_VALUE;
        Point[] closestPair = new Point[2];
        for (Point point : points) {
            for (int j = 1; j < points.length; j++) {
                double d = findDistance(point, points[j]);
                if (d == 0) {
                    continue;
                }
                if (d < minDistance) {
                    minDistance = d;
                    closestPair[0] = point;
                    closestPair[1] = points[j];
                }

            }
        }
        return closestPair;
    }
    public static Point[] findClosestPair(Point[] points) {
        /**
         * 1. Make two copies of points list, sorted by x- and y- coordinates
         * -> Px, Py
         * 2. Divide/Conquer
         * Q and R (left, right halves) -- base case omitted ( n < 4 )
         */

        return new Point[]{};
    }

    private Point[] mergeSortPointsX(Point[] points) {

        return new Point[]{};
    }
    private Point[] mergeSortPointsY(Point[] points) {

        return new Point[]{};
    }
    private static double findDistance(Point a, Point b) {
        return a.distanceSq(b);
    }
}
