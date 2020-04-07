public class Main {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = 0;
        int[] aux = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i] + maxSum;
            if (sum < 0) {
                aux[i] = nums[i];
                maxSum = 0;
            } else {
                maxSum = sum;
                aux[i] = maxSum;
            }
        }
        int result = Integer.MIN_VALUE;
        for (int value : aux) {
            if (value > result) {
                result = value;
            }
        }
        return result;
    }
}