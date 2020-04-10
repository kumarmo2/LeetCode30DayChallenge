import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] inputStrArr = line.split(" ");
        int[] arr = new int[inputStrArr.length];
        for (int i = 0; i < inputStrArr.length; i++) {
            arr[i] = Integer.parseInt(inputStrArr[i]);
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        while (zeroIndex < n) {
            int newZeroIndex = Solution.getNewZeroIndex(nums, zeroIndex);
            if (newZeroIndex >= n) {
                return;
            }
            zeroIndex = newZeroIndex;
            int newNonZeroIndex = Solution.getNewNonZeroIndex(nums, nonZeroIndex);
            if (newNonZeroIndex >= n) {
                return;
            }
            nonZeroIndex = newNonZeroIndex;
            if (nonZeroIndex > zeroIndex) {
                swap(nums, zeroIndex, nonZeroIndex);
                zeroIndex++;
                nonZeroIndex++;
            } else {
                nonZeroIndex++;
            }
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    private static int getNewNonZeroIndex(int[] nums, int currentNonZeroIndex) {
        int n = nums.length;
        int i = currentNonZeroIndex;
        while (i < n && nums[i] == 0) {
            i++;
        }
        return i;
    }

    private static int getNewZeroIndex(int[] nums, int currentZeroIndex) {
        int n = nums.length;
        int i = currentZeroIndex;
        while (i < n && nums[i] != 0) {
            i++;
        }
        return i;
    }
}