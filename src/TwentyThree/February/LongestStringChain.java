package TwentyThree.February;
import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] testArr = {"bear", "a", "an", "land", "ear", "be"};

        System.out.println(longestStrChain(testArr, 4));
    }

    public static int longestStrChain(String[] words, int num){
        Map<String, Integer> memo = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int totalLen = 1;

        for (String word : words) {
            int tempLen = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String nextWord = sb.toString();
                if (memo.containsKey(nextWord)) {
                    tempLen = Math.max(tempLen, memo.get(nextWord) + 1);
                    totalLen = Math.max(totalLen, tempLen);
                }
            }
            memo.put(word, tempLen);
        }

        return totalLen;
    }

}