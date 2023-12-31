package TwentyThree.December;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 한국선불카드_코테4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 패턴의 길이 N, 후보 단어의 수 M
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        // 패스워드 패턴
        String passwordPattern = br.readLine();

        // 후보 단어들 리스트
        List<String> candidateWords = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String candidate = br.readLine();
            candidateWords.add(candidate);
        }

        // BFS를 이용한 패스워드 후보 생성
        String result = generatePasswordBFS(N, passwordPattern, candidateWords);

        // 결과 출력
        System.out.println(result);
    }

    private static String generatePasswordBFS(int N, String passwordPattern, List<String> candidateWords) {
        Queue<Node> queue = new LinkedList<>();
        List<String> validPasswords = new ArrayList<>();
        queue.offer(new Node(0, passwordPattern));

        while (!queue.isEmpty()) {
            // ## 은 인덱스 글자수 가 조금 헷갈려서 수정이 필요할 수 있는 곳
            Node node = queue.poll();
            // 패스워드 패턴 순회가 끝나서 추정 유효 비밀번호 생성
            if (node.n == N) {
                validPasswords.add(node.pattern);
                continue;
            }

            int remainCnt = N - node.n; // ##
            for (String word : candidateWords) {
                int newN = node.n + word.length();
                // 글자수가 남은 검사 글자수 보다 크면 X
                if(word.length() > remainCnt ){ // ##
                    continue;
                }

                // 후보 단어가 유효한지
                if(isValid(node.pattern.substring(node.n, newN), word)){
                    // 성공한 단어
                    queue.offer(new Node(newN, node.pattern.substring(0, node.n) + word + passwordPattern.substring(newN, N))); // ##
                }

            }

        }

        //사전순 정렬 후 젤 빠른거 리턴
        Collections.sort(validPasswords);
        return validPasswords.get(0);
    }

    public static boolean isValid(String subPattern, String word) {
        for (int i = 0; i < subPattern.length(); i++) {
            if (subPattern.charAt(i) == word.charAt(i) || subPattern.charAt(i) == '?') {
                continue;
            }
            return false;
        }
        return true;
    }

    public static class Node {
        public int n;
        public String pattern;

        public Node(int n, String pattern) {
            this.n = n;
            this.pattern = pattern;
        }

        // 혹시 후보 word가 중복되면 안될거 같아 고려했지만 굳이 안해도 될거같은느낌..
//        public Node(int n, String pattern, List<String> list) {
//            this.n = n;
//            this.pattern = pattern;
//            this.usingWord = list;
//        }
    }
}
