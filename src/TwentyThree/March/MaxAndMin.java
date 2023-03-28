package TwentyThree.March;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxAndMin {

    /*
        문제 설명
            문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. - > split
            str에 나타나는 숫자 중 최소값과 최대값을 찾아  -> sort? - index 0, length-1
            이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
            예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고,
            "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

        제한 조건
            s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
     */
    public static void main(String[] args) {
        System.out.println(solution("4 12 1 10"));
    }

    public static String solution(String s) {
        String answer = "";

        List<String> strList = Arrays.asList(s.split(" "));
        List<Integer> intList = strList.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        Collections.sort(intList);

        return intList.get(0) + " " + intList.get(intList.size()-1);
    }
}
