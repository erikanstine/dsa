package week_2;

import java.util.Arrays;
import java.util.Collections;

/**
* This class includes different matrix multiplication algorithms for two N x N matrices.
*/
public class MultiplyMatrix {
  public static int[][] multiplyMatrixIterative(int[][] x, int[][] y) {
    int size = x.length;  // naive assumption that all dimensions are the same
    int[][] result = new int[size][size];
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        result[i][j] = 0;
        for(int k = 0; k < size; k++) {
          result[i][j] += x[i][k] * y[k][j];
        }
      }
    }
    return result;
  }

  public static int[][] multiplyMatrixRecursive(int[][] x, int[][] y) {
    int size = x.length;
    int[][] result = new int[size][size];
    if (size == 1) {
      result[0][0] = x[0][0] * y[0][0];
      return result;
    }
    // Split into 4 matrices each
    int[][] a = getSubmatrixA(x);
    int[][] b = getSubmatrixB(x);
    int[][] c = getSubmatrixC(x);
    int[][] d = getSubmatrixD(x);
    int[][] e = getSubmatrixA(y);
    int[][] f = getSubmatrixB(y);
    int[][] g = getSubmatrixC(y);
    int[][] h = getSubmatrixD(y);

    int[][] aebg = addMatrix(multiplyMatrixRecursive(a, e), multiplyMatrixRecursive(b, g));
    int[][] afbh = addMatrix(multiplyMatrixRecursive(a, f), multiplyMatrixRecursive(b, h));
    int[][] cedg = addMatrix(multiplyMatrixRecursive(c, e), multiplyMatrixRecursive(d, g));
    int[][] cfdh = addMatrix(multiplyMatrixRecursive(c, f), multiplyMatrixRecursive(d, h));

    result = combineSubmatrices(aebg, afbh, cedg, cfdh);

    return result;
  }

  public static int[][] multiplyMatrixStrassen(int[][] x, int[][] y) {
    int size = x.length;
    int[][] result = new int[size][size];
    if (size == 1) {
      result[0][0] = x[0][0] * y[0][0];
      return result;
    }

    int[][] a = getSubmatrixA(x);
    int[][] b = getSubmatrixB(x);
    int[][] c = getSubmatrixC(x);
    int[][] d = getSubmatrixD(x);
    int[][] e = getSubmatrixA(y);
    int[][] f = getSubmatrixB(y);
    int[][] g = getSubmatrixC(y);
    int[][] h = getSubmatrixD(y);

    int[][] p1 = multiplyMatrixStrassen(a, subtractMatrix(f, h));
    int[][] p2 = multiplyMatrixStrassen(addMatrix(a, b), h);
    int[][] p3 = multiplyMatrixStrassen(addMatrix(c, d), e);
    int[][] p4 = multiplyMatrixStrassen(d, subtractMatrix(g, e));
    int[][] p5 = multiplyMatrixStrassen(addMatrix(a, d), addMatrix(e, h));
    int[][] p6 = multiplyMatrixStrassen(subtractMatrix(b, d), addMatrix(g, h));
    int[][] p7 = multiplyMatrixStrassen(subtractMatrix(a, c), addMatrix(e, f));

    int[][] topLeft = addMatrix(p6, subtractMatrix(addMatrix(p5, p4), p2));
    int[][] topRight = addMatrix(p1, p2);
    int[][] bottomLeft = addMatrix(p3, p4);
    int[][] bottomRight = subtractMatrix(subtractMatrix(addMatrix(p1, p5), p3), p7);

    result = combineSubmatrices(topLeft, topRight, bottomLeft, bottomRight);

    return result;
  }

  private static int[][] combineSubmatrices(int[][] topLeft, int[][] topRight,
      int[][] bottomLeft, int[][] bottomRight) {
    int half = topLeft.length;
    int size = half * 2;
    int[][] result = new int[size][size];
    for(int i = 0; i < half; i++) {
      int[] tempA = new int[size];
      int[] tempB = new int[size];
      System.arraycopy(topLeft[i], 0, tempA, 0, half);
      System.arraycopy(topRight[i], 0, tempA, half, half);
      result[i] = tempA;
      System.arraycopy(bottomLeft[i], 0, tempB, 0, half);
      System.arraycopy(bottomRight[i], 0, tempB, half, half);
      result[half +i] = tempB;
    }
    return result;
  }

  public static int[][] addMatrix(int[][] a, int[][] b) {
    int size = a.length;
    int[][] result = new int[size][size];
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        result[i][j] = a[i][j] + b[i][j];
      }
    }
    return result;
  }

  public static int[][] subtractMatrix(int[][] a, int[][] b) {
    int size = a.length;
    int[][] result = new int[size][size];
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        result[i][j] = a[i][j] - b[i][j];
      }
    }
    return result;
  }

/**
* Get upper-left sub-matrix
 * @param original
 * @return upper-left
*/
  static int[][] getSubmatrixA(int[][] original) {
    int half = original.length/2;
    int[][] result = new int[half][half];
    for(int i = 0; i < half; i++) {
      result[i] = Arrays.copyOfRange(original[i], 0, half);
    }
    return result;
  }

  /**
   * Get upper-right sub-matrix
   * @param original
   * @return upper-right
   */
  static int[][] getSubmatrixB(int[][] original) {
    int half = original.length/2;
    int[][] result = new int[half][half];
    for(int i = 0; i < half; i++) {
      result[i] = Arrays.copyOfRange(original[i], half, original.length);
    }
    return result;
  }

  /**
   * Get lower-left sub-matrix
   * @param original
   * @return lower-left
   */
  static int[][] getSubmatrixC(int[][] original) {
    int half = original.length/2;
    int[][] result = new int[half][half];
    for(int i = 0; i < half; i++) {
      result[i] = Arrays.copyOfRange(original[half+i], 0, half);
    }
    return result;
  }

  /**
   * Get upper-left sub-matrix
   * @param original
   * @return lower-right
   */
  static int[][] getSubmatrixD(int[][] original) {
    int half = original.length/2;
    int[][] result = new int[half][half];
    for(int i = 0; i < half; i++) {
      result[i] = Arrays.copyOfRange(original[half+i], half, original.length);
    }
    return result;
  }
}
