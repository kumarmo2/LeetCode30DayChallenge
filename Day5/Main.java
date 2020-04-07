import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] inputArrStr = line.split(" ");
        int[] prices = new int[inputArrStr.length];
        for (int i = 0; i < inputArrStr.length; i++) {
            prices[i] = Integer.parseInt(inputArrStr[i]);
        }
        System.out.println(new Solution().maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int n = prices.length;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && prices[j] >= prices[j - 1]) {
                j++;
                // System.out.println("j = " + j);
            }
            if (j >= n) {
                if (prices[j - 1] > prices[i]) {
                    profit = profit + (prices[j - 1] - prices[i]);
                }
                break;
            } else if (prices[j] <= prices[j - 1]) {
                // System.out.println("inside second");
                if (j == i + 1) {
                    // System.out.println("j " + j + " i = " + i);
                    i++;
                } else {
                    profit = profit + (prices[j - 1] - prices[i]);
                    i = j;
                }
            }

        }
        return profit;
    }
}