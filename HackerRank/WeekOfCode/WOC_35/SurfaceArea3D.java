package WeekOfCode.WOC_35;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/contests/w35/challenges/3d-surface-area
 * can be simplified such that we transpose the 2d array and use 1 method for calculation
 */
public class SurfaceArea3D {

    static int surfaceArea(int[][] A) {
        // top and bottom surface
        int surfaceArea = A[0].length * A.length * 2;

        // 1st side view
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0) {
                    surfaceArea += A[0][j];
                }
                if (i == A.length - 1) {
                    surfaceArea += A[A.length - 1][j];
                }
            }
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                surfaceArea += Math.abs(A[i - 1][j] - A[i][j]);
            }
        }

        // 2nd side view
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0) {
                    surfaceArea += A[i][0];
                }
                if (j == A[0].length - 1) {
                    surfaceArea += A[i][A[0].length - 1];
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                surfaceArea += Math.abs(A[i][j - 1] - A[i][j]);
            }
        }

        return surfaceArea;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for (int A_i = 0; A_i < H; A_i++) {
            for (int A_j = 0; A_j < W; A_j++) {
                A[A_i][A_j] = in.nextInt();

            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}