/**
 * Original Question: Write a function that takes in an array of integers of length at least 2.
 * The function should return an array of starting and ending indices of smallest subarray that needs to be sorted
 * in place in order for the entire array to be sorted. If array is already sorted return [-1, -1].
 * Extra Challenges And Questions:
 * #1) What if there is more then one subarray that we can sort in place? Example: [1, 3, 2, 4, 5, 7, 6]
 * #2) Might there be a use case where we want to first check if array is already sorted?
 * #3)
 */
public class SubarraySort {

    // O(N) time | O(1) space
    public static int[] subarraySort(int[] array) {
        //  if (isArraySorted(array)) {
        //      return new int[]{-1, -1};
        //  }

        // we're going to look for smallest and biggest out of order elements in array - once we found them we will be
        // able to check what are the extremes index positions of subarray we need to sort
        int smallestOutOfOrder = Integer.MAX_VALUE;
        int biggestOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            if (isOutOfOrder(current, i, array)) {
                smallestOutOfOrder = Math.min(smallestOutOfOrder, current);
                biggestOutOfOrder = Math.max(biggestOutOfOrder, current);
            }
        }
        // if we haven't found any out of order element then smallestOutOfOrder should remain unchanged
        if (smallestOutOfOrder == Integer.MAX_VALUE) return new int[]{-1, -1};

        // now we need to find out indexes of smallest subarray to sort
        // we're checking from the beginning of array for the first place where our smallest out of order element
        // is greater or equal to array element - then we know that in that this is the index from which we need to start
        // sorting our subarray
        int subarrayLeftIndex = 0;
        while (smallestOutOfOrder >= array[subarrayLeftIndex]) {
            subarrayLeftIndex++;
        }

        // similiary for the biggest our of order element
        int subarrayRightIndex = array.length - 1;
        while (biggestOutOfOrder <= array[subarrayRightIndex]) {
            subarrayRightIndex--;
        }

        // finally, we return the array with result indexes
        return new int[]{subarrayLeftIndex, subarrayRightIndex};
    }

    /**
     * @param value value of currently checked array element
     * @param index index of currently checked array element
     * @param array array from which we're checking
     * @return true is element is in ordered position, false otherwise
     */
    private static boolean isOutOfOrder(int value, int index, int[] array) {
        if (index == 0) { //if we're checking first element in array - we only compare with next element
            return value > array[index + 1];
        }
        if (index == array.length - 1) { // if we're checking last element in array - we only compare with previous element
            return value < array[index - 1];
        }
        return value > array[index + 1] || value < array[index - 1]; // otherwise we compare with adjacent elements
    }


    /**
     * Simple helper method to check whether array is sorted.
     * Maybe in some specific cases we want to first check if it is sorted?
     * If we have a strong suspicion that it might be?
     * It might be saving a lot operations from isOutOfOrder and all this variable assignments in main method.
     *
     * @param a input array
     * @return true if array is sorted, false otherwise
     */
    private static boolean isArraySorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
