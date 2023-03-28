package TwentyThree.February;
import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] testArr = {"bear", "a", "an", "land", "ear", "be"};

        System.out.println(longestStrChain(testArr, 4));
    }

    public static int longestStrChain(String[] words, int num){
        // 스트링 체인 점화식
        // f(n) = f(n-1) + 1
        // 메모리제이션, MAP < 단어 , 체인길이 >
        Map<String, Integer> memo = new HashMap<>();

        // 글자수 작은것 부터 내림차순 정렬 (주어진 조건을 Comparator 비교하면서 정렬)
        // 왜 정렬하는가? -> 글자수 작은 거부터 큰거까지 경우의수를 차례차례 메모하며 해나가야 하기 때문, 그렇지않으면 DP 문제가 아님.
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int totalLen = 1;

        // 정렬된 단어들 하나씩 반복문 돌리면서
        for (String word : words) {
            // 첫 체인 길이 1
            int tempLen = 1;

            // 한 단어씩 단어의 글자 수 많큼 반복문 돌리면서 한글자 빼는 모든 경우 보기
            for (int i = 0; i < word.length(); i++) {
                // stringbuffer 보다 builder로 하는 이유 ?
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);

                // 하나뺀 하위단어
                String subWord = sb.toString();
                // 메모한 것 중에 해당 단어가 있는지 , 있으면 그 단어의 체인길이를 비교해서
                // 더 큰 값을 temp에 넣고 저장된 결과값이랑 해서 더 큰 걸 넣음
                if (memo.containsKey(subWord)) {
                    tempLen = Math.max(tempLen, memo.get(subWord) + 1);
                    totalLen = Math.max(totalLen, tempLen);
                }
            }
            // 단어와 체인길이를 *모두 메모해둠 (word, 점화식 결과값 f(n))
            memo.put(word, tempLen);
        }

        return totalLen;
    }

}