package week_2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TestMultiplyMatrix {
  @Test
  public void testSimpleMultiplication_Iterative() {
    int[][] testCaseA = {{1, 2},
                         {3, 4}};
    int[][] testCaseB = {{5, 6},
                         {7, 8}};

    int[][] expected = {{19, 22}, {43, 50}};
    assertArrayEquals(MultiplyMatrix.multiplyMatrixIterative(testCaseA, testCaseB), expected);
  }

  @Test
  public void testMultiplyByIdentity_Iterative() {
    int[][] testCaseA = {{1, 2}, {3, 4}};
    int[][] testCaseB = {{1, 0}, {0, 1}};

    int[][] expected = {{1, 2}, {3, 4}};
    assertArrayEquals(MultiplyMatrix.multiplyMatrixIterative(testCaseA, testCaseB), expected);
  }

  @Test
  public void testMultiplyByIdentity_Recursive() {
    int[][] testCaseA = {{1, 2}, {3, 4}};
    int[][] testCaseB = {{1, 0}, {0, 1}};

    int[][] expected = {{1, 2}, {3, 4}};
    assertArrayEquals(MultiplyMatrix.multiplyMatrixRecursive(testCaseA, testCaseB), expected);
  }

  @Test
  public void testMultiplyByIdentity_4x4_Recursive() {
    int[][] testCaseA = {{1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16}};
    int[][] testCaseB = {{1, 0, 0, 0},
                         {0, 1, 0, 0},
                         {0, 0, 1, 0},
                         {0, 0, 0, 1}};

    int[][] expected = { {1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16}};
    assertArrayEquals(MultiplyMatrix.multiplyMatrixRecursive(testCaseA, testCaseB), expected);
  }

  @Test
  public void testMultiplyByIdentity_Strassen() {
    int[][] testCaseA = {{1, 2}, {3, 4}};
    int[][] testCaseB = {{1, 0}, {0, 1}};

    int[][] expected = {{1, 2}, {3, 4}};
    assertArrayEquals(MultiplyMatrix.multiplyMatrixStrassen(testCaseA, testCaseB), expected);
  }

  @Test
  public void testGetSubmatrixA() {
    int[][] testCase = {{1, 2}, {3, 4}};
    int[][] expected = {{1}};
    assertArrayEquals(MultiplyMatrix.getSubmatrixA(testCase), expected);
  }
  @Test
  public void testGetSubmatrixB() {
    int[][] testCase = {{1, 2}, {3, 4}};
    int[][] expected = {{2}};
    assertArrayEquals(MultiplyMatrix.getSubmatrixB(testCase), expected);
  }
  @Test
  public void testGetSubmatrixC() {
    int[][] testCase = {{1, 2}, {3, 4}};
    int[][] expected = {{3}};
    assertArrayEquals(MultiplyMatrix.getSubmatrixC(testCase), expected);
  }
  @Test
  public void testGetSubmatrixD() {
    int[][] testCase = {{1, 2}, {3, 4}};
    int[][] expected = {{4}};
    assertArrayEquals(MultiplyMatrix.getSubmatrixD(testCase), expected);
  }
}
