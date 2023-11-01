package TwentyThree.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeBigNumber {
    /*
    큰 수 만들기
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
입출력 예
number	k	return
"1924"	2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"
     */
    public static void main(String[] args) {
        MakeBigNumber bigNumber = new MakeBigNumber();
        System.out.println(bigNumber.solution("1231234", 3));
        // 3
    }
    // 10(시간 초과)
    public String solution(String number, int k) {
        List<Integer> numbers = Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> removeIdxs = new ArrayList<>();
        int numberToRemoveCnt = k;
        int startIdx = 0;
        for (int i = 0; i < numbers.size()-numberToRemoveCnt; i++) {
            int targetIdx = 0;
            int currentNum = 0;
            // 순서대로 선택된것은 하나씩
            for (int j = i; j <= Math.min(i + numberToRemoveCnt, numbers.size()); j++) {
                if (numbers.get(j) > currentNum) {
                    currentNum = numbers.get(j);
                    targetIdx = j;
                }
            }
            // i 인덱스 부터 삭제할 수 만큼 탐색하면서 가장 큰 인덱스까지 다 삭제하기
            for (int l = i; l < targetIdx; targetIdx--) {
                numbers.remove(l);
                numberToRemoveCnt--;
            }

            if (numberToRemoveCnt == 0) {
                break;
            }
        }

        for (int i = 0; i < numberToRemoveCnt; numberToRemoveCnt--) {
            numbers.remove(numbers.size()-1);
        }


        StringBuilder sb = new StringBuilder();
        for (Integer item : numbers) {
            sb.append(item);
        }
        return sb.toString();
    }
    // 간단한 풀이 제거 없이 max값을 넣기만함
    public String solution2(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
