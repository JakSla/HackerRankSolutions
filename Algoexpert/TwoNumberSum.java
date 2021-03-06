import java.util.HashMap;

class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashMap<Integer, Boolean> nums = new HashMap<>();
        for (int num : array) {
            int potentialMatch = targetSum - num;

            if (nums.containsKey(potentialMatch)) {
                return potentialMatch > num ? new int[]{num, potentialMatch} : new int[]{potentialMatch, num};
            } else {
                nums.put(num, true);
            }
        }
        return new int[0];
    }
}
