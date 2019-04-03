import java.util.Arrays;

/**
 * Original question: Given an unsorted array, find the minimum difference between any pair in given array.
 * Assume that there will be only one pair with smallest difference.
 * Return array with number from first array in the first place, from second in the second place.
 * Extra Challenges:
 *  #1 return result array with smaller number in the first, bigger number in the second place.
 *  #2 what if there is more then one smallest difference pair? So that we return array of arrays.
 */
public class SmallestDifference {


    //  O(m log m + n log n) time | O(1) space
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        for (int i : arrayOne) {
            System.out.print(i + ", ");
        }
        System.out.println("");
        for (int i : arrayTwo) {
            System.out.print(i + ", ");
        }
        System.out.println("");

        int indexOne = 0;
        int indexTwo = 0;
        int currentDiff = Integer.MAX_VALUE;
        int smallestDiff = Integer.MAX_VALUE;
        int[] smallestDifferencePair = new int[2];

        while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
            int firstNumber = arrayOne[indexOne];
            int secondNumber = arrayTwo[indexTwo];

            if (firstNumber < secondNumber) {
                currentDiff = secondNumber - firstNumber;
                indexOne++;
            } else if (firstNumber > secondNumber) {
                currentDiff = firstNumber - secondNumber;
                indexTwo++;
            } else {
                return new int[] {firstNumber, secondNumber};
            }
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                smallestDifferencePair = new int[] {firstNumber, secondNumber};
            }
        }

        System.out.println(smallestDifferencePair[0]);
        System.out.println(smallestDifferencePair[1]);
        return smallestDifferencePair;
    }

    // O(n^2) time | O(1) space
    public static int[] smallestDifferenceBruteForce(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[2];
        int smallestDifference = Integer.MAX_VALUE;
        int firstNumber = 0;
        int secondNumber = 0;
        for (int i : arrayOne) {
            for (int j : arrayTwo) {
                if (Math.abs(i - j) < smallestDifference) {
                    smallestDifference = Math.abs(i - j);
                    firstNumber = i;
                    secondNumber = j;
                }
            }
        }
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        return firstNumber < secondNumber ? new int[]{firstNumber, secondNumber} : new int[]{secondNumber, firstNumber};
    }
}
