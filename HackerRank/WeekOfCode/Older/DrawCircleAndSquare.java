package WeekOfCode.Older;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * HackerRank A Circle And A Square
 * https://www.hackerrank.com/contests/w29/challenges/a-circle-and-a-square
 */
public class DrawCircleAndSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double w = Math.abs(in.nextInt());
        double h = Math.abs(in.nextInt());
        double circleX = in.nextInt();
        double circleY = in.nextInt();
        double r = Math.abs(in.nextInt());
        double x1 = in.nextInt();
        double y1 = in.nextInt();
        double x3 = in.nextInt();
        double y3 = in.nextInt();

        String[][] array = new String[(int) h][(int) w];
        for (String[] row : array)
            Arrays.fill(row, ".");

        //Circle without outOfBound
        fillCircle(array, circleX, circleY, r, w, h);

        //Calculate other 2 corners
        double centerX = ((x1 + x3) / 2);
        double centerY = ((y1 + y3) / 2);

        double xDiag = (x1 - x3) / 2;
        double yDiag = (y1 - y3) / 2;

        double x2 = centerX - yDiag;
        double y2 = xDiag + centerY;

        double x4 = centerX + yDiag;
        double y4 = centerY - xDiag;

        //find all points inside of square
        double squareArea = Math.abs((y1 - y3) * (x4 - x2) + (y2 - y4) * (x1 - x3)) / 2;
        for (double i = 0; i < array.length; i++) {
            for (double j = 0; j < array[(int) i].length; j++) {
                double traingleOne = triangleArea(x1, y1, x2, y2, j, i);
                double triangleTwo = triangleArea(x2, y2, x3, y3, j, i);
                double triangleThree = triangleArea(x3, y3, x4, y4, j, i);
                double triangleFour = triangleArea(x4, y4, x1, y1, j, i);
                double triangleAllArea = traingleOne + triangleTwo + triangleThree + triangleFour;
                if (!(triangleAllArea > squareArea)) {

                    if (0 <= i && i < h && 0 <= j && j < w) {
                        array[(int) i][(int) j] = "#";
                    }
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    static double triangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs(((x1 * (y2 - y3)) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
    }

    static void printRow(String[] row) {
        for (String i : row) {
            System.out.print(i);
            System.out.print("");
        }
        System.out.println();
    }

    static void fillCircle(String[][] array, double circleY, double circleX, double r, double w, double h) {
        for (int x = (int) (circleX - r); x <= circleX; x++) {
            for (int y = (int) (circleY - r); y <= circleY; y++) {
                if ((x - circleX) * (x - circleX) + (y - circleY) * (y - circleY) <= r * r) {
                    int xSym = (int) (circleX - (x - circleX));
                    int ySym = (int) (circleY - (y - circleY));
                    if (0 <= x && x < h && 0 <= y && y < w) {
                        array[x][y] = "#";
                    }
                    if (0 <= x && x < h && 0 <= ySym && ySym < w) {
                        array[x][ySym] = "#";
                    }
                    if (0 <= xSym && xSym < h && 0 <= y && y < w) {
                        array[xSym][y] = "#";
                    }
                    if (0 <= xSym && xSym < h && 0 <= ySym && ySym < w) {
                        array[xSym][ySym] = "#";
                    }
                }
            }
        }
    }
}
