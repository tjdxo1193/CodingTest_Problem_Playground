package TwentyThree.December;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한국선불카드_코테3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어의 개수 받기
        int wordCount = Integer.parseInt(br.readLine());

        // 각 단어에 대해 처리
        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            String modifiedWord = modifyWord(word);
            System.out.println(modifiedWord);
        }
    }

    private static String modifyWord(String word) {
        StringBuilder modifiedWord = new StringBuilder();
        char prevChar = '\0'; // 이전 문자 초기화

        for (char currentChar : word.toCharArray()) {
            // 현재 문자가 모음이고, 이전 문자도 모음이라면 생략
            if (isVowel(currentChar) && isVowel(prevChar)) {
                continue;
            }

            modifiedWord.append(currentChar);
            prevChar = currentChar;
        }

        return modifiedWord.toString();
    }
    // 주어진 문자가 모음인지 아닌지 메서드
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
