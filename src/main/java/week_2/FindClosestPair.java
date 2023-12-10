package week_2;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * This class takes in a list of n points and returns the pair of points which is
 * closest by Euclidean distance.
 */
public class FindClosestPair {
    public static ArrayList<Point> findClosestPairBruteForce(ArrayList<Point> points) {
        double minDistance = Integer.MAX_VALUE;
        ArrayList<Point> closestPair = new ArrayList<>();
        for (Point point : points) {
            for (int j = 1; j < points.size(); j++) {
                double d = findDistance(point, points.get(j));
                if (d == 0) {
                    continue;
                }
                if (d < minDistance) {
                    minDistance = d;
                    closestPair = new ArrayList<>();
                    closestPair.add(point);
                    closestPair.add(points.get(j));
                }

            }
        }
        return closestPair;
    }
    public static ArrayList<Point> findClosestPairDivideConquer(ArrayList<Point> points) {
        /**
         * 1. Make two copies of points list, sorted by x- and y- coordinates
         * -> Px, Py
         * 2. Divide/Conquer
         * Q and R (left, right halves) -- base case omitted ( n < 4 )
         */

        ArrayList<Point> Px = mergeSortPointsX(points);
        ArrayList<Point> Py = mergeSortPointsY(points);
        return closestPair(Px, Py);
    }

    private static ArrayList<Point> closestPair(ArrayList<Point> Px, ArrayList<Point> Py) {
        int pxLength = Px.size();
        // Base case
        if (pxLength < 4) {
            return findClosestPairBruteForce(Px);
        }

        ArrayList<Point> Lx = new ArrayList<>(Px.subList(0, pxLength/2));
        ArrayList<Point> Rx = new ArrayList<>(Px.subList(pxLength/2, pxLength));

        int maxLx = Lx.get(Lx.size()-1).x;
        ArrayList<Point> Ly = new ArrayList<>();
        ArrayList<Point> Ry = new ArrayList<>();
        for (Point point : Py) {
            if (point.x <= maxLx) {
                Ly.add(point);
            } else {
                Ry.add(point);
            }
        }

        ArrayList<Point> bestLeft = closestPair(Lx, Ly);
        ArrayList<Point> bestRight = closestPair(Rx, Ry);
        double d = Double.min(findDistance(bestLeft.get(0), bestLeft.get(1)), findDistance(bestRight.get(0), bestRight.get(1)));
        ArrayList<Point> bestSplitPair = closestSplitPair(Px, Py, d);

        return findBestPairByDistance(bestLeft, bestRight, bestSplitPair);
    }

    private static ArrayList<Point> closestSplitPair(ArrayList<Point> px, ArrayList<Point> py, double d) {
        int medianX = new ArrayList<>(px.subList(0, px.size()/2)).get((px.size()/2)-1).x;
        ArrayList<Point> Sy = py.stream()
                .filter(c -> medianX - d <= c.x)
                .filter(c -> c.x <= medianX + d)
                .collect(Collectors.toCollection(ArrayList::new));
        double bestDistance = Double.MAX_VALUE;
        ArrayList<Point> bestPair = new ArrayList<>(2);
        for (int i = 0; i < Sy.size(); i++) {
            for (int j = i + 1; j < (Integer.min(i+7, Sy.size())); j++) {
               double dist = findDistance(Sy.get(i), Sy.get(j));
                if (dist < bestDistance) {
                   bestDistance = dist;
                   bestPair = new ArrayList<>();
                   bestPair.add(Sy.get(i));
                   bestPair.add(Sy.get(j));
               }
            }

        }
        return bestPair;
    }

    private static ArrayList<Point> findBestPairByDistance(ArrayList<Point> l, ArrayList<Point> r, ArrayList<Point> s) {
        ArrayList<ArrayList<Point>> pointPairs = new ArrayList<>();
        pointPairs.add(l);
        pointPairs.add(r);
        pointPairs.add(s);
        double minDistance = Double.MAX_VALUE;
        ArrayList<Point> bestPair = l;
        for (ArrayList<Point> points: pointPairs) {
            double dist = findDistance(points.get(0), points.get(1));
            if (dist < minDistance) {
                minDistance = dist;
                bestPair = points;
            }
        }
        return bestPair;
    }

    public static ArrayList<Point> mergeSortPointsX(ArrayList<Point> points) {
        // split in two, sort each half
        int arrayLength = points.size();
        if (arrayLength < 2) {
            return points;
        }
        ArrayList<Point> left = new ArrayList<>(points.subList(0, arrayLength/2));
        ArrayList<Point> right = new ArrayList<>(points.subList(arrayLength/2, arrayLength));
        ArrayList<Point> sortedLeft = mergeSortPointsX(left);
        ArrayList<Point> sortedRight = mergeSortPointsX(right);

        return mergeX(sortedLeft, sortedRight);
    }

    public static ArrayList<Point> mergeSortPointsY(ArrayList<Point> points) {
        // split in two, sort each half
        int arrayLength = points.size();
        if (arrayLength < 2) {
            return points;
        }
        ArrayList<Point> left = new ArrayList<>(points.subList(0, arrayLength/2));
        ArrayList<Point> right = new ArrayList<>(points.subList(arrayLength/2, arrayLength));
        ArrayList<Point> sortedLeft = mergeSortPointsY(left);
        ArrayList<Point> sortedRight = mergeSortPointsY(right);

        return mergeY(sortedLeft, sortedRight);
    }

    private static ArrayList<Point> mergeX(ArrayList<Point> left, ArrayList<Point> right) {
        ArrayList<Point> result = new ArrayList<>();
        // pointers
        int i = 0;
        int j = 0;
        //
        Point l;
        Point r;
        while (i < left.size() || j < right.size()) {
            if (i == left.size()) {
                l = new Point(Integer.MAX_VALUE, 0);
            } else {
                l = left.get(i);
            }
            if (j == right.size()) {
                r = new Point(Integer.MAX_VALUE, 0);
            } else {
                r = right.get(j);
            }
            if (r.x <= l.x) {
                result.add(r);
                j++;
            } else {
                result.add(l);
                i++;
            }
        }
        return result;
    }

    private static ArrayList<Point> mergeY(ArrayList<Point> left, ArrayList<Point> right) {
        int size = left.size() + right.size();
        ArrayList<Point> result = new ArrayList<>(size);
        // pointers
        int i = 0;
        int j = 0;
        //
        Point l;
        Point r;
        while (i < left.size() || j < right.size()) {
            if (i == left.size()) {
                l = new Point(0, Integer.MAX_VALUE);
            } else {
                l = left.get(i);
            }
            if (j == right.size()) {
                r = new Point(0, Integer.MAX_VALUE);
            } else {
                r = right.get(j);
            }
            if (r.y <= l.y) {
                result.add(r);
                j++;
            } else {
                result.add(l);
                i++;
            }
        }
        return result;
    }
    private static double findDistance(Point a, Point b) {
        return a.distanceSq(b);
    }
}
