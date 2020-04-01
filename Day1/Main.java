import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        String[] inputArrStr = inputLine.split(" ");
        int[] nums = new int[inputArrStr.length];
        for (int i = 0; i < inputArrStr.length; i++) {
            nums[i] = Integer.parseInt(inputArrStr[i]);
        }
        System.out.println(new Solution().singleNumber(nums));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int value : nums) {
            result = result ^ value;
        }
        return result;
    }
}