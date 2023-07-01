package TwentyThree.June.codingTest;

import java.util.LinkedList;
import java.util.Queue;

public class Babbling {

/*

        문제 설명
    머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
    조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과
    네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고
    연속해서 같은 발음을 하는 것을 어려워합니다.
    문자열 배열 babbling 이 매개변수로 주어질 때,
    머쓱이의 조카가 발음할 수 있는 단어의 개수를
    return 하도록 solution 함수를 완성해주세요.

 */
    private final static String AYA = "aya";
    private final static String YE = "ye";
    private final static String WOO = "woo";
    private final static String MA = "ma";

    public static void main(String[] args) {

        Babbling babbling = new Babbling();
        System.out.println(babbling.solution(new String[]{"aya", "yee", "u", "maa"}));
    }
    public int solution(String[] babbling) {
        int answer = 0;
        String target = "";
        String useingStr = "";
        String[] strArr = new String[]{AYA, YE, WOO, MA};
        LinkedList<String> activeList = new LinkedList<>();
        String currentStr = "";

        for (int i = 0; i < babbling.length; i++) {
            target = babbling[i];
            if (target.contains(AYA)) {
                activeList.add(AYA);
            }
            if (target.contains(YE)) {
                activeList.add(YE);
            }
            if (target.contains(WOO)) {
                activeList.add(WOO);
            }
            if (target.contains(MA)) {
                activeList.add(MA);
            }
            while (activeList.size() != 0) {
                for (int j = 0; j <= strArr.length; j++) {
                    currentStr = activeList.get(j);

                    if(target.length() == 0){

                    }

                    if (strArr[j].equals(useingStr)) {
                        continue;
                    }
                    if (target.substring(0, currentStr.length()-1).equals(currentStr)) {
                        useingStr = currentStr;
                        target = target.substring(strArr[i].length() - 1);
                    }
                }

                if (target.length() == 0) {
                    answer++;
                    break;
                }

                if (activeList.size() == 0) {
                    break;
                }

            }


        }
        return answer;
    }
    // 포기.. 정답봄.. ?? 아놔 생각 잘못했네

    //     public int solution(String[] babbling) {
    //        int answer = 0;
    //        for (String s : babbling) {
    //            s = s.replaceAll("ayaaya|yeye|woowoo|mama", " ");
    //            s = s.replaceAll("aya|ye|woo|ma", "");
    //            if (s.equals(""))
    //                answer++;
    //        }
    //        return answer;
    //    }

}
