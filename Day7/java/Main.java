import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] inputArr = line.split(" ");
        int[] arr = new int[inputArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        System.out.println(new Solution().countElements(arr));
    }
}

class Solution {
    public int countElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int result = 0;
        int n = arr.length;
        int maxSize = 1002;
        int[] aux = new int[maxSize];
        for (int i = 0; i < n; i++) {
            aux[arr[i]] = aux[arr[i]] + 1;
        }
        for (int i = 0; i < maxSize - 1; i++) {
            if (aux[i] > 0 && aux[i + 1] > 0) {
                result = result + aux[i];
            }
        }
        return result;
    }
}