package TwentyThree.June.codingTest;

import java.util.ArrayList;
import java.util.List;

public class StrNumEnWord {

    public static void main(String[] args) {

    }

    /*

        네오와 프로도가 숫자놀이를 하고 있습니다.
        네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를
        건네주면 프로도는 원래 숫자를 찾는 게임입니다.

        다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

        1478 → "one4seveneight"
        234567 → "23four5six7"
        10203 → "1zerotwozero3"
        이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나,
        혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
        s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

        참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

    숫자	영단어
    0	zero
    1	one
    2	two
    3	three
    4	four
    5	five
    6	six
    7	seven
    8	eight
    9	nine
     */

    private List<String> NUMBER_LIST = new ArrayList<>();
    public int solution(String s) {
        int answer = 0;

        NUMBER_LIST.add("zero");
        NUMBER_LIST.add("one");
        NUMBER_LIST.add("two");
        NUMBER_LIST.add("three");
        NUMBER_LIST.add("four");
        NUMBER_LIST.add("five");
        NUMBER_LIST.add("six");
        NUMBER_LIST.add("seven");
        NUMBER_LIST.add("eight");
        NUMBER_LIST.add("nine");

        for (int i = 0; i < NUMBER_LIST.size(); i++) {
            if (s.contains(NUMBER_LIST.get(i))) {
                s = s.replaceAll(NUMBER_LIST.get(i) , String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }

}