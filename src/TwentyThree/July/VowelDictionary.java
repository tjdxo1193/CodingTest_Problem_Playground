package TwentyThree.July;

import java.util.HashMap;

public class VowelDictionary {

    /*
    문제 설명
        사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는,
        길이 5 이하의 모든 단어가 수록되어 있습니다.
        사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

        단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

        제한사항
        word의 길이는 1 이상 5 이하입니다.
        word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
     */

    public static void main(String[] args) {
        VowelDictionary dictionary = new VowelDictionary();
        System.out.println(dictionary.solution("AAAAE"));
    }



    public int solution(String word) {
        int answer = 0;
        Character[] alp = {'A', 'E', 'I', 'O', 'U'};
        int[] f = {1, 782, 1563, 2344, 3125};
        int[] s = {1, 157, 313, 469, 625};
        int[] t = {1, 32, 63, 94, 125};
        int[] fo = {1, 7, 13, 19, 25};
        int[] l = {1, 2, 3, 4, 5};
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> second = new HashMap<>();
        HashMap<Character, Integer> third = new HashMap<>();
        HashMap<Character, Integer> fourth = new HashMap<>();
        HashMap<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            first.put(alp[i], f[i]);
            second.put(alp[i], s[i]);
            third.put(alp[i], t[i]);
            fourth.put(alp[i], fo[i]);
            last.put(alp[i], l[i]);
        }
        // 자리수

        if (word.length() > 0) {
            answer += first.get(word.charAt(0));
        }
        if (word.length() > 1) {
            answer += second.get(word.charAt(1));
        }
        if (word.length() > 2) {
            answer += third.get(word.charAt(2));
        }
        if (word.length() > 3) {
            answer += fourth.get(word.charAt(3));
        }
        if (word.length() > 4) {
            answer += last.get(word.charAt(4));
        }

        return answer;
    }
}
