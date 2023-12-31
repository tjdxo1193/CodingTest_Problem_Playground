package TwentyThree.December;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 한국선불_코테4_1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 입력 받기
            int N = scanner.nextInt(); // 동이가 알아낸 패스워드 패턴의 길이
            int M = scanner.nextInt(); // 후보 단어의 수

            scanner.nextLine(); // 개행 문자 처리

            String pattern = scanner.nextLine(); // 패스워드 패턴 입력

            // 후보 단어 리스트 초기화
            ArrayList<String> candidates = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                candidates.add(scanner.nextLine());
            }

            // 패스워드 패턴에 대한 후보 단어들을 이용해 가능한 패스워드 생성
            ArrayList<String> passwords = generatePasswords(pattern, candidates);
            // 생성된 패스워드들을 사전순으로 정렬
            Collections.sort(passwords);

            // 결과 출력
            System.out.println(passwords.get(0));
        }

        // 패스워드 패턴에 대한 후보 단어들을 이용해 가능한 패스워드 생성하는 메서드
        private static ArrayList<String> generatePasswords(String pattern, ArrayList<String> candidates) {
            ArrayList<String> passwords = new ArrayList<>();

            for (String candidate : candidates) {
                // 패스워드 길이와 패턴이 일치하는 경우에만 확인
                if (candidate.length() == pattern.length()) {
                    boolean valid = true;

                    // 패턴에 따라 패스워드의 각 글자를 확인
                    for (int i = 0; i < pattern.length(); i++) {
                        char patternChar = pattern.charAt(i);
                        char candidateChar = candidate.charAt(i);

                        // 패턴의 글자가 '?'가 아니면서 패스워드와 일치하지 않으면 유효하지 않음
                        if (patternChar != '?' && patternChar != candidateChar) {
                            valid = false;
                            break;
                        }
                    }

                    // 패턴을 위반하지 않는 경우에만 리스트에 추가
                    if (valid) {
                        passwords.add(candidate);
                    }
                }
            }

            return passwords;
        }
    }
