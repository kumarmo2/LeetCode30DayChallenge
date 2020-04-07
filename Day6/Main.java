import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Enter space separated words
        String line = br.readLine();
        new Solution().groupAnagrams(line.split(" "));
    }
}

class Word {
    public String word;
    private int[] map;
    private String customHash;

    public Word(String word) {
        this.word = word;
        this.map = new int[26];
    }

    public String getHash() {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int index = c - 97;
            map[index] = map[index] + 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                char c = (char) (i + 97);
                String val = Character.toString(c).concat(Integer.toString(map[i]));
                builder.append(val);
            }
        }
        customHash = builder.toString();
        // System.out.println("hash for: " + this.word + " is: " + this.customHash);
        return customHash;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] anagrams) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String input : anagrams) {
            Word word = new Word(input);
            String hash = word.getHash();
            if (map.containsKey(hash)) {
                map.get(hash).add(input);
            } else {
                List<String> list = new ArrayList<>();
                list.add(input);
                map.put(hash, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}