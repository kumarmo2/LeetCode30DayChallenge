import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
    }
}

class Solution {
    public boolean isHappy(int n) {
        if (n == 100 || n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 7, 49, 97, 13, 31, 100,
        // 86, 68, 82, 28, 91, 19, 10, 13, 31));
        HashSet<Integer> set = new HashSet<>(
                Arrays.asList(1, 10, 100, 13, 31, 86, 68, 32, 23, 82, 28, 44, 91, 19, 7, 70, 49, 94, 97, 79, 13));
        while (n >= 100) {
            if (n == 100) {
                return true;
            }
            int[] arr = Solution.getDigistsArray(n);
            n = Solution.getSum(arr);
        }
        return set.contains(n);
        // if(n < 100) {
        // return set.contains(n);
        // }
        // }
        // return false;
    }

    private static int getSum(int[] arr) {
        int total = 0;
        for (int val : arr) {
            total = total + val * val;
        }
        return total;
    }

    private static int[] getDigistsArray(int guess) {
        String temp = Integer.toString(guess);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;
    }
}