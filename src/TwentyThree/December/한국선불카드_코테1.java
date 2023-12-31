package TwentyThree.December;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 한국선불카드_코테1 {

    public static void main(String[] args) throws IOException {
        //프로그램의 시작부
        // 응모권 수 및 회원번호 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ticketNumber = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        List<Integer> memberNumbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            memberNumbers.add(Integer.parseInt(input[i]));
        }
        // 연속된 수를 제거 하고 오름차순으로 출력하기 위해 정렬
        Collections.sort(memberNumbers);

        List<Integer> duplicateNumbers = new ArrayList<>();
        Integer duplicateNum = memberNumbers.get(0);
        for (int i = 1; i < memberNumbers.size(); i++) {
            if (Objects.equals(memberNumbers.get(i), duplicateNum)) {
                duplicateNumbers.add(duplicateNum);
                continue;
            }

            duplicateNum = memberNumbers.get(i);
        }

        memberNumbers.removeAll(duplicateNumbers);

        // 정렬된 회원번호 출력
        for (int i = 0; i < memberNumbers.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(memberNumbers.get(i));
        }
    }
}
